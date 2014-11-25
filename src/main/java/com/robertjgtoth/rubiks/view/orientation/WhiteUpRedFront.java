package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpRedFront extends Orientation {

    public WhiteUpRedFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.RED, Colors.ORANGE, Colors.BLUE,
                Colors.GREEN, Colors.WHITE, Colors.YELLOW);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new RedUpYellowFront();
            case DOWN:
                return new OrangeUpWhiteFront();
            case LEFT:
                return new BlueUpRedFront();
            case RIGHT:
                return new GreenUpRedFront();
            case CLOCK:
                return new WhiteUpBlueFront();
            case COUNTER_CLOCK:
                return new WhiteUpGreenFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
