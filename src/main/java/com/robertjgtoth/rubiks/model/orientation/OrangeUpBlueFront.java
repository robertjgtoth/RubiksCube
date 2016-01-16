package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class OrangeUpBlueFront extends Orientation
{
    public OrangeUpBlueFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.BLUE, Colors.GREEN, Colors.YELLOW,
            Colors.WHITE, Colors.ORANGE, Colors.RED);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new BlueUpRedFront();
            case DOWN:
                return new GreenUpOrangeFront();
            case LEFT:
                return new YellowUpBlueFront();
            case RIGHT:
                return new WhiteUpBlueFront();
            case CLOCK:
                return new OrangeUpYellowFront();
            case COUNTER_CLOCK:
                return new OrangeUpWhiteFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
