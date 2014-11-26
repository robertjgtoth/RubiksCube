package com.robertjgtoth.rubiks.view;

import com.robertjgtoth.rubiks.model.Rotation;
import com.robertjgtoth.rubiks.model.orientation.WhiteUpRedFront;
import com.robertjgtoth.rubiks.model.orientation.Orientation;

import javax.media.j3d.*;
import javax.vecmath.Point3f;

public class Cube3D extends Shape3D {

    private static final float[] VERTS = {
            // front face
            0.95f, -0.95f,  0.95f,
            0.95f,  0.95f,  0.95f,
            -0.95f,  0.95f,  0.95f,
            -0.95f, -0.95f,  0.95f,
            // back face
            -0.95f, -0.95f, -0.95f,
            -0.95f,  0.95f, -0.95f,
            0.95f,  0.95f, -0.95f,
            0.95f, -0.95f, -0.95f,
            // right face
            0.95f, -0.95f, -0.95f,
            0.95f,  0.95f, -0.95f,
            0.95f,  0.95f,  0.95f,
            0.95f, -0.95f,  0.95f,
            // left face
            -0.95f, -0.95f,  0.95f,
            -0.95f,  0.95f,  0.95f,
            -0.95f,  0.95f, -0.95f,
            -0.95f, -0.95f, -0.95f,
            // top face
            0.95f,  0.95f,  0.95f,
            0.95f,  0.95f, -0.95f,
            -0.95f,  0.95f, -0.95f,
            -0.95f,  0.95f,  0.95f,
            // bottom face
            -0.95f, -0.95f,  0.95f,
            -0.95f, -0.95f, -0.95f,
            0.95f, -0.95f, -0.95f,
            0.95f, -0.95f,  0.95f,
    };

    private Orientation orientation;

    public Cube3D(Point3f center)
    {
        QuadArray cube = new QuadArray(24, QuadArray.COORDINATES |
                QuadArray.COLOR_3);

        cube.setCapability(QuadArray.ALLOW_COLOR_READ);
        cube.setCapability(QuadArray.ALLOW_COLOR_WRITE);

        float offsetVerts[] = new float[VERTS.length];
        for  (int i = 0; i < VERTS.length; i += 3)
        {
            try
            {
                offsetVerts[i] = VERTS[i] + center.x;
                offsetVerts[i+1] = VERTS[i+1] + center.y;
                offsetVerts[i+2] = VERTS[i+2] + center.z;
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

        this.orientation = new WhiteUpRedFront();

        cube.setCoordinates(0, scaledVerts);
        cube.setColors(0, this.orientation.getColors());

        this.setGeometry(cube);
    }

    public void applyRotation(Rotation rotation)
    {
        applyRotation(rotation, this);
    }

    public void applyRotation(Rotation rotation, Cube3D other)
    {
        QuadArray cube = (QuadArray) this.getGeometry();
        this.orientation = other.orientation.move(rotation);
        cube.setColors(0, this.orientation.getColors());
    }
}
