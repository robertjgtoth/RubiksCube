package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class BlueUpOrangeFront extends Orientation {

    public BlueUpOrangeFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.ORANGE, Colors.RED, Colors.WHITE,
                Colors.YELLOW, Colors.BLUE, Colors.GREEN);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case UP:
                return new OrangeUpGreenFront();
            case DOWN:
                return new RedUpBlueFront();
            case LEFT:
                return new WhiteUpOrangeFront();
            case RIGHT:
                return new YellowUpOrangeFront();
            case CLOCK:
                return new BlueUpWhiteFront();
            case COUNTER_CLOCK:
                return new BlueUpYellowFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
