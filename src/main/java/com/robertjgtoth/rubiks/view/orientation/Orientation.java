package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public interface Orientation {

    public float[] getColors();

    public Orientation move(Move move);
}
