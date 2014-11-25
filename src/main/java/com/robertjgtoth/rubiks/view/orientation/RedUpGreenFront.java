package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class RedUpGreenFront extends Orientation {

    public RedUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.GREEN, Colors.BLUE, Colors.YELLOW,
                Colors.WHITE, Colors.RED, Colors.ORANGE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new GreenUpOrangeFront();
            case DOWN:
                return new BlueUpRedFront();
            case LEFT:
                return new YellowUpGreenFront();
            case RIGHT:
                return new WhiteUpGreenFront();
            case CLOCK:
                return new RedUpYellowFront();
            case COUNTER_CLOCK:
                return new RedUpWhiteFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
