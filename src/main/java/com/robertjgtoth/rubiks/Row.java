package com.robertjgtoth.rubiks;

/**
 * Created by rtoth on 11/22/2014.
 */
public class Row {

    private Piece left;
    private Piece center;
    private Piece right;

    public Row(Piece left, Piece center, Piece right)
    {
        this.left = left;
        this.center = center;
        this.right = right;
    }

    public Row(Row other)
    {
        this.left = new Piece(other.left.getColor());
        this.center = new Piece(other.center.getColor());
        this.right = new Piece(other.right.getColor());
    }

    public void set(Row other)
    {
        this.left.setColor(other.left.getColor());
        this.center.setColor(other.center.getColor());
        this.right.setColor(other.right.getColor());
    }

    public String toString()
    {
        StringBuffer buf = new StringBuffer();

        buf.append("|");
        buf.append(left);
        buf.append(center);
        buf.append(right);
        buf.append("|");

        return buf.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Row row = (Row) o;

        if (!center.equals(row.center)) return false;
        if (!left.equals(row.left)) return false;
        if (!right.equals(row.right)) return false;

        return true;
    }

}
