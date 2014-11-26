package com.robertjgtoth.rubiks.model.orientation;

import com.robertjgtoth.rubiks.model.Colors;
import com.robertjgtoth.rubiks.model.Rotation;

/**
 * Created by rtoth on 11/25/2014.
 */
public class GreenUpWhiteFront extends Orientation {

    public GreenUpWhiteFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.WHITE, Colors.YELLOW, Colors.ORANGE,
                Colors.RED, Colors.GREEN, Colors.BLUE);
    }

    public Orientation move(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return new WhiteUpBlueFront();
            case DOWN:
                return new YellowUpGreenFront();
            case LEFT:
                return new OrangeUpWhiteFront();
            case RIGHT:
                return new RedUpWhiteFront();
            case CLOCK:
                return new GreenUpOrangeFront();
            case COUNTER_CLOCK:
                return new GreenUpRedFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }

}
