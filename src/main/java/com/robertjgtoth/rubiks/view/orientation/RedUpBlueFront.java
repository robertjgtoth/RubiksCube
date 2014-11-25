package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class RedUpBlueFront extends Orientation {

    public RedUpBlueFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.BLUE, Colors.GREEN, Colors.WHITE,
                Colors.YELLOW, Colors.RED, Colors.ORANGE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new BlueUpOrangeFront();
            case DOWN:
                return new GreenUpRedFront();
            case LEFT:
                return new WhiteUpBlueFront();
            case RIGHT:
                return new YellowUpBlueFront();
            case CLOCK:
                return new RedUpWhiteFront();
            case COUNTER_CLOCK:
                return new RedUpYellowFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
