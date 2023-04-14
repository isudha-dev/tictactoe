package lld.projects.tictactoe.strategy.GameWinningStrategy;

import lld.projects.tictactoe.models.Board;
import lld.projects.tictactoe.models.Cell;
import lld.projects.tictactoe.models.Player;

public interface GameWinningStrategy {

    boolean checkWinner(Board board, Player lastPlayedPlayer, Cell lastPlayedMove);

}
