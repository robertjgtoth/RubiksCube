package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class OrangeUpYellowFront extends Orientation {

    public OrangeUpYellowFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.YELLOW, Colors.WHITE, Colors.GREEN,
                Colors.BLUE, Colors.ORANGE, Colors.RED);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new YellowUpRedFront();
            case DOWN:
                return new WhiteUpOrangeFront();
            case LEFT:
                return new GreenUpYellowFront();
            case RIGHT:
                return new BlueUpYellowFront();
            case CLOCK:
                return new OrangeUpGreenFront();
            case COUNTER_CLOCK:
                return new OrangeUpBlueFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
