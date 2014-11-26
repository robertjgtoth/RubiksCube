package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class YellowUpBlueFront extends Orientation {

    public YellowUpBlueFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.BLUE, Colors.GREEN, Colors.RED,
                Colors.ORANGE, Colors.YELLOW, Colors.WHITE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new BlueUpWhiteFront();
            case DOWN:
                return new GreenUpYellowFront();
            case LEFT:
                return new RedUpBlueFront();
            case RIGHT:
                return new OrangeUpBlueFront();
            case CLOCK:
                return new YellowUpRedFront();
            case COUNTER_CLOCK:
                return new YellowUpOrangeFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
