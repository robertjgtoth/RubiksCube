package com.robertjgtoth.rubiks.view;

import com.robertjgtoth.rubiks.controller.CubeController;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.universe.*;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by rtoth on 11/24/2014.
 */
public class CubeViewer extends Applet implements KeyListener {

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
        // Setup our layout and base universe
        setLayout(new BorderLayout());
        Canvas3D canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        universe = new SimpleUniverse(canvas);
        BranchGroup scene = createSceneGraph();
        universe.getViewingPlatform().setNominalViewingTransform();
        scene.compile();
        universe.addBranchGraph(scene);

        Label title = new Label("Interactive Rubik's Cube");
        title.setAlignment(Label.CENTER);

        Panel instructionsPanel = new Panel(new GridLayout(2,1));
        Label instructionsTop = new Label(
                "ROTATION: \u2191: Up, \u2193: Down, \u2190: Clockwise, \u2192: Counter-Clockwise"

        );
        instructionsTop.setAlignment(Label.CENTER);
        Label instructionsBottom = new Label(
                "U: Up, D: Down, L: Left, R: Right, F: Front, B: Back"
        );
        instructionsBottom.setAlignment(Label.CENTER);
        instructionsPanel.add(instructionsTop);
        instructionsPanel.add(instructionsBottom);

        add(APPLET_POSITION_TOP, title);
        add(APPLET_POSITION_CENTER, canvas);
        add(APPLET_POSITION_BOTTOM, instructionsPanel);

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
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
        rotation.rotX(Math.PI/8);
        temp.rotY(-Math.PI / 8);
        rotation.mul(temp);
        objRotate.setTransform(rotation);


        cubeController.attachTransformGroup(objRotate);
        root.addChild(objRotate);

        MouseRotate mouseRotate = new MouseRotate();
        mouseRotate.setTransformGroup(objRotate);
        mouseRotate.setSchedulingBounds(new BoundingSphere());
        root.addChild(mouseRotate);

        return root;
    }

    public void destroy()
    {
        universe.removeAllLocales();
    }

    public void keyPressed(KeyEvent event)
    {
        cubeController.processInput(event.getKeyCode());
    }

    public void keyReleased(KeyEvent event)
    { /* Nothing to do */ }

    public void keyTyped(KeyEvent event)
    { /* Nothing to do */ }

}
