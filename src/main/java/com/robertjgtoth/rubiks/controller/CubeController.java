package com.robertjgtoth.rubiks.controller;

import com.robertjgtoth.rubiks.model.Cube;
import com.robertjgtoth.rubiks.model.Move;
import com.robertjgtoth.rubiks.model.Rotation;
import com.robertjgtoth.rubiks.view.Cube3D;

import javax.media.j3d.TransformGroup;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rtoth on 11/26/2014.
 */
public class CubeController {

    private static final Map<Integer, Rotation> validRotations =
            new HashMap<Integer, Rotation>();
    static
    {
        validRotations.put(KeyEvent.VK_UP, Rotation.UP);
        validRotations.put(KeyEvent.VK_DOWN, Rotation.DOWN);
        validRotations.put(KeyEvent.VK_LEFT, Rotation.CLOCK);
        validRotations.put(KeyEvent.VK_RIGHT, Rotation.COUNTER_CLOCK);
    }

    private static final Map<Integer, Move> validMoves =
            new HashMap<Integer, Move>();
    static
    {
        validMoves.put(KeyEvent.VK_U, Move.UP);
        validMoves.put(KeyEvent.VK_D, Move.DOWN);
        validMoves.put(KeyEvent.VK_L, Move.LEFT);
        validMoves.put(KeyEvent.VK_R, Move.RIGHT);
        validMoves.put(KeyEvent.VK_F, Move.FRONT);
        validMoves.put(KeyEvent.VK_B, Move.BACK);
    }

    private Cube cube;

    public CubeController()
    {
        cube = new Cube();
    }

    public void attachTransformGroup(TransformGroup view)
    {
        for (Cube3D cubie : cube.getCubies())
        {
            view.addChild(cubie);
        }
    }

    public void processInput(int keyCode)
    {
        Rotation rotation = validRotations.get(keyCode);
        Move move = validMoves.get(keyCode);

        if (rotation != null) {
            cube.applyRotation(rotation);
        }
        else if (move != null) {
            cube.applyMove(move);
        }
    }

}
