package com.robertjgtoth.rubiks.model;

import java.util.HashMap;
import java.util.Map;

public class Cube
{

    private static final int NUM_FACES = 6;

    private Map<Position, Face> faces = new HashMap<Position, Face>();

    public Cube()
    {
        for (int i = 0; i < NUM_FACES; i++)
        {
            Position pos = Position.fromInt(i);
            faces.put(pos, new Face(pos.getDefaultColor()));
        }
    }

    public void randomize()
    {
        // TODO: Figure out how to implement randomize();
    }

    public void up()
    {
        faces.get(Position.UP).rotateClockwise();
        Row leftTop = new Row(faces.get(Position.LEFT).getTopRow());
        Row backTop = new Row(faces.get(Position.BACK).getTopRow());
        Row rightTop = new Row(faces.get(Position.RIGHT).getTopRow());
        Row frontTop = new Row(faces.get(Position.FRONT).getTopRow());
        faces.get(Position.BACK).setTopRow(leftTop);
        faces.get(Position.RIGHT).setTopRow(backTop);
        faces.get(Position.FRONT).setTopRow(rightTop);
        faces.get(Position.LEFT).setTopRow(frontTop);
    }
    public void upInverse()
    {
        faces.get(Position.UP).rotateCounterClockwise();
        Row rightTop = new Row(faces.get(Position.RIGHT).getTopRow());
        Row backTop = new Row(faces.get(Position.BACK).getTopRow());
        Row leftTop = new Row(faces.get(Position.LEFT).getTopRow());
        Row frontTop = new Row(faces.get(Position.FRONT).getTopRow());
        faces.get(Position.BACK).setTopRow(rightTop);
        faces.get(Position.LEFT).setTopRow(backTop);
        faces.get(Position.FRONT).setTopRow(leftTop);
        faces.get(Position.RIGHT).setTopRow(frontTop);
    }

    public void front()
    {
        faces.get(Position.FRONT).rotateClockwise();
        Row leftRight180 = new Row(faces.get(Position.LEFT).getRightRow(180));
        Row upBottom180 = new Row(faces.get(Position.UP).getBottomRow(180));
        Row rightLeft = new Row(faces.get(Position.RIGHT).getLeftRow());
        Row downTop = new Row(faces.get(Position.DOWN).getTopRow());
        faces.get(Position.UP).setBottomRow(leftRight180);
        faces.get(Position.RIGHT).setLeftRow(upBottom180);
        faces.get(Position.DOWN).setTopRow(rightLeft);
        faces.get(Position.LEFT).setRightRow(downTop);
    }

    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        String spaces = new String(new char[Face.LINE_WIDTH]).replace('\0', ' ');
        String dashes = new String(new char[Face.LINE_WIDTH]).replace('\0', '-');

        buf.append("CUBE\n-------\n");
        buf.append(faces.get(Position.BACK).getFormattedString(180, spaces, spaces));
        buf.append("\n");
        buf.append(spaces);
        buf.append(dashes);
        buf.append(spaces);
        buf.append("\n");
        buf.append(faces.get(Position.LEFT).getTopRowStr(90));
        buf.append(faces.get(Position.UP).getTopRowStr());
        buf.append(faces.get(Position.RIGHT).getTopRowStr(270));
        buf.append("\n");
        buf.append(faces.get(Position.LEFT).getMiddleRowStr(90));
        buf.append(faces.get(Position.UP).getMiddleRowStr());
        buf.append(faces.get(Position.RIGHT).getMiddleRowStr(270));
        buf.append("\n");
        buf.append(faces.get(Position.LEFT).getBottomRowStr(90));
        buf.append(faces.get(Position.UP).getBottomRowStr());
        buf.append(faces.get(Position.RIGHT).getBottomRowStr(270));
        buf.append("\n");
        buf.append(spaces);
        buf.append(dashes);
        buf.append(spaces);
        buf.append("\n");
        buf.append(faces.get(Position.FRONT).getFormattedString(0, spaces, spaces));
        buf.append("\n");
        buf.append(spaces);
        buf.append(dashes);
        buf.append(spaces);
        buf.append("\n");
        buf.append(faces.get(Position.DOWN).getFormattedString(0, spaces, spaces));
        buf.append("\n");
        buf.append("-------\n");

        return buf.toString();
    }

    private enum Position
    {
        FRONT(0, "Front", Color.RED),
        BACK(1, "Back", Color.ORANGE),
        UP(2, "Up", Color.WHITE),
        DOWN(3, "Down", Color.YELLOW),
        LEFT(4, "Left", Color.GREEN),
        RIGHT(5, "Right", Color.BLUE);

        private static Map<Integer, Position> positionMap = new HashMap<Integer, Position>();
        static
        {
            for (Position position : Position.values())
            {
                positionMap.put(position.value, position);
            }
        }

        private int value;
        private String description;
        private Color defaultColor;

        private Position(int val, String description, Color defaultColor)
        {
            this.value = val;
            this.description = description;
            this.defaultColor = defaultColor;
        }

        private Color getDefaultColor()
        {
            return defaultColor;
        }

        private static Position fromInt(int value)
        {
            Position position = positionMap.get(value);
            if (position == null)
            {
                throw new IllegalArgumentException(
                        "Invalid position value: " + value);
            }
            return position;
        }

        public String toString()
        {
            return description;
        }

    }


}
