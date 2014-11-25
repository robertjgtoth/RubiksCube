package com.robertjgtoth.rubiks.view.orientation;

import com.robertjgtoth.rubiks.view.Colors;
import com.robertjgtoth.rubiks.view.Move;

/**
 * Created by rtoth on 11/25/2014.
 */
public class OrangeUpWhiteFront extends Orientation {

    public OrangeUpWhiteFront()
    {
        this.colors = Colors.createCubeColorGeometry(
                Colors.WHITE, Colors.YELLOW, Colors.BLUE,
                Colors.GREEN, Colors.ORANGE, Colors.RED);
    }

    public Orientation move(Move move)
    {
        switch (move)
        {
            case DOWN:
                return new OrangeUpWhiteFront();  // TODO: YellowUpOrangeFront
            case UP:
                return new WhiteUpRedFront();
            case LEFT:
                return new OrangeUpWhiteFront(); // TODO: OrangeUpBlueFront
            case RIGHT:
                return new OrangeUpWhiteFront(); // TODO: OrangeUpGreenFront
            default:
                throw new IllegalArgumentException("This should never happen");
        }
    }
}
