package com.robertjgtoth.rubiks;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void testFromInt() throws Exception {
        Color white = Color.fromInt(0);
        Color yellow = Color.fromInt(1);
        Color red = Color.fromInt(2);
        Color orange = Color.fromInt(3);
        Color blue = Color.fromInt(4);
        Color green = Color.fromInt(5);

        assertEquals(Color.WHITE, white);
        assertEquals(Color.YELLOW, yellow);
        assertEquals(Color.RED, red);
        assertEquals(Color.ORANGE, orange);
        assertEquals(Color.BLUE, blue);
        assertEquals(Color.GREEN, green);
    }

    @Test public void testFromInvalidInt() throws Exception
    {
        try
        {
            Color invalid = Color.fromInt(-1);
            fail("Color.fromInt(-1) should throw Exception");
        }
        catch (IllegalArgumentException iae)
        {
            assertEquals("Invalid Color value: -1", iae.getMessage());
        }
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(" WHI ", Color.WHITE.toString());
        assertEquals(" YEL ", Color.YELLOW.toString());
        assertEquals(" RED ", Color.RED.toString());
        assertEquals(" ORA ", Color.ORANGE.toString());
        assertEquals(" BLU ", Color.BLUE.toString());
        assertEquals(" GRE ", Color.GREEN.toString());
    }
}