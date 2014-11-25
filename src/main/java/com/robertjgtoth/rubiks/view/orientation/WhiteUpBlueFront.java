package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpBlueFront extends Orientation {

    public WhiteUpBlueFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.BLUE, Colors.GREEN, Colors.ORANGE,
                Colors.RED, Colors.WHITE, Colors.YELLOW);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case DOWN:
                return new WhiteUpBlueFront();  // TODO: GreenUpWhiteFront
            case UP:
                return new WhiteUpBlueFront();  // TODO: BlueUpYellowFront
            case LEFT:
                return new WhiteUpOrangeFront();
            case RIGHT:
                return new WhiteUpRedFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
