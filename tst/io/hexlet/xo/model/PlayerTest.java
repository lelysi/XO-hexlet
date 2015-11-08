package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Lelysi on 07.11.2015.
 */
public class PlayerTest {

    @Test
    public void testGetName() throws Exception {
        final String inputValue = "John";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFigure() throws Exception {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThanMaxCoordinate() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize(), 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThanMaxCoordinate() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getSize());

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }
}