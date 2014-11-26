package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public abstract class Orientation {

    float[] colors;

    public float[] getColors()
    {
        return colors;
    }

    public abstract Orientation move(Rotation rotation);
}
