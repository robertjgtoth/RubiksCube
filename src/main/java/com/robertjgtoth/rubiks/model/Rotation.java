package com.robertjgtoth.rubiks.model;

/**
 * Created by rtoth on 11/25/2014.
 */
public enum Rotation
{
    UP, DOWN, LEFT, RIGHT, CLOCK, COUNTER_CLOCK;

    public static Rotation getInverse(Rotation rotation)
    {
        switch (rotation)
        {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case CLOCK:
                return COUNTER_CLOCK;
            case COUNTER_CLOCK:
                return CLOCK;
            default:
                throw new IllegalArgumentException("This should never happen..");
        }
    }
}
