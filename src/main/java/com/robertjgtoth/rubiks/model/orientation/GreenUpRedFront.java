package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class GreenUpRedFront extends Orientation
{
    public GreenUpRedFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.RED, Colors.ORANGE, Colors.WHITE,
            Colors.YELLOW, Colors.GREEN, Colors.BLUE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new RedUpBlueFront();
            case DOWN:
                return new OrangeUpGreenFront();
            case LEFT:
                return new WhiteUpRedFront();
            case RIGHT:
                return new YellowUpRedFront();
            case CLOCK:
                return new GreenUpWhiteFront();
            case COUNTER_CLOCK:
                return new GreenUpYellowFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
