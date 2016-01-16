package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class RedUpYellowFront extends Orientation
{
    public RedUpYellowFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.YELLOW, Colors.WHITE, Colors.BLUE,
            Colors.GREEN, Colors.RED, Colors.ORANGE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new YellowUpOrangeFront();
            case DOWN:
                return new WhiteUpRedFront();
            case LEFT:
                return new BlueUpYellowFront();
            case RIGHT:
                return new GreenUpYellowFront();
            case CLOCK:
                return new RedUpBlueFront();
            case COUNTER_CLOCK:
                return new RedUpGreenFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
