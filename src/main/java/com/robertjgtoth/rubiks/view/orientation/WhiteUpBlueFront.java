package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpBlueFront implements Orientation {

    private float[] colors;

    public WhiteUpBlueFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.BLUE, Colors.GREEN, Colors.ORANGE,
                Colors.RED, Colors.WHITE, Colors.YELLOW);
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
                return new WhiteUpBlueFront();
            case UP:
                return new WhiteUpBlueFront();
            case LEFT:
                return new WhiteUpOrangeFront();
            case RIGHT:
                return new Solved();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
