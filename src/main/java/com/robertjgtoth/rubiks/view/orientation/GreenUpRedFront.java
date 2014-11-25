package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class GreenUpRedFront extends Orientation {

    public GreenUpRedFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.RED, Colors.ORANGE, Colors.WHITE,
                Colors.YELLOW, Colors.GREEN, Colors.BLUE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new RedUpBlueFront();
            case DOWN:
                return new OrangeUpGreenFront();
            case LEFT:
                return new WhiteUpRedFront();
            case RIGHT:
                return new YellowUpRedFront();
            case CLOCK:
                return new GreenUpWhiteFront();
            case COUNTER_CLOCK:
                return new GreenUpYellowFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
