package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by Lelysi on 08.11.2015.
 */
public class CurrentMoveController {

    public Figure currentMove(final Field field){
        int countFigures = 0;

        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                try {
                    if (field.getFigure(new Point(x, y)) != null) {
                        countFigures++;
                    }
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }

        if (countFigures == field.getSize() * field.getSize()) {
            return null;
        }

        if (countFigures % 2 == 0) {
            return Figure.X;
        }

        return Figure.O;
    }
}
