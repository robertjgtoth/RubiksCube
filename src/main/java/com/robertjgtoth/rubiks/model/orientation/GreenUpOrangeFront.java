package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class GreenUpOrangeFront extends Orientation {

    public GreenUpOrangeFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.ORANGE, Colors.RED, Colors.YELLOW,
                Colors.WHITE, Colors.GREEN, Colors.BLUE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new OrangeUpBlueFront();
            case DOWN:
                return new RedUpGreenFront();
            case LEFT:
                return new YellowUpOrangeFront();
            case RIGHT:
                return new WhiteUpOrangeFront();
            case CLOCK:
                return new GreenUpYellowFront();
            case COUNTER_CLOCK:
                return new GreenUpWhiteFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
