package lld.projects.tictactoe.controller;

import java.util.List;
import lld.projects.tictactoe.exception.InvalidGameConstructionParametersException;
import lld.projects.tictactoe.models.Game;
import lld.projects.tictactoe.models.GameStatus;
import lld.projects.tictactoe.models.Player;

public class GameController {

    public void undo(Game game){
        game.undo();
    }

    public Game createGame(int dimension, List<Player> players){
        try {
            Game game = Game.getBuilder().setDimension(dimension).setPlayers(players).build();
            return game;
        } catch (Exception e) {
            return null;
        }
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }


}
