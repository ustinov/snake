package com.codenjoy.dojo.bomberman.services;

import com.codenjoy.dojo.bomberman.model.*;
import com.codenjoy.dojo.services.*;

/**
 * User: oleksandr.baglai
 * Date: 3/9/13
 * Time: 7:18 PM
 */
public class BombermanGame implements GameType {


    public static final String GAME_NAME = "bomberman";
    private DefaultGameSettings settings;
    private Board board;

    public BombermanGame() {
        settings = new DefaultGameSettings();
        board = new Board(settings);
    }

    @Override
    public PlayerScores getPlayerScores(int score) {
        return new BombermanPlayerScores(score);
    }

    @Override
    public Game newGame(EventListener listener) {
        Game game = new SingleBoard(board, listener);
        game.newGame();
        return game;
    }

    @Override
    public int getBoardSize() {
        return settings.getBoardSize();
    }

    @Override
    public String gameName() {
        return GAME_NAME;
    }

    @Override
    public Object[] getPlots() {
        return PlotColor.values();
    }
}
