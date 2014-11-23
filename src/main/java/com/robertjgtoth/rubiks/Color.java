package com.robertjgtoth.rubiks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by rtoth on 11/22/2014.
 */
public enum Color {

    WHITE(0, "WHI"),
    YELLOW(1, "YEL"),
    RED(2, "RED"),
    ORANGE(3, "ORA"),
    BLUE(4, "BLU"),
    GREEN(5,"GRE");

    private static final Random rand = new Random();
    private static Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
    static
    {
        for (Color color : Color.values())
        {
            colorMap.put(color.value, color);
        }
    }

    private int value;
    private String description;

    private Color(int val, String description)
    {
        this.value = val;
        this.description = description;
    }

    public static Color fromInt(int val)
    {
        Color color = colorMap.get(val);
        if (color == null)
        {
            throw new IllegalArgumentException(
                "Invalid Color value: " + val);
        }
        return color;
    }

    public static Color random()
    {
        int maxVal = Collections.max(colorMap.keySet());
        return fromInt(rand.nextInt(maxVal));
    }

    public String toString()
    {
        return " " + description + " ";
    }

}
