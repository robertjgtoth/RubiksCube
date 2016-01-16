package com.robertjgtoth.rubiks.model;

import com.robertjgtoth.rubiks.view.Cube3D;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

import javax.vecmath.Point3f;

/**
 * Created by rtoth on 11/26/2014.
 */
public class Cube
{
    private static final int CUBIES_PER_CUBE = 27;
    private static final int CUBIES_PER_FACE = 9;
    private static final int CENTER_PIVOT_CUBIE_INDEX = 13;

    private static final Map<Move, Rotation> rotationsByMove =
        new HashMap<Move, Rotation>();
    static
    {
        rotationsByMove.put(Move.UP, Rotation.CLOCK);
        rotationsByMove.put(Move.DOWN, Rotation.COUNTER_CLOCK);
        rotationsByMove.put(Move.LEFT, Rotation.DOWN);
        rotationsByMove.put(Move.RIGHT, Rotation.UP);
        rotationsByMove.put(Move.FRONT, Rotation.RIGHT);
        rotationsByMove.put(Move.BACK, Rotation.LEFT);

    }

    private Cube3D cubies[] = new Cube3D[CUBIES_PER_CUBE];

    public Cube()
    {
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
    }

    public Cube(Cube other)
    {
        for (int i = 0; i < cubies.length; i++)
        {
            cubies[i] = new Cube3D(other.cubies[i]);
        }
    }

    public Cube3D[] getCubies()
    {
        return cubies;
    }

    public void reset()
    {
        for (Cube3D cubie : cubies)
        {
            cubie.resetOrientation();
        }
    }

    public void scramble()
    {
        for (int i = 0; i < 28; i++)
        {
            if (i % 2 == 0)
            {
                applyMove(Move.getRandomMove());
            }
            else
            {
                applyInverseMove(Move.getRandomMove());
            }
        }
    }

    public Cube3D getCenterPivot()
    {
        return cubies[CENTER_PIVOT_CUBIE_INDEX];
    }

    public void applyFullCubeRotation(Rotation rotation)
    {
        Cube3D[] transform = getFullCubeTransform(rotation);
        applyRotation(rotation, cubies, transform);
    }

    public void applyMove(Move move)
    {
        Cube3D[] face = getFace(move);
        Cube3D[] transform = getTransformedFace(face);
        Rotation rotation = rotationsByMove.get(move);
        applyRotation(rotation, face, transform);
    }

    public void applyInverseMove(Move move)
    {
        Cube3D[] face = getFace(move);
        Cube3D[] transform = getInverseTransformedFace(face);
        Rotation rotation = Rotation.getInverse(rotationsByMove.get(move));
        applyRotation(rotation, face, transform);
    }

    private void applyRotation(Rotation rotation, Cube3D[] cubiesToRotate, Cube3D[] nextCubies)
    {
        for (int i = 0; i < cubiesToRotate.length; i++)
        {
            cubiesToRotate[i].applyRotation(rotation, nextCubies[i]);
        }
    }

