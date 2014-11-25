package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public abstract class Orientation {

    float[] colors;

    public float[] getColors()
    {
        return colors;
    }

    public abstract Orientation move(Move move);
}
