package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpBlueFront extends Orientation
{
    public WhiteUpBlueFront()
    {
        this.colors = Colors.createCubeColorGeometry(
            Colors.BLUE, Colors.GREEN, Colors.ORANGE,
            Colors.RED, Colors.WHITE, Colors.YELLOW);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new BlueUpYellowFront();
            case DOWN:
                return new GreenUpWhiteFront();
            case LEFT:
                return new OrangeUpBlueFront();
            case RIGHT:
                return new RedUpBlueFront();
            case CLOCK:
                return new WhiteUpOrangeFront();
            case COUNTER_CLOCK:
                return new WhiteUpRedFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
