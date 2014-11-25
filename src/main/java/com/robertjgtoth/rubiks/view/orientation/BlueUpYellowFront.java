package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class BlueUpYellowFront extends Orientation {

    public BlueUpYellowFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.YELLOW, Colors.WHITE, Colors.ORANGE,
                Colors.RED, Colors.BLUE, Colors.GREEN);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new YellowUpGreenFront();
            case DOWN:
                return new WhiteUpBlueFront();
            case LEFT:
                return new OrangeUpYellowFront();
            case RIGHT:
                return new RedUpYellowFront();
            case CLOCK:
                return new BlueUpOrangeFront();
            case COUNTER_CLOCK:
                return new BlueUpRedFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
