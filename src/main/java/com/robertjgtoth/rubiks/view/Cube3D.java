package com.robertjgtoth.rubiks.view;

import com.robertjgtoth.rubiks.model.Rotation;
import com.robertjgtoth.rubiks.model.orientation.Orientation;
import com.robertjgtoth.rubiks.model.orientation.WhiteUpRedFront;

import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.vecmath.Point3f;

public class Cube3D extends Shape3D
{
    private static final float[] VERTS = {
        // front face
        0.95f, -0.95f, 0.95f,
        0.95f, 0.95f, 0.95f,
        -0.95f, 0.95f, 0.95f,
        -0.95f, -0.95f, 0.95f,
        // back face
        -0.95f, -0.95f, -0.95f,
        -0.95f, 0.95f, -0.95f,
        0.95f, 0.95f, -0.95f,
        0.95f, -0.95f, -0.95f,
        // right face
        0.95f, -0.95f, -0.95f,
        0.95f, 0.95f, -0.95f,
        0.95f, 0.95f, 0.95f,
        0.95f, -0.95f, 0.95f,
        // left face
        -0.95f, -0.95f, 0.95f,
        -0.95f, 0.95f, 0.95f,
        -0.95f, 0.95f, -0.95f,
        -0.95f, -0.95f, -0.95f,
        // top face
        0.95f, 0.95f, 0.95f,
        0.95f, 0.95f, -0.95f,
        -0.95f, 0.95f, -0.95f,
        -0.95f, 0.95f, 0.95f,
        // bottom face
        -0.95f, -0.95f, 0.95f,
        -0.95f, -0.95f, -0.95f,
        0.95f, -0.95f, -0.95f,
        0.95f, -0.95f, 0.95f,
    };

    private static final Class DEFAULT_ORIENTATION = WhiteUpRedFront.class;

    private Point3f center;
    private Orientation orientation;

    public Cube3D(Cube3D other)
    {
        this.center = new Point3f(other.center);
        this.orientation = other.orientation;
    }

    public Cube3D(Point3f center)
    {
        this.center = center;
        QuadArray cube = new QuadArray(24, QuadArray.COORDINATES |
            QuadArray.COLOR_3);

        cube.setCapability(QuadArray.ALLOW_COLOR_READ);
        cube.setCapability(QuadArray.ALLOW_COLOR_WRITE);

        float offsetVerts[] = new float[VERTS.length];
        for (int i = 0; i < VERTS.length; i += 3)
        {
            try
            {
                offsetVerts[i] = VERTS[i] + center.x;
                offsetVerts[i + 1] = VERTS[i + 1] + center.y;
                offsetVerts[i + 2] = VERTS[i + 2] + center.z;
            }
            catch (ArrayIndexOutOfBoundsException obe)
            {
                throw new IllegalArgumentException("Dimensions don't match up..");
            }
        }

        double scale = 0.1;

        float scaledVerts[] = new float[offsetVerts.length];
        for (int i = 0; i < offsetVerts.length; i++)
        {
            scaledVerts[i] = offsetVerts[i] * (float) scale;
        }

        try
        {
            this.orientation = (Orientation) DEFAULT_ORIENTATION.newInstance();
        }
        catch (InstantiationException ie)
        {
            System.err.println("Error instantiating default orientation " + ie.getMessage());
        }
        catch (IllegalAccessException iae)
        {
            System.err.println("Error instantiating default orientation " + iae.getMessage());
        }

        cube.setCoordinates(0, scaledVerts);
        cube.setColors(0, this.orientation.getColors());

        this.setGeometry(cube);
    }

    public void resetOrientation()
    {
        try
        {
            setAndApplyOrientation((Orientation) DEFAULT_ORIENTATION.newInstance());
        }
        catch (InstantiationException ie)
        {
            System.err.println("Error instantiating default orientation " + ie.getMessage());
        }
        catch (IllegalAccessException iae)
        {
            System.err.println("Error instantiating default orientation " + iae.getMessage());
        }
    }

    public void applyRotation(Rotation rotation, Cube3D other)
    {
        setAndApplyOrientation(other.orientation.move(rotation));
    }

    private void setAndApplyOrientation(Orientation orientation)
    {
        QuadArray cube = (QuadArray) this.getGeometry();
        this.orientation = orientation;
        cube.setColors(0, this.orientation.getColors());
    }
}
