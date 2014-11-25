package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class Solved implements Orientation {

    private float[] colors;

    public Solved()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.RED, Colors.ORANGE, Colors.BLUE,
                Colors.GREEN, Colors.WHITE, Colors.YELLOW);
    }

    public float[] getColors()
    {
        return colors;
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case DOWN:
                return new Solved();
            case UP:
                return new Solved();
            case LEFT:
                return new WhiteUpBlueFront();
            case RIGHT:
                return new WhiteUpGreenFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
