package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class WhiteUpOrangeFront extends Orientation {

    public WhiteUpOrangeFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.ORANGE, Colors.RED, Colors.GREEN,
                Colors.BLUE, Colors.WHITE, Colors.YELLOW);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case DOWN:
                return new RedUpWhiteFront();
            case UP:
                return new WhiteUpOrangeFront();  // TODO: OrangeUpYellowFront
            case LEFT:
                return new WhiteUpGreenFront();
            case RIGHT:
                return new WhiteUpBlueFront();
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
