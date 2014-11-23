package com.robertjgtoth.rubiks;

import org.junit.*;
import static org.junit.Assert.*;

public class RowTest {

    @Test
    public void testRowCreation() throws Exception
    {
        Row r = new Row(
                new Piece(Color.RED),
                new Piece(Color.WHITE),
                new Piece(Color.BLUE)
        );
        assertNotNull(r);
    }

    @Test
    public void testSet() throws Exception {
        Row before = new Row(
                new Piece(Color.RED),
                new Piece(Color.WHITE),
                new Piece(Color.BLUE)
        );
        Row after = new Row(
                new Piece(Color.ORANGE),
                new Piece(Color.YELLOW),
                new Piece(Color.GREEN)
        );
        before.set(after);
        assertEquals(after, before);
    }

    @Test
    public void testToString() throws Exception {
        Row r = new Row(
                new Piece(Color.RED),
                new Piece(Color.WHITE),
                new Piece(Color.BLUE)
        );

        StringBuffer expected = new StringBuffer();
        expected.append("| RED  WHI  BLU |");

        assertEquals(expected.toString(), r.toString());
    }
}