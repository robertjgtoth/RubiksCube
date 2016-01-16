package com.robertjgtoth.rubiks.model;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by rtoth on 11/25/2014.
 */
public abstract class Colors
{
    public static final float[] WHITE = {
        1.0f, 1.0f, 1.0f,
        1.0f, 1.0f, 1.0f,
        1.0f, 1.0f, 1.0f,
        1.0f, 1.0f, 1.0f,
    };

    public static final float[] RED = {
        1.0f, 0.0f, 0.0f,
        1.0f, 0.0f, 0.0f,
        1.0f, 0.0f, 0.0f,
        1.0f, 0.0f, 0.0f,
    };

    public static final float[] ORANGE = {
        1.0f, 0.65f, 0.0f,
        1.0f, 0.65f, 0.0f,
        1.0f, 0.65f, 0.0f,
        1.0f, 0.65f, 0.0f,
    };

    public static final float[] YELLOW = {
        1.0f, 1.0f, 0.0f,
        1.0f, 1.0f, 0.0f,
        1.0f, 1.0f, 0.0f,
        1.0f, 1.0f, 0.0f,
    };

    public static final float[] GREEN = {
        0.0f, 1.0f, 0.0f,
        0.0f, 1.0f, 0.0f,
        0.0f, 1.0f, 0.0f,
        0.0f, 1.0f, 0.0f
    };

    public static final float[] BLUE = {
        0.0f, 0.0f, 1.0f,
        0.0f, 0.0f, 1.0f,
        0.0f, 0.0f, 1.0f,
        0.0f, 0.0f, 1.0f,
    };

    public static float[] createCubeColorGeometry(float[] front, float[] back, float[] right,
                                                  float[] left, float[] top, float[] bottom)
    {
        return ArrayUtils.addAll(front,
            ArrayUtils.addAll(back,
                ArrayUtils.addAll(right,
                    ArrayUtils.addAll(left,
                        ArrayUtils.addAll(top,
                            bottom)))));
    }
}
