package lld.projects.tictactoe.models;

public class Move {
    private Player player;
    private Cell cell;

    public Move(final Player player, final Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(final Player player) {
        this.player = player;
    }
    public Cell getCell() {
        return cell;
    }
    public void setCell(final Cell cell) {
        this.cell = cell;
    }
}