    private Cube3D[] getFullCubeTransform(Rotation rotation)
    {
        Cube3D[] transform = new Cube3D[CUBIES_PER_CUBE];
        switch (rotation)
        {
            case UP:
                transform[0] = new Cube3D(cubies[18]);
                transform[1] = new Cube3D(cubies[19]);
                transform[2] = new Cube3D(cubies[20]);
                transform[3] = new Cube3D(cubies[9]);
                transform[4] = new Cube3D(cubies[10]);
                transform[5] = new Cube3D(cubies[11]);
                transform[6] = new Cube3D(cubies[0]);
                transform[7] = new Cube3D(cubies[1]);
                transform[8] = new Cube3D(cubies[2]);

                transform[9] = new Cube3D(cubies[21]);
                transform[10] = new Cube3D(cubies[22]);
                transform[11] = new Cube3D(cubies[23]);
                transform[12] = new Cube3D(cubies[12]);
                transform[13] = new Cube3D(cubies[13]);
                transform[14] = new Cube3D(cubies[14]);
                transform[15] = new Cube3D(cubies[3]);
                transform[16] = new Cube3D(cubies[4]);
                transform[17] = new Cube3D(cubies[5]);

                transform[18] = new Cube3D(cubies[24]);
                transform[19] = new Cube3D(cubies[25]);
                transform[20] = new Cube3D(cubies[26]);
                transform[21] = new Cube3D(cubies[15]);
                transform[22] = new Cube3D(cubies[16]);
                transform[23] = new Cube3D(cubies[17]);
                transform[24] = new Cube3D(cubies[6]);
                transform[25] = new Cube3D(cubies[7]);
                transform[26] = new Cube3D(cubies[8]);
                break;
            case DOWN:
                transform[0] = new Cube3D(cubies[6]);
                transform[1] = new Cube3D(cubies[7]);
                transform[2] = new Cube3D(cubies[8]);
                transform[3] = new Cube3D(cubies[15]);
                transform[4] = new Cube3D(cubies[16]);
                transform[5] = new Cube3D(cubies[17]);
                transform[6] = new Cube3D(cubies[24]);
                transform[7] = new Cube3D(cubies[25]);
                transform[8] = new Cube3D(cubies[26]);

                transform[9] = new Cube3D(cubies[3]);
                transform[10] = new Cube3D(cubies[4]);
                transform[11] = new Cube3D(cubies[5]);
                transform[12] = new Cube3D(cubies[12]);
                transform[13] = new Cube3D(cubies[13]);
                transform[14] = new Cube3D(cubies[14]);
                transform[15] = new Cube3D(cubies[21]);
                transform[16] = new Cube3D(cubies[22]);
                transform[17] = new Cube3D(cubies[23]);

                transform[18] = new Cube3D(cubies[0]);
                transform[19] = new Cube3D(cubies[1]);
                transform[20] = new Cube3D(cubies[2]);
                transform[21] = new Cube3D(cubies[9]);
                transform[22] = new Cube3D(cubies[10]);
                transform[23] = new Cube3D(cubies[11]);
                transform[24] = new Cube3D(cubies[18]);
                transform[25] = new Cube3D(cubies[19]);
                transform[26] = new Cube3D(cubies[20]);
                break;
            case CLOCK:
                transform[0] = new Cube3D(cubies[18]);
                transform[1] = new Cube3D(cubies[9]);
                transform[2] = new Cube3D(cubies[0]);
                transform[3] = new Cube3D(cubies[21]);
                transform[4] = new Cube3D(cubies[12]);
                transform[5] = new Cube3D(cubies[3]);
                transform[6] = new Cube3D(cubies[24]);
                transform[7] = new Cube3D(cubies[15]);
                transform[8] = new Cube3D(cubies[6]);

                transform[9] = new Cube3D(cubies[19]);
                transform[10] = new Cube3D(cubies[10]);
                transform[11] = new Cube3D(cubies[1]);
                transform[12] = new Cube3D(cubies[22]);
                transform[13] = new Cube3D(cubies[13]);
                transform[14] = new Cube3D(cubies[4]);
                transform[15] = new Cube3D(cubies[25]);
                transform[16] = new Cube3D(cubies[16]);
                transform[17] = new Cube3D(cubies[7]);

                transform[18] = new Cube3D(cubies[20]);
                transform[19] = new Cube3D(cubies[11]);
                transform[20] = new Cube3D(cubies[2]);
                transform[21] = new Cube3D(cubies[23]);
                transform[22] = new Cube3D(cubies[14]);
                transform[23] = new Cube3D(cubies[5]);
                transform[24] = new Cube3D(cubies[26]);
                transform[25] = new Cube3D(cubies[17]);
                transform[26] = new Cube3D(cubies[8]);
                break;
            case COUNTER_CLOCK:
                transform[0] = new Cube3D(cubies[2]);
                transform[1] = new Cube3D(cubies[11]);
                transform[2] = new Cube3D(cubies[20]);
                transform[3] = new Cube3D(cubies[5]);
                transform[4] = new Cube3D(cubies[14]);
                transform[5] = new Cube3D(cubies[23]);
                transform[6] = new Cube3D(cubies[8]);
                transform[7] = new Cube3D(cubies[17]);
                transform[8] = new Cube3D(cubies[26]);

                transform[9] = new Cube3D(cubies[1]);
                transform[10] = new Cube3D(cubies[10]);
                transform[11] = new Cube3D(cubies[19]);
                transform[12] = new Cube3D(cubies[4]);
                transform[13] = new Cube3D(cubies[13]);
                transform[14] = new Cube3D(cubies[22]);
                transform[15] = new Cube3D(cubies[7]);
                transform[16] = new Cube3D(cubies[16]);
                transform[17] = new Cube3D(cubies[25]);

                transform[18] = new Cube3D(cubies[0]);
                transform[19] = new Cube3D(cubies[9]);
                transform[20] = new Cube3D(cubies[18]);
                transform[21] = new Cube3D(cubies[3]);
                transform[22] = new Cube3D(cubies[12]);
                transform[23] = new Cube3D(cubies[21]);
                transform[24] = new Cube3D(cubies[6]);
                transform[25] = new Cube3D(cubies[15]);
                transform[26] = new Cube3D(cubies[24]);
                break;
            default:
                throw new IllegalArgumentException("Invalid full cube rotation: " + rotation);
        }
        return transform;
    }

