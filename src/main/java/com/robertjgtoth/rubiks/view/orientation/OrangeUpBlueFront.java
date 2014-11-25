package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class OrangeUpBlueFront extends Orientation {

    public OrangeUpBlueFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.BLUE, Colors.GREEN, Colors.YELLOW,
                Colors.WHITE, Colors.ORANGE, Colors.RED);
    }

    public Orientation move(Move move)
    {
        switch (move)
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
