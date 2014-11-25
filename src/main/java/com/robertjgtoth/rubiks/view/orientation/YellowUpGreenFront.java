package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class YellowUpGreenFront extends Orientation {

    public YellowUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.GREEN, Colors.BLUE, Colors.ORANGE,
                Colors.RED, Colors.YELLOW, Colors.WHITE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new GreenUpWhiteFront();
            case DOWN:
                return new BlueUpYellowFront();
            case LEFT:
                return new OrangeUpGreenFront();
            case RIGHT:
                return new RedUpGreenFront();
            case CLOCK:
                return new YellowUpOrangeFront();
            case COUNTER_CLOCK:
                return new YellowUpRedFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
