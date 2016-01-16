package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class OrangeUpYellowFront extends Orientation
{
    public OrangeUpYellowFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.YELLOW, Colors.WHITE, Colors.GREEN,
            Colors.BLUE, Colors.ORANGE, Colors.RED);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
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
