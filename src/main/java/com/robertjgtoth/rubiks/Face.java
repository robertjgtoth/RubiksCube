package com.robertjgtoth.rubiks;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rtoth on 11/22/2014.
 */
public class Face {

    public static final int LINE_WIDTH = 17;

    private static final int PIECES_PER_FACE = 9;

    private Map<FaceIndex, Piece> pieces = new HashMap<FaceIndex, Piece>();
    private Color color;

    public Face(Color color) {
        this.color = color;
        for (int i = 0; i < PIECES_PER_FACE; i++) {
            pieces.put(FaceIndex.fromInt(i), new Piece(color));
        }
    }

    public void rotateClockwise() {
        Color topRightSave = pieces.get(FaceIndex.TOP_RIGHT).getColor();
        Color topCenterSave = pieces.get(FaceIndex.TOP_CENTER).getColor();
        pieces.get(FaceIndex.TOP_RIGHT).setColor(pieces.get(FaceIndex.TOP_LEFT).getColor());
        pieces.get(FaceIndex.TOP_CENTER).setColor(pieces.get(FaceIndex.MIDDLE_LEFT).getColor());
        pieces.get(FaceIndex.TOP_LEFT).setColor(pieces.get(FaceIndex.BOTTOM_LEFT).getColor());
        pieces.get(FaceIndex.MIDDLE_LEFT).setColor(pieces.get(FaceIndex.BOTTOM_CENTER).getColor());
        pieces.get(FaceIndex.BOTTOM_LEFT).setColor(pieces.get(FaceIndex.BOTTOM_RIGHT).getColor());
        pieces.get(FaceIndex.BOTTOM_CENTER).setColor(pieces.get(FaceIndex.MIDDLE_RIGHT).getColor());
        pieces.get(FaceIndex.BOTTOM_RIGHT).setColor(topRightSave);
        pieces.get(FaceIndex.MIDDLE_RIGHT).setColor(topCenterSave);
    }

    public void rotateCounterClockwise() {
        Color topRightSave = pieces.get(FaceIndex.TOP_RIGHT).getColor();
        Color middleRightSave = pieces.get(FaceIndex.MIDDLE_RIGHT).getColor();
        pieces.get(FaceIndex.TOP_RIGHT).setColor(pieces.get(FaceIndex.BOTTOM_RIGHT).getColor());
        pieces.get(FaceIndex.MIDDLE_RIGHT).setColor(pieces.get(FaceIndex.BOTTOM_CENTER).getColor());
        pieces.get(FaceIndex.BOTTOM_RIGHT).setColor(pieces.get(FaceIndex.BOTTOM_LEFT).getColor());
        pieces.get(FaceIndex.BOTTOM_CENTER).setColor(pieces.get(FaceIndex.MIDDLE_LEFT).getColor());
        pieces.get(FaceIndex.BOTTOM_LEFT).setColor(pieces.get(FaceIndex.TOP_LEFT).getColor());
        pieces.get(FaceIndex.MIDDLE_LEFT).setColor(pieces.get(FaceIndex.TOP_CENTER).getColor());
        pieces.get(FaceIndex.TOP_LEFT).setColor(topRightSave);
        pieces.get(FaceIndex.TOP_CENTER).setColor(middleRightSave);
    }

    public Row getTopRow() {
        return getTopRow(0);
    }

    public Row getTopRow(int rotation) {
        switch (rotation) {
            case 0:
                return new Row(
                        pieces.get(FaceIndex.TOP_LEFT),
                        pieces.get(FaceIndex.TOP_CENTER),
                        pieces.get(FaceIndex.TOP_RIGHT)
                );
            case 90:
                return getLeftRow();
            case 180:
                return new Row(
                        pieces.get(FaceIndex.BOTTOM_RIGHT),
                        pieces.get(FaceIndex.BOTTOM_CENTER),
                        pieces.get(FaceIndex.BOTTOM_LEFT)
                );
            case 270:
                return getRightRow();
            default:
                throw new IllegalArgumentException(
                        "Invalid top row rotation! " + rotation
                );
        }
    }

    public Row getBottomRow() {
        return getBottomRow(0);
    }

    public Row getBottomRow(int rotation) {
        switch (rotation) {
            case 0:
                return new Row(
                        pieces.get(FaceIndex.BOTTOM_LEFT),
                        pieces.get(FaceIndex.BOTTOM_CENTER),
                        pieces.get(FaceIndex.BOTTOM_RIGHT)
                );
            case 90:
                return getRightRow(180);
            case 180:
                return new Row(
                        pieces.get(FaceIndex.TOP_RIGHT),
                        pieces.get(FaceIndex.TOP_CENTER),
                        pieces.get(FaceIndex.TOP_LEFT)
                );
            case 270:
                return getLeftRow(180);
            default:
                throw new IllegalArgumentException(
                        "Invalid bottom row rotation! " + rotation
                );
        }
    }

