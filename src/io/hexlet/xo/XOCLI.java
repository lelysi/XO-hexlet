package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.XOView;

/**
 * Created by Lelysi on 08.11.2015.
 */
public class XOCLI {

    public static void main(String[] args) {
        final String name1 = "John";
        final String name2 = "Zed";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final XOView xoView = new XOView();

        xoView.show(gameXO);
        while (xoView.move(gameXO)){
            xoView.show(gameXO);
        }
    }

}
