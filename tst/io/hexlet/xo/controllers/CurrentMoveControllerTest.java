package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Lelysi on 08.11.2015.
 */
public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenNextMoveIsO() throws Exception {
        CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }
}