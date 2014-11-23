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
    public void testBasicStringRepresentation() throws Exception
    {
        Face f  = new Face(Color.BLUE);
        StringBuffer expected = new StringBuffer();
        expected.append("| BLU  BLU  BLU |\n");
        expected.append("| BLU  BLU  BLU |\n");
        expected.append("| BLU  BLU  BLU |");
        assertEquals(expected.toString(), f.toString());
    }

    @Test public void testBeforeAndAfterStringRepresentation() throws Exception
    {
        Face f  = new Face(Color.GREEN);
        StringBuffer expected = new StringBuffer();
        expected.append("xxx| GRE  GRE  GRE |yyy\n");
        expected.append("xxx| GRE  GRE  GRE |yyy\n");
        expected.append("xxx| GRE  GRE  GRE |yyy");
        assertEquals(expected.toString(), f.getFormattedString(0, "xxx", "yyy"));
    }

    @Test
    public void testSetRows() throws Exception
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
    public void testRotatedStringRepresentation() throws Exception
    {
        Face f = new Face(Color.YELLOW);
        f.setTopRow(new Row(
                new Piece(Color.RED),
                new Piece(Color.WHITE),
                new Piece(Color.BLUE)
        ));
        f.setMiddleRow(new Row(
                new Piece(Color.ORANGE),
                new Piece(Color.YELLOW),
                new Piece(Color.GREEN)
        ));
        f.setBottomRow(new Row(
                new Piece(Color.GREEN),
                new Piece(Color.WHITE),
                new Piece(Color.ORANGE)
        ));

        StringBuffer expected0 = new StringBuffer();
        expected0.append("| RED  WHI  BLU |\n");
        expected0.append("| ORA  YEL  GRE |\n");
        expected0.append("| GRE  WHI  ORA |");

        StringBuffer expected90 = new StringBuffer();
        expected90.append("| GRE  ORA  RED |\n");
        expected90.append("| WHI  YEL  WHI |\n");
        expected90.append("| ORA  GRE  BLU |");

        StringBuffer expected180 = new StringBuffer();
        expected180.append("| ORA  WHI  GRE |\n");
        expected180.append("| GRE  YEL  ORA |\n");
        expected180.append("| BLU  WHI  RED |");

        StringBuffer expected270 = new StringBuffer();
        expected270.append("| BLU  GRE  ORA |\n");
        expected270.append("| WHI  YEL  WHI |\n");
        expected270.append("| RED  ORA  GRE |");

        assertEquals(expected90.toString(), f.getFormattedString(90, "", ""));
        assertEquals(expected180.toString(), f.getFormattedString(180, "", ""));
        assertEquals(expected270.toString(), f.getFormattedString(270, "", ""));
    }

    @Test
    public void testRotateClockwise() throws Exception
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
    public void testRotateCounterClockwise() throws Exception
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

    @Test
    public void testRotatedLeftRow() throws Exception
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

        assertEquals("| BLU  WHI  RED |", f.getLeftRowStr());
        assertEquals("| BLU  BLU  BLU |", f.getLeftRowStr(90));
        assertEquals("| RED  WHI  BLU |", f.getLeftRowStr(180));
        assertEquals("| RED  RED  RED |", f.getLeftRowStr(270));
    }

    @Test
    public void testRotatedRightRow() throws Exception
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

        assertEquals("| RED  WHI  BLU |", f.getRightRowStr());
        assertEquals("| RED  RED  RED |", f.getRightRowStr(90));
        assertEquals("| BLU  WHI  RED |", f.getRightRowStr(180));
        assertEquals("| BLU  BLU  BLU |", f.getRightRowStr(270));
    }
}
