package com.robertjgtoth.rubiks.view;

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

    private static final float[] COLORS = {
            // front face (red)
            0.95f, 0.0f, 0.0f,
            0.95f, 0.0f, 0.0f,
            0.95f, 0.0f, 0.0f,
            0.95f, 0.0f, 0.0f,
            // back face (orange)
            0.95f, 0.65f, 0.0f,
            0.95f, 0.65f, 0.0f,
            0.95f, 0.65f, 0.0f,
            0.95f, 0.65f, 0.0f,
            // right face (blue)
            0.0f, 0.0f, 0.95f,
            0.0f, 0.0f, 0.95f,
            0.0f, 0.0f, 0.95f,
            0.0f, 0.0f, 0.95f,
            // left face (green)
            0.0f, 0.95f, 0.0f,
            0.0f, 0.95f, 0.0f,
            0.0f, 0.95f, 0.0f,
            0.0f, 0.95f, 0.0f,
            // top face (white)
            0.95f, 0.95f, 0.95f,
            0.95f, 0.95f, 0.95f,
            0.95f, 0.95f, 0.95f,
            0.95f, 0.95f, 0.95f,
            // bottom face (yellow)
            0.95f, 0.95f, 0.0f,
            0.95f, 0.95f, 0.0f,
            0.95f, 0.95f, 0.0f,
            0.95f, 0.95f, 0.0f,
    };

    double scale;

    public Cube3D(double scale, Point3f center)
    {
        QuadArray cube = new QuadArray(24, QuadArray.COORDINATES |
                QuadArray.COLOR_3);

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

        float scaledVerts[] = new float[offsetVerts.length];
        for (int i = 0; i < offsetVerts.length; i++)
            scaledVerts[i] = offsetVerts[i] * (float)scale;

        cube.setCoordinates(0, scaledVerts);
        cube.setColors(0, COLORS);

        this.setGeometry(cube);

        this.scale = scale;
    }
}
