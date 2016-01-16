package com.robertjgtoth.rubiks.view;

import com.robertjgtoth.rubiks.controller.CubeController;
import com.sun.j3d.utils.universe.SimpleUniverse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.vecmath.Vector3f;


/**
 * Created by rtoth on 11/24/2014.
 */
public class CubeViewer extends JApplet implements KeyListener
{
    private static final int DEFAULT_APPLET_WIDTH = 800;
    private static final int DEFAULT_APPLET_HEIGHT = 750;

    private static final String APPLET_POSITION_CENTER = "Center";
    private static final String APPLET_POSITION_TOP = "North";
    private static final String APPLET_POSITION_BOTTOM = "South";

    private CubeController cubeController;

    private SimpleUniverse universe;
    private TransformGroup objRotate;

    public CubeViewer()
    {
        cubeController = new CubeController();
    }

    public void init()
    {
        try
        {
            SwingUtilities.invokeAndWait(new Runnable()
            {
                @Override
                public void run()
                {
                    initGui();
                }
            });
        }
        catch (Exception e)
        {
            System.err.println("Caught exception creating UI: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void initGui()
    {
        // Setup our layout and base universe
        setLayout(new BorderLayout());
        Canvas3D canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        universe = new SimpleUniverse(canvas);
        BranchGroup scene = createSceneGraph();
        universe.getViewingPlatform().setNominalViewingTransform();
        scene.compile();
        universe.addBranchGraph(scene);

        JLabel title = new JLabel("ESC: Reset | ENTER: Scramble", SwingConstants.CENTER);

        JPanel instructionsPanel = new JPanel(new GridLayout(2, 1));
        JLabel instructionsTop = new JLabel(
            "ROTATION: \u2191: Up | \u2193: Down | \u2190: Clockwise | \u2192: Counter-Clockwise",
            SwingConstants.CENTER

        );
        JLabel instructionsBottom = new JLabel(
            "U: Up | D: Down | L: Left | R: Right | F: Front | B: Back",
            SwingConstants.CENTER
        );
        instructionsPanel.add(instructionsTop);
        instructionsPanel.add(instructionsBottom);

        getContentPane().add(APPLET_POSITION_TOP, title);
        getContentPane().add(APPLET_POSITION_CENTER, canvas);
        getContentPane().add(APPLET_POSITION_BOTTOM, instructionsPanel);

        setSize(new Dimension(DEFAULT_APPLET_WIDTH, DEFAULT_APPLET_HEIGHT));

        canvas.addKeyListener(this);
        canvas.setFocusable(true);
        canvas.requestFocusInWindow();
    }

    public BranchGroup createSceneGraph()
    {
        BranchGroup root = new BranchGroup();

        Transform3D transform = new Transform3D();
        transform.setTranslation(new Vector3f(0.0f, 0.0f, 0.0f));

        objRotate = new TransformGroup(transform);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        // Some initial perspective rotation for fun
        Transform3D rotation = new Transform3D();
        Transform3D temp = new Transform3D();
        rotation.rotX(Math.PI / 8);
        temp.rotY(-Math.PI / 8);
        rotation.mul(temp);
        objRotate.setTransform(rotation);


        cubeController.attachTransformGroup(objRotate);
        root.addChild(objRotate);

        return root;
    }

    public void destroy()
    {
        universe.removeAllLocales();
    }

    public void keyPressed(KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_SHIFT)
        {
            cubeController.setMoveInversion(true);
        }
        else
        {
            cubeController.processInput(event.getKeyCode());
        }
    }

    public void keyReleased(KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_SHIFT)
        {
            cubeController.setMoveInversion(false);
        }
    }

    public void keyTyped(KeyEvent event)
    {
        /* Nothing to do */
    }
}
