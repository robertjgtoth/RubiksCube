package com.robertjgtoth.rubiks.view;

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

    private static final int CUBIES_PER_CUBE = 27;

    private Cube3D cubies[] = new Cube3D[CUBIES_PER_CUBE];

    private SimpleUniverse universe;
    private TransformGroup objRotate;

    public void init()
    {
        // Setup our layout and base universe
        setLayout(new BorderLayout());
        Canvas3D canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        add("Center", canvas);
        universe = new SimpleUniverse(canvas);

        BranchGroup scene = createSceneGraph();

        universe.getViewingPlatform().setNominalViewingTransform();
        scene.compile();
        universe.addBranchGraph(scene);

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    public BranchGroup createSceneGraph()
    {
        BranchGroup root = new BranchGroup();

        cubies[0] = new Cube3D(new Point3f(-2.0f, 2.0f, -2.0f));
        cubies[1] = new Cube3D(new Point3f(0.0f, 2.0f, -2.0f));
        cubies[2] = new Cube3D(new Point3f(2.0f, 2.0f, -2.0f));
        cubies[3] = new Cube3D(new Point3f(-2.0f, 0.0f, -2.0f));
        cubies[4] = new Cube3D(new Point3f(0.0f, 0.0f, -2.0f));
        cubies[5] = new Cube3D(new Point3f(2.0f, 0.0f, -2.0f));
        cubies[6] = new Cube3D(new Point3f(-2.0f, -2.0f, -2.0f));
        cubies[7] = new Cube3D(new Point3f(0.0f, -2.0f, -2.0f));
        cubies[8] = new Cube3D(new Point3f(2.0f, -2.0f, -2.0f));

        cubies[9] = new Cube3D(new Point3f(-2.0f, 2.0f, 0.0f));
        cubies[10] = new Cube3D(new Point3f(0.0f, 2.0f, 0.0f));
        cubies[11] = new Cube3D(new Point3f(2.0f, 2.0f, 0.0f));
        cubies[12] = new Cube3D(new Point3f(-2.0f, 0.0f, 0.0f));
        cubies[13] = new Cube3D(new Point3f(0.0f, 0.0f, 0.0f));
        cubies[14] = new Cube3D(new Point3f(2.0f, 0.0f, 0.0f));
        cubies[15] = new Cube3D(new Point3f(-2.0f, -2.0f, 0.0f));
        cubies[16] = new Cube3D(new Point3f(0.0f, -2.0f, 0.0f));
        cubies[17] = new Cube3D(new Point3f(2.0f, -2.0f, 0.0f));

        cubies[18] = new Cube3D(new Point3f(-2.0f, 2.0f, 2.0f));
        cubies[19] = new Cube3D(new Point3f(0.0f, 2.0f, 2.0f));
        cubies[20] = new Cube3D(new Point3f(2.0f, 2.0f, 2.0f));
        cubies[21] = new Cube3D(new Point3f(-2.0f, 0.0f, 2.0f));
        cubies[22] = new Cube3D(new Point3f(0.0f, 0.0f, 2.0f));
        cubies[23] = new Cube3D(new Point3f(2.0f, 0.0f, 2.0f));
        cubies[24] = new Cube3D(new Point3f(-2.0f, -2.0f, 2.0f));
        cubies[25] = new Cube3D(new Point3f(0.0f, -2.0f, 2.0f));
        cubies[26] = new Cube3D(new Point3f(2.0f, -2.0f, 2.0f));

        Transform3D transform = new Transform3D();
        transform.setTranslation(new Vector3f(0.0f, 0.0f, 0.0f));

        objRotate = new TransformGroup(transform);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        for (Cube3D cubie : cubies)
        {
            objRotate.addChild(cubie);
        }
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
        Move move;
        int code = event.getKeyCode();
        switch (code)
        {
            case KeyEvent.VK_A:
                move = Move.LEFT;
                break;
            case KeyEvent.VK_D:
                move = Move.RIGHT;
                break;
            case KeyEvent.VK_W:
                move = Move.UP;
                break;
            case KeyEvent.VK_S:
                move = Move.DOWN;
                break;
            default:
                System.out.println("Unrecognized Key: " + event.getKeyChar());
                return;
        }

        for (Cube3D cubie : cubies)
        {
            cubie.updateColors(move);
        }
    }

    public void keyReleased(KeyEvent event)
    {}

    public void keyTyped(KeyEvent event)
    {}

}
