package lld.projects.tictactoe.strategy.GameWinningStrategy;

import lld.projects.tictactoe.models.Board;
import lld.projects.tictactoe.models.Cell;
import lld.projects.tictactoe.models.Player;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
    private int dimension;

    public OrderOneGameWinningStrategy(int dimension){
        this.dimension = dimension;
    }
    @Override public boolean checkWinner(final Board board, final Player lastPlayedPlayer, final Cell lastPlayedMove) {
        // TODO: implement this
        return false;
    }
}
