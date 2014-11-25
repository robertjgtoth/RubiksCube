package com.robertjgtoth.graphics.cube;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.applet.Applet;
import java.awt.*;


/**
 * Created by rtoth on 11/24/2014.
 */
public class CubeViewer extends Applet {

    SimpleUniverse universe;

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
    }

    public BranchGroup createSceneGraph()
    {
        BranchGroup root = new BranchGroup();

        Cube cubies[] = new Cube[27];

        cubies[0] = new Cube(0.1, new Point3f(-2.0f, 0.0f, 2.0f));
        cubies[1] = new Cube(0.1, new Point3f(0.0f, 0.0f, 2.0f));
        cubies[2] = new Cube(0.1, new Point3f(2.0f, 0.0f, 2.0f));
        cubies[3] = new Cube(0.1, new Point3f(-2.0f, 0.0f, 0.0f));
        cubies[4] = new Cube(0.1, new Point3f(0.0f, 0.0f, 0.0f));
        cubies[5] = new Cube(0.1, new Point3f(2.0f, 0.0f, 0.0f));
        cubies[6] = new Cube(0.1, new Point3f(-2.0f, 0.0f, -2.0f));
        cubies[7] = new Cube(0.1, new Point3f(0.0f, 0.0f, -2.0f));
        cubies[8] = new Cube(0.1, new Point3f(2.0f, 0.0f, -2.0f));

        cubies[9]= new Cube(0.1, new Point3f(-2.0f, -2.0f, 2.0f));
        cubies[10] = new Cube(0.1, new Point3f(0.0f, -2.0f, 2.0f));
        cubies[11] = new Cube(0.1, new Point3f(2.0f, -2.0f, 2.0f));
        cubies[12] = new Cube(0.1, new Point3f(-2.0f, -2.0f, 0.0f));
        cubies[13] = new Cube(0.1, new Point3f(0.0f, -2.0f, 0.0f));
        cubies[14] = new Cube(0.1, new Point3f(2.0f, -2.0f, 0.0f));
        cubies[15] = new Cube(0.1, new Point3f(-2.0f, -2.0f, -2.0f));
        cubies[16] = new Cube(0.1, new Point3f(0.0f, -2.0f, -2.0f));
        cubies[17] = new Cube(0.1, new Point3f(2.0f, -2.0f, -2.0f));

        cubies[18] = new Cube(0.1, new Point3f(-2.0f, 2.0f, 2.0f));
        cubies[19] = new Cube(0.1, new Point3f(0.0f, 2.0f, 2.0f));
        cubies[20] = new Cube(0.1, new Point3f(2.0f, 2.0f, 2.0f));
        cubies[21] = new Cube(0.1, new Point3f(-2.0f, 2.0f, 0.0f));
        cubies[22] = new Cube(0.1, new Point3f(0.0f, 2.0f, 0.0f));
        cubies[23] = new Cube(0.1, new Point3f(2.0f, 2.0f, 0.0f));
        cubies[24] = new Cube(0.1, new Point3f(-2.0f, 2.0f, -2.0f));
        cubies[25] = new Cube(0.1, new Point3f(0.0f, 2.0f, -2.0f));
        cubies[26] = new Cube(0.1, new Point3f(2.0f, 2.0f, -2.0f));

        Transform3D transform = new Transform3D();
        transform.setTranslation(new Vector3f(0.0f, 0.0f, 0.0f));

        TransformGroup objRotate = new TransformGroup(transform);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        for (Cube cubie : cubies)
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


    public static void main(String args[])
    {
        Frame frame = new MainFrame(new CubeViewer(), 500, 500);
    }

}
