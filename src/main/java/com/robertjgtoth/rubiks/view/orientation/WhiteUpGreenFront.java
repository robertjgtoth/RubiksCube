package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpGreenFront implements Orientation {

    private float[] colors;

    public WhiteUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.GREEN, Colors.BLUE, Colors.RED,
                Colors.ORANGE, Colors.WHITE, Colors.YELLOW);
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
                return new WhiteUpGreenFront();
            case UP:
                return new WhiteUpGreenFront();
            case LEFT:
                return new Solved();
            case RIGHT:
                return new WhiteUpOrangeFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
