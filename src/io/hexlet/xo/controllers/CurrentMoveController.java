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
        int countX = 0;
        int countO = 0;
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                try {
                    switch (field.getFigure(new Point(x, y))) {
                        case O:
                            countO++;
                            break;
                        case X:
                            countX++;
                            break;
                    }
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        if (countX == countO) {
            return Figure.X;
        }
        if (countX + countO == field.getSize() * field.getSize()) {
            return null;
        }
        return Figure.O;
    }
}
