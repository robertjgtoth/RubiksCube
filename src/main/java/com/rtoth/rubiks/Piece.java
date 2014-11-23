package com.rtoth.rubiks;

/**
 * Created by rtoth on 11/22/2014.
 */
public class Piece {

    private Color color;

    public Piece(Color color)
    {
        if (color == null)
        {
            this.color = Color.random();
        }
        else
        {
            this.color = color;
        }
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public String toString()
    {
        return color.toString();
    }

}
