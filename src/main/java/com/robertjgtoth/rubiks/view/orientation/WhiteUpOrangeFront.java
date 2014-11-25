package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpOrangeFront implements Orientation {

    private float[] colors;

    public WhiteUpOrangeFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.ORANGE, Colors.RED, Colors.GREEN,
                Colors.BLUE, Colors.WHITE, Colors.YELLOW);
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
                return new WhiteUpOrangeFront();
            case UP:
                return new WhiteUpOrangeFront();
            case LEFT:
                return new WhiteUpGreenFront();
            case RIGHT:
                return new WhiteUpBlueFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
