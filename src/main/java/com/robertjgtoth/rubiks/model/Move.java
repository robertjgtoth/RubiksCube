package com.robertjgtoth.rubiks.model;

import java.util.Random;

/**
 * Created by rtoth on 11/26/2014.
 */
public enum Move
{
    UP, DOWN, LEFT, RIGHT, FRONT, BACK;

    private static final Random random = new Random();

    public static Move getRandomMove()
    {
        int val = random.nextInt(6);
        switch (val)
        {
            case 0:
                return UP;
            case 1:
                return DOWN;
            case 2:
                return LEFT;
            case 3:
                return RIGHT;
            case 4:
                return FRONT;
            case 5:
                return BACK;
            default:
                return RIGHT;
        }
    }
}