    private Cube3D[] getFace(Move move)
    {
        switch (move)
        {
            case FRONT:
                return ArrayUtils.subarray(cubies, 18, 27);
            case BACK:
                return ArrayUtils.addAll(ArrayUtils.subarray(cubies, 6, 9),
                    ArrayUtils.addAll(ArrayUtils.subarray(cubies, 3, 6),
                        ArrayUtils.subarray(cubies, 0, 3)));
            case UP:
                return ArrayUtils.addAll(ArrayUtils.subarray(cubies, 0, 3),
                    ArrayUtils.addAll(ArrayUtils.subarray(cubies, 9, 12),
                        ArrayUtils.subarray(cubies, 18, 21)));
            case DOWN:
                return ArrayUtils.addAll(ArrayUtils.subarray(cubies, 24, 27),
                    ArrayUtils.addAll(ArrayUtils.subarray(cubies, 15, 18),
                        ArrayUtils.subarray(cubies, 6, 9)));
            case LEFT:
                Cube3D[] left = new Cube3D[CUBIES_PER_FACE];
                for (int i = 0, j = 0; i < CUBIES_PER_FACE; i += 3, j++)
                {
                    left[i] = cubies[3 * j];
                    left[i + 1] = cubies[3 * j + 9];
                    left[i + 2] = cubies[3 * j + 18];
                }
                return left;
            case RIGHT:
                Cube3D[] right = new Cube3D[CUBIES_PER_FACE];
                for (int i = 0; i < CUBIES_PER_FACE; i++)
                {
                    right[i] = cubies[3 * i + 2];
                }
                return right;
            default:
                throw new IllegalArgumentException("This should never happen..");
        }
    }

    private Cube3D[] getTransformedFace(Cube3D[] face)
    {
        Cube3D[] transform = new Cube3D[CUBIES_PER_FACE];
        transform[0] = new Cube3D(face[6]);
        transform[1] = new Cube3D(face[3]);
        transform[2] = new Cube3D(face[0]);
        transform[3] = new Cube3D(face[7]);
        transform[4] = new Cube3D(face[4]);
        transform[5] = new Cube3D(face[1]);
        transform[6] = new Cube3D(face[8]);
        transform[7] = new Cube3D(face[5]);
        transform[8] = new Cube3D(face[2]);
        return transform;
    }

    private Cube3D[] getInverseTransformedFace(Cube3D[] face)
    {
        Cube3D[] transform = new Cube3D[CUBIES_PER_FACE];
        transform[0] = new Cube3D(face[2]);
        transform[1] = new Cube3D(face[5]);
        transform[2] = new Cube3D(face[8]);
        transform[3] = new Cube3D(face[1]);
        transform[4] = new Cube3D(face[4]);
        transform[5] = new Cube3D(face[7]);
        transform[6] = new Cube3D(face[0]);
        transform[7] = new Cube3D(face[3]);
        transform[8] = new Cube3D(face[6]);
        return transform;
    }
}
