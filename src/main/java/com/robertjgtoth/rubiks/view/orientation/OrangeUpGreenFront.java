package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class OrangeUpGreenFront extends Orientation {

    public OrangeUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.GREEN, Colors.BLUE, Colors.WHITE,
                Colors.YELLOW, Colors.ORANGE, Colors.RED);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new GreenUpRedFront();
            case DOWN:
                return new BlueUpOrangeFront();
            case LEFT:
                return new WhiteUpGreenFront();
            case RIGHT:
                return new YellowUpGreenFront();
            case CLOCK:
                return new OrangeUpWhiteFront();
            case COUNTER_CLOCK:
                return new OrangeUpYellowFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
