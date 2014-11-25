package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpGreenFront extends Orientation {

    public WhiteUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.GREEN, Colors.BLUE, Colors.RED,
                Colors.ORANGE, Colors.WHITE, Colors.YELLOW);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case DOWN:
                return new WhiteUpGreenFront(); // TODO: BlueUpWhiteFront
            case UP:
                return new WhiteUpGreenFront(); // TODO: GreenUpYellowFront
            case LEFT:
                return new WhiteUpRedFront();
            case RIGHT:
                return new WhiteUpOrangeFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
