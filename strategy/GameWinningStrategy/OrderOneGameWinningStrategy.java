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
    HashMap<Character, Integer> diag1 = new HashMap<>(); // left to right
    HashMap<Character, Integer> diag2 = new HashMap<>(); // right to left

    public OrderOneGameWinningStrategy(int dimension){
        this.dimension = dimension;
        for(int i = 0; i < dimension; i++){
            rows.add(new HashMap<>());
            cols.add(new HashMap<>());
        }
    }

    private boolean isLeftToRightDiagonal(int row, int col){
        return row == col;
    }

    private boolean isRightToLeftDiagonal(int row, int col){
        return row+col == dimension-1;
    }

    @Override public boolean checkWinner(final Board board, final Player lastPlayedPlayer, final Cell lastPlayedMove) {
        // TODO: implement this

        Character ch =  lastPlayedPlayer.getSymbol();
        int row = lastPlayedMove.getRow();
        int col = lastPlayedMove.getCol();

        rows.get(row).put(ch, rows.get(row).getOrDefault(ch, 0) + 1);
        cols.get(col).put(ch, cols.get(col).getOrDefault(ch, 0) + 1);

        if(isLeftToRightDiagonal(row, col)){
            diag1.put(ch, diag1.getOrDefault(ch, 0)+1);
        }

        if(isRightToLeftDiagonal(row, col)){
            diag2.put(ch, diag2.getOrDefault(ch, 0)+1);
        }

        if((rows.get(row).get(lastPlayedPlayer.getSymbol()) == dimension) || cols.get(col).get(lastPlayedPlayer.getSymbol()) == dimension) {
            return true;
        }
        if(isLeftToRightDiagonal(row, col) && diag1.get(lastPlayedPlayer.getSymbol()) == dimension) {
            return true;
        }
        if(isRightToLeftDiagonal(row, col) && diag2.get(lastPlayedPlayer.getSymbol()) == dimension) {
            return true;
        }

        return false;
    }
}
