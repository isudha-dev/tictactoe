package lld.projects.tictactoe.models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player(final String name, final char symbol, final PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move decideMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please tell the row");
        int row = sc.nextInt();
        System.out.println("Please tell the col");
        int col = sc.nextInt();
        return new Move(this, new Cell(--row, --col));
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(final char symbol) {
        this.symbol = symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(final PlayerType playerType) {
        this.playerType = playerType;
    }

}
