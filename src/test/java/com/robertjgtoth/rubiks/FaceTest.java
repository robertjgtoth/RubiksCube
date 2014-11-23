package com.robertjgtoth.rubiks;

import org.junit.*;
import static org.junit.Assert.*;

public class FaceTest {

    @Test
    public void testFaceCreation() throws Exception {
        Face f = new Face(Color.WHITE);
        assertNotNull(f);
        assertEquals(Color.WHITE, f.getColor());
    }

    @Test
    public void testBasicStringRepresentation()
    {
        Face f  = new Face(Color.BLUE);
        StringBuffer expected = new StringBuffer();
        expected.append("| BLU  BLU  BLU |\n");
        expected.append("| BLU  BLU  BLU |\n");
        expected.append("| BLU  BLU  BLU |");
        assertEquals(expected.toString(), f.toString());
    }

    @Test public void testBeforeAndAfterStringRepresentation()
    {
        Face f  = new Face(Color.GREEN);
        StringBuffer expected = new StringBuffer();
        expected.append("xxx| GRE  GRE  GRE |yyy\n");
        expected.append("xxx| GRE  GRE  GRE |yyy\n");
        expected.append("xxx| GRE  GRE  GRE |yyy");
        assertEquals(expected.toString(), f.getFormattedString(0, "xxx", "yyy"));
    }

    @Test
    public void testSetRows()
    {
        Face f = new Face(Color.YELLOW);
        f.setTopRow(new Row(
                new Piece(Color.RED),
                new Piece(Color.RED),
                new Piece(Color.RED)
        ));
        f.setMiddleRow(new Row(
                new Piece(Color.WHITE),
                new Piece(Color.WHITE),
                new Piece(Color.WHITE)
        ));
        f.setBottomRow(new Row(
                new Piece(Color.BLUE),
                new Piece(Color.BLUE),
                new Piece(Color.BLUE)
        ));

        StringBuffer expected = new StringBuffer();
        expected.append("| RED  RED  RED |\n");
        expected.append("| WHI  WHI  WHI |\n");
        expected.append("| BLU  BLU  BLU |");
        assertEquals(expected.toString(), f.toString());
    }

    @Test
    public void testRotatedStringRepresentation()
    {
        Face f = new Face(Color.YELLOW);
        f.setTopRow(new Row(
                new Piece(Color.RED),
                new Piece(Color.RED),
                new Piece(Color.RED)
        ));
        f.setMiddleRow(new Row(
                new Piece(Color.WHITE),
                new Piece(Color.WHITE),
                new Piece(Color.WHITE)
        ));
        f.setBottomRow(new Row(
                new Piece(Color.BLUE),
                new Piece(Color.BLUE),
                new Piece(Color.BLUE)
        ));

        StringBuffer expected90 = new StringBuffer();
        expected90.append("| BLU  WHI  RED |\n");
        expected90.append("| BLU  WHI  RED |\n");
        expected90.append("| BLU  WHI  RED |");

        StringBuffer expected180 = new StringBuffer();
        expected180.append("| BLU  BLU  BLU |\n");
        expected180.append("| WHI  WHI  WHI |\n");
        expected180.append("| RED  RED  RED |");

        StringBuffer expected270 = new StringBuffer();
        expected270.append("| RED  WHI  BLU |\n");
        expected270.append("| RED  WHI  BLU |\n");
        expected270.append("| RED  WHI  BLU |");

        assertEquals(expected90.toString(), f.getFormattedString(90, "", ""));
        assertEquals(expected180.toString(), f.getFormattedString(180, "", ""));
        assertEquals(expected270.toString(), f.getFormattedString(270, "", ""));
    }

    @Test
    public void testRotateClockwise()
    {
        Face f = new Face(Color.YELLOW);
        f.setTopRow(new Row(
                new Piece(Color.RED),
                new Piece(Color.RED),
                new Piece(Color.RED)
        ));
        f.setMiddleRow(new Row(
                new Piece(Color.WHITE),
                new Piece(Color.WHITE),
                new Piece(Color.WHITE)
        ));
        f.setBottomRow(new Row(
                new Piece(Color.BLUE),
                new Piece(Color.BLUE),
                new Piece(Color.BLUE)
        ));

        f.rotateClockwise();

        StringBuffer expected90 = new StringBuffer();
        expected90.append("| BLU  WHI  RED |\n");
        expected90.append("| BLU  WHI  RED |\n");
        expected90.append("| BLU  WHI  RED |");

        assertEquals(expected90.toString(), f.toString());
    }

    @Test
    public void testRotateCounterClockwise()
    {
        Face f = new Face(Color.YELLOW);
        f.setTopRow(new Row(
                new Piece(Color.RED),
                new Piece(Color.RED),
                new Piece(Color.RED)
        ));
        f.setMiddleRow(new Row(
                new Piece(Color.WHITE),
                new Piece(Color.WHITE),
                new Piece(Color.WHITE)
        ));
        f.setBottomRow(new Row(
                new Piece(Color.BLUE),
                new Piece(Color.BLUE),
                new Piece(Color.BLUE)
        ));

        f.rotateCounterClockwise();

        StringBuffer expected270 = new StringBuffer();
        expected270.append("| RED  WHI  BLU |\n");
        expected270.append("| RED  WHI  BLU |\n");
        expected270.append("| RED  WHI  BLU |");

        assertEquals(expected270.toString(), f.toString());
    }
}