package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

import java.util.LinkedHashMap;

/**
 * Created by rtoth on 11/25/2014.
 */
public class RedUpWhiteFront extends Orientation {

    public RedUpWhiteFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.WHITE, Colors.YELLOW, Colors.GREEN,
                Colors.BLUE, Colors.RED, Colors.ORANGE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new WhiteUpOrangeFront();
            case DOWN:
                return new YellowUpRedFront();
            case LEFT:
                return new GreenUpWhiteFront();
            case RIGHT:
                return new BlueUpWhiteFront();
            case CLOCK:
                return new RedUpGreenFront();
            case COUNTER_CLOCK:
                return new RedUpBlueFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
