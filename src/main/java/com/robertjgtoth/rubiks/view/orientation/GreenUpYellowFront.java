package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class GreenUpYellowFront extends Orientation {

    public GreenUpYellowFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.YELLOW, Colors.WHITE, Colors.RED,
                Colors.ORANGE, Colors.GREEN, Colors.BLUE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new YellowUpBlueFront();
            case DOWN:
                return new WhiteUpGreenFront();
            case LEFT:
                return new RedUpYellowFront();
            case RIGHT:
                return new OrangeUpYellowFront();
            case CLOCK:
                return new GreenUpRedFront();
            case COUNTER_CLOCK:
                return new GreenUpOrangeFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
