package com.robertjgtoth.rubiks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rtoth on 11/22/2014.
 */
public class Face {

    public static final int LINE_WIDTH = 17;

    private static final int PIECES_PER_FACE = 9;

    private Map<Index, Piece> pieces = new HashMap<Index, Piece>();
    private Color color;

    public Face(Color color)
    {
        this.color = color;
        for (int i = 0; i < PIECES_PER_FACE; i++)
        {
            pieces.put(Index.fromInt(i), new Piece(color));
        }
    }

    public Collection<Piece> getPieces()
    {
        return pieces.values();
    }

    public Color getColor()
    {
        return color;
    }

    public String toString()
    {
        return getFormattedString("", "");
    }

    public String getFormattedString(String beforeLine, String afterLine)
    {
        StringBuffer buf = new StringBuffer();
        buf.append(beforeLine);
        buf.append(getTopLineStr());
        buf.append(afterLine);
        buf.append("\n");
        buf.append(beforeLine);
        buf.append(getMiddleLineStr());
        buf.append(afterLine);
        buf.append("\n");
        buf.append(beforeLine);
        buf.append(getBottomLineStr());
        buf.append(afterLine);
        return buf.toString();
    }

    public String getTopLineStr()
    {
        StringBuffer buf = new StringBuffer();

        buf.append("|");
        buf.append(pieces.get(Index.TOP_LEFT));
        buf.append(pieces.get(Index.TOP_CENTER));
        buf.append(pieces.get(Index.TOP_RIGHT));
        buf.append("|");

        return buf.toString();
    }

    public String getMiddleLineStr()
    {
        StringBuffer buf = new StringBuffer();

        buf.append("|");
        buf.append(pieces.get(Index.MIDDLE_LEFT));
        buf.append(pieces.get(Index.MIDDLE_CENTER));
        buf.append(pieces.get(Index.MIDDLE_RIGHT));
        buf.append("|");

        return buf.toString();
    }

    public String getBottomLineStr()
    {
        StringBuffer buf = new StringBuffer();

        buf.append("|");
        buf.append(pieces.get(Index.BOTTOM_LEFT));
        buf.append(pieces.get(Index.BOTTOM_CENTER));
        buf.append(pieces.get(Index.BOTTOM_RIGHT));
        buf.append("|");

        return buf.toString();
    }

    private enum Index
    {
        TOP_LEFT(0, "Top Left"),
        TOP_CENTER(1, "Top Center"),
        TOP_RIGHT(2, "Top Right"),
        MIDDLE_LEFT(3, "Middle Left"),
        MIDDLE_CENTER(4, "Middle Center"),
        MIDDLE_RIGHT(5, "Middle Right"),
        BOTTOM_LEFT(6, "Bottom Left"),
        BOTTOM_CENTER(7, "Bottom Center"),
        BOTTOM_RIGHT(8, "Bottom Right");

        private int value;
        private String description;

        private static Map<Integer, Index> indexMap = new HashMap<Integer, Index>();
        static
        {
            for (Index index : Index.values())
            {
                indexMap.put(index.value, index);
            }
        }

        private Index(int val, String description)
        {
            this.value = val;
            this.description = description;
        }

        private static Index fromInt(int value)
        {
            Index index = indexMap.get(value);
            if (index == null)
            {
                throw new IllegalArgumentException(
                    "Invalid index value: " + value);
            }
            return index;
        }

        public String toString()
        {
            return description;
        }

    }
}
