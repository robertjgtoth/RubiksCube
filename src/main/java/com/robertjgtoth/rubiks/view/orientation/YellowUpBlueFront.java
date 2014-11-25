package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

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

    public Orientation move(Move move)
    {
        switch (move)
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
