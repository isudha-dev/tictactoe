package lld.projects.tictactoe.strategy.BotPlayingStrategy;

import lld.projects.tictactoe.models.Board;
import lld.projects.tictactoe.models.Cell;
import lld.projects.tictactoe.models.CellState;
import lld.projects.tictactoe.models.Move;
import lld.projects.tictactoe.models.Player;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{

    @Override public Move decideMove(Board board, Player player) {
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().size(); j++) {
                if (board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    return new Move(
                        player,
                        new Cell(i, j)
                    );
                }
            }
        }


        return null;
    }
}
