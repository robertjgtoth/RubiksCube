package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class RedUpWhiteFront extends Orientation {

    public RedUpWhiteFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.WHITE, Colors.YELLOW, Colors.GREEN,
                Colors.BLUE, Colors.RED, Colors.ORANGE);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case DOWN:
                return new RedUpWhiteFront(); // TODO: YellowUpRedFront
            case UP:
                return new WhiteUpOrangeFront();
            case LEFT:
                return new RedUpGreenFront();
            case RIGHT:
                return new RedUpBlueFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
