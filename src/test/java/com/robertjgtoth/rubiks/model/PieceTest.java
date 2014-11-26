package com.robertjgtoth.rubiks.model;

import org.junit.*;
import static org.junit.Assert.*;

public class PieceTest {

    @Test
    public void testPieceCreation() throws Exception {
        Piece p = new Piece(Color.BLUE);
        assertNotNull(p);
        assertEquals(Color.BLUE, p.getColor());
    }

    @Test
    public void testNullColorThrowsException()
    {
        try {
            Piece invalid = new Piece(null);
            fail("Piece creation with null color should throw Exception");
        }
        catch (IllegalArgumentException iae)
        {
            assertEquals("Color cannot be null!", iae.getMessage());
        }
    }

    @Test
    public void testSetColor() throws Exception {
        Piece p = new Piece(Color.ORANGE);
        p.setColor(Color.GREEN);
        assertEquals(Color.GREEN, p.getColor());
    }

    @Test
    public void testToString() throws Exception {
        Piece white = new Piece(Color.WHITE);
        Piece yellow = new Piece(Color.YELLOW);
        Piece red = new Piece(Color.RED);
        Piece orange = new Piece(Color.ORANGE);
        Piece blue = new Piece(Color.BLUE);
        Piece green = new Piece(Color.GREEN);

        assertEquals(" WHI ", white.toString());
        assertEquals(" YEL ", yellow.toString());
        assertEquals(" RED ", red.toString());
        assertEquals(" ORA ", orange.toString());
        assertEquals(" BLU ", blue.toString());
        assertEquals(" GRE ", green.toString());
    }

    @Test
    public void testEquals() throws Exception
    {
        Piece whiteOne = new Piece(Color.WHITE);
        Piece whiteTwo = new Piece(Color.WHITE);
        Piece green = new Piece(Color.GREEN);

        assertEquals(whiteOne, whiteOne);
        assertEquals(whiteOne, whiteTwo);
        assertNotEquals(whiteOne, green);
    }

}