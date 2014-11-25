package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class BlueUpRedFront extends Orientation {

    public BlueUpRedFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.RED, Colors.ORANGE, Colors.YELLOW,
                Colors.WHITE, Colors.BLUE, Colors.GREEN);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new RedUpGreenFront();
            case DOWN:
                return new OrangeUpBlueFront();
            case LEFT:
                return new YellowUpRedFront();
            case RIGHT:
                return new WhiteUpRedFront();
            case CLOCK:
                return new BlueUpYellowFront();
            case COUNTER_CLOCK:
                return new BlueUpWhiteFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
