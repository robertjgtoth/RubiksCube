package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class GreenUpOrangeFront extends Orientation {

    public GreenUpOrangeFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.ORANGE, Colors.RED, Colors.YELLOW,
                Colors.WHITE, Colors.GREEN, Colors.BLUE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new OrangeUpBlueFront();
            case DOWN:
                return new RedUpGreenFront();
            case LEFT:
                return new YellowUpOrangeFront();
            case RIGHT:
                return new WhiteUpOrangeFront();
            case CLOCK:
                return new GreenUpYellowFront();
            case COUNTER_CLOCK:
                return new GreenUpWhiteFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
