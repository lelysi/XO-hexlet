package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Lelysi on 07.11.2015.
 */
public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThanZero() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThanMaxCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.getSize(), 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThanMaxCoordinate() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, field.getSize());

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }
}