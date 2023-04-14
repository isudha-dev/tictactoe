package lld.projects.tictactoe.strategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lld.projects.tictactoe.models.Board;
import lld.projects.tictactoe.models.Cell;
import lld.projects.tictactoe.models.Player;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
    private int dimension;

    List<HashMap<Character, Integer>> rows = new ArrayList<>();
    List<HashMap<Character, Integer>> cols = new ArrayList<>();
    List<HashMap<Character, Integer>> diag1 = new ArrayList<>();
    List<HashMap<Character, Integer>> diag2 = new ArrayList<>();

    public OrderOneGameWinningStrategy(int dimension){
        this.dimension = dimension;
    }
    @Override public boolean checkWinner(final Board board, final Player lastPlayedPlayer, final Cell lastPlayedMove) {
        // TODO: implement this

        Character ch =  lastPlayedPlayer.getSymbol();
        int row = lastPlayedMove.getRow();
        int col = lastPlayedMove.getCol();

        rows.get(row).put(ch, rows.get(row).getOrDefault(ch, 0) + 1);
        cols.get(col).put(ch, cols.get(col).getOrDefault(ch, 0) + 1);
        if(row == col)
            diag1.get(row).put(ch, diag1.get(row).getOrDefault(ch, 0) + 1);
        if(row+col == dimension)
            diag2.get(row).put(ch, diag2.get(row).getOrDefault(ch, 0) + 1);

        if(rows.get(row).get(ch) == dimension){
            return true;
        }
        if(cols.get(col).get(ch) == dimension){
            return true;
        }
        if(diag1.get(row).get(ch) == dimension){
            return true;
        }
        if(diag2.get(row).get(ch) == dimension){
            return true;
        }

        return false;
    }
}
