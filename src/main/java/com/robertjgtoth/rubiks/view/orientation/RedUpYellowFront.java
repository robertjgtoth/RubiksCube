package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class RedUpYellowFront extends Orientation {

    public RedUpYellowFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.YELLOW, Colors.WHITE, Colors.BLUE,
                Colors.GREEN, Colors.RED, Colors.ORANGE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new YellowUpOrangeFront();
            case DOWN:
                return new WhiteUpRedFront();
            case LEFT:
                return new BlueUpYellowFront();
            case RIGHT:
                return new GreenUpYellowFront();
            case CLOCK:
                return new  RedUpBlueFront();
            case COUNTER_CLOCK:
                return new  RedUpGreenFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
