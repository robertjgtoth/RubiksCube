package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class YellowUpOrangeFront extends Orientation {

    public YellowUpOrangeFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.ORANGE, Colors.RED, Colors.BLUE,
                Colors.GREEN, Colors.YELLOW, Colors.WHITE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new OrangeUpWhiteFront();
            case DOWN:
                return new RedUpYellowFront();
            case LEFT:
                return new BlueUpOrangeFront();
            case RIGHT:
                return new GreenUpOrangeFront();
            case CLOCK:
                return new YellowUpBlueFront();
            case COUNTER_CLOCK:
                return new YellowUpGreenFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
