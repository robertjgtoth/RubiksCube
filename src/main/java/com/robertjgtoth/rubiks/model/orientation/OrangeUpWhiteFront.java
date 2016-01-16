package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class OrangeUpWhiteFront extends Orientation
{
    public OrangeUpWhiteFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.WHITE, Colors.YELLOW, Colors.BLUE,
            Colors.GREEN, Colors.ORANGE, Colors.RED);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new WhiteUpRedFront();
            case DOWN:
                return new YellowUpOrangeFront();
            case LEFT:
                return new BlueUpWhiteFront();
            case RIGHT:
                return new GreenUpWhiteFront();
            case CLOCK:
                return new OrangeUpBlueFront();
            case COUNTER_CLOCK:
                return new OrangeUpGreenFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
