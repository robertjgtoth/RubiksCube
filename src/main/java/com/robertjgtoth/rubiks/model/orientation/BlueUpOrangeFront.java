package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

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

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
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
