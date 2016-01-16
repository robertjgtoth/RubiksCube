package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class BlueUpWhiteFront extends Orientation
{
    public BlueUpWhiteFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.WHITE, Colors.YELLOW, Colors.RED,
            Colors.ORANGE, Colors.BLUE, Colors.GREEN);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new WhiteUpGreenFront();
            case DOWN:
                return new YellowUpBlueFront();
            case LEFT:
                return new RedUpWhiteFront();
            case RIGHT:
                return new OrangeUpWhiteFront();
            case CLOCK:
                return new BlueUpRedFront();
            case COUNTER_CLOCK:
                return new BlueUpOrangeFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
