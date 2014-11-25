package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class GreenUpWhiteFront extends Orientation {

    public GreenUpWhiteFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.WHITE, Colors.YELLOW, Colors.ORANGE,
                Colors.RED, Colors.GREEN, Colors.BLUE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new WhiteUpBlueFront();
            case DOWN:
                return new YellowUpGreenFront();
            case LEFT:
                return new OrangeUpWhiteFront();
            case RIGHT:
                return new RedUpWhiteFront();
            case CLOCK:
                return new GreenUpOrangeFront();
            case COUNTER_CLOCK:
                return new GreenUpRedFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
