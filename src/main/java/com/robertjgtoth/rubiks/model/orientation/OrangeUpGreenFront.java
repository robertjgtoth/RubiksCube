package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class OrangeUpGreenFront extends Orientation
{
    public OrangeUpGreenFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.GREEN, Colors.BLUE, Colors.WHITE,
            Colors.YELLOW, Colors.ORANGE, Colors.RED);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
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