    public Row getLeftRow() {
        return getLeftRow(0);
    }

    public Row getLeftRow(int rotation) {
        switch (rotation) {
            case 0:
                return new Row(
                        pieces.get(FaceIndex.BOTTOM_LEFT),
                        pieces.get(FaceIndex.MIDDLE_LEFT),
                        pieces.get(FaceIndex.TOP_LEFT)
                );
            case 90:
                return getBottomRow(180);
            case 180:
                return getRightRow();
            case 270:
                return getTopRow();
            default:
                throw new IllegalArgumentException(
                        "Invalid left row rotation! " + rotation
                );
        }
    }

    public Row getRightRow() {
        return getRightRow(0);
    }

    public Row getRightRow(int rotation) {
        switch (rotation) {
            case 0:
                return new Row(
                        pieces.get(FaceIndex.TOP_RIGHT),
                        pieces.get(FaceIndex.MIDDLE_RIGHT),
                        pieces.get(FaceIndex.BOTTOM_RIGHT)
                );
            case 90:
                return getTopRow();
            case 180:
                return getLeftRow();
            case 270:
                return getBottomRow(180);
            default:
                throw new IllegalArgumentException(
                        "Invalid right row rotation! " + rotation
                );
        }
    }

    public Row getMiddleRow() {
        return getMiddleRow(0);
    }

    public Row getMiddleRow(int rotation) {
        switch (rotation) {
            case 0:
                return new Row(
                        pieces.get(FaceIndex.MIDDLE_LEFT),
                        pieces.get(FaceIndex.MIDDLE_CENTER),
                        pieces.get(FaceIndex.MIDDLE_RIGHT)
                );
            case 90:
                return new Row(
                        pieces.get(FaceIndex.BOTTOM_CENTER),
                        pieces.get(FaceIndex.MIDDLE_CENTER),
                        pieces.get(FaceIndex.TOP_CENTER)
                );
            case 180:
                return new Row(
                        pieces.get(FaceIndex.MIDDLE_RIGHT),
                        pieces.get(FaceIndex.MIDDLE_CENTER),
                        pieces.get(FaceIndex.MIDDLE_LEFT)
                );
            case 270:
                return new Row(
                        pieces.get(FaceIndex.TOP_CENTER),
                        pieces.get(FaceIndex.MIDDLE_CENTER),
                        pieces.get(FaceIndex.BOTTOM_CENTER)
                );
            default:
                throw new IllegalArgumentException(
                        "Invalid middle row rotation! " + rotation
                );
        }
    }

    public void setTopRow(Row row) {
        getTopRow().set(row);
    }

    public void setMiddleRow(Row row)
    {
        getMiddleRow().set(row);
    }

    public void setBottomRow(Row row) {
        getBottomRow().set(row);
    }

    public void setLeftRow(Row row) {
        getLeftRow().set(row);
    }

    public void setRightRow(Row row) {
        getRightRow().set(row);
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return getFormattedString(0, "", "");
    }

    public String getFormattedString(int rotation, String beforeLine, String afterLine) {
        StringBuffer buf = new StringBuffer();
        buf.append(beforeLine);
        buf.append(getTopRowStr(rotation));
        buf.append(afterLine);
        buf.append("\n");
        buf.append(beforeLine);
        buf.append(getMiddleRowStr(rotation));
        buf.append(afterLine);
        buf.append("\n");
        buf.append(beforeLine);
        buf.append(getBottomRowStr(rotation));
        buf.append(afterLine);
        return buf.toString();
    }

    public String getTopRowStr()
    {
        return getTopRowStr(0);
    }

    public String getTopRowStr(int rotation)
    {
        return getTopRow(rotation).toString();
    }

    public String getBottomRowStr()
    {
        return getBottomRowStr(0);
    }

    public String getBottomRowStr(int rotation)
    {
        return getBottomRow(rotation).toString();
    }

    public String getLeftRowStr()
    {
        return getLeftRowStr(0);
    }

    public String getLeftRowStr(int rotation)
    {
        return getLeftRow(rotation).toString();
    }

    public String getRightRowStr()
    {
        return getRightRowStr(0);
    }

    public String getRightRowStr(int rotation)
    {
        return getRightRow(rotation).toString();
    }

    public String getMiddleRowStr()
    {
        return getMiddleRowStr(0);
    }

    public String getMiddleRowStr(int rotation)
    {
        return getMiddleRow(rotation).toString();
    }

    private enum FaceIndex
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

        private static Map<Integer, FaceIndex> indexMap = new HashMap<Integer, FaceIndex>();
        static
        {
            for (FaceIndex index : FaceIndex.values())
            {
                indexMap.put(index.value, index);
            }
        }

        private FaceIndex(int val, String description)
        {
            this.value = val;
            this.description = description;
        }

        private static FaceIndex fromInt(int value)
        {
            FaceIndex index = indexMap.get(value);
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
