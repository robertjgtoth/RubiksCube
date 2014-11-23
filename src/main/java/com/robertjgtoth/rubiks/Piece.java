package com.robertjgtoth.rubiks;

/**
 * Created by rtoth on 11/22/2014.
 */
public class Piece {

    private Color color;

    public Piece(Color color)
    {
        if (color == null)
        {
            throw new IllegalArgumentException(
                    "Color cannot be null!"
            );
        }
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public String toString()
    {
        return color.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (color != piece.color) return false;

        return true;
    }


}
