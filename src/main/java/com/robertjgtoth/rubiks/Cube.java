package com.robertjgtoth.rubiks;

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

    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        String spaces = new String(new char[Face.LINE_WIDTH]).replace('\0', ' ');
        String dashes = new String(new char[Face.LINE_WIDTH]).replace('\0', '-');

        buf.append("CUBE\n-------\n");
        buf.append(faces.get(Position.BACK).getFormattedString(spaces, spaces));
        buf.append("\n");
        buf.append(spaces);
        buf.append(dashes);
        buf.append(spaces);
        buf.append("\n");
        buf.append(faces.get(Position.LEFT).getTopLineStr());
        buf.append(faces.get(Position.UP).getTopLineStr());
        buf.append(faces.get(Position.RIGHT).getTopLineStr());
        buf.append("\n");
        buf.append(faces.get(Position.LEFT).getMiddleLineStr());
        buf.append(faces.get(Position.UP).getMiddleLineStr());
        buf.append(faces.get(Position.RIGHT).getMiddleLineStr());
        buf.append("\n");
        buf.append(faces.get(Position.LEFT).getBottomLineStr());
        buf.append(faces.get(Position.UP).getBottomLineStr());
        buf.append(faces.get(Position.RIGHT).getBottomLineStr());
        buf.append("\n");
        buf.append(spaces);
        buf.append(dashes);
        buf.append(spaces);
        buf.append("\n");
        buf.append(faces.get(Position.FRONT).getFormattedString(spaces, spaces));
        buf.append("\n");
        buf.append(spaces);
        buf.append(dashes);
        buf.append(spaces);
        buf.append("\n");
        buf.append(faces.get(Position.DOWN).getFormattedString(spaces, spaces));
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