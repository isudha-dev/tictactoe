package lld.projects.tictactoe.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lld.projects.tictactoe.exception.InvalidGameConstructionParametersException;
import lld.projects.tictactoe.strategy.GameWinningStrategy.GameWinningStrategy;
import lld.projects.tictactoe.strategy.GameWinningStrategy.OrderOneGameWinningStrategy;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Player winner;
    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;

    public Board getBoard() {
        return board;
    }
    public void setBoard(final Board board) {
        this.board = board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(final List<Player> players) {
        this.players = players;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(final List<Move> moves) {
        this.moves = moves;
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(final GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }
    public void setNextPlayerIndex(final int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
    public Player getWinner() {
        return winner;
    }
    public void setWinner(final Player winner) {
        this.winner = winner;
    }
    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }
    public void setGameWinningStrategy(final GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    private Game() {

    }

    public static Builder getBuilder() {
        return new Builder();
    }

    private static class Builder {
        private int dimension;
        private List<Player> players;

        public Builder setDimension(final int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(final List<Player> players) {
            this.players = players;
            return this;
        }

        private boolean valid() throws InvalidGameConstructionParametersException {
            if(this.dimension < 3){
                throw new InvalidGameConstructionParametersException("Dimension of game can't be less than 3");
            }
            if (this.players.size() != dimension-1){
                throw new InvalidGameConstructionParametersException("No. of players should be one less than game dimension");
            }
            // TODO: validate no 2 player with same char
            HashSet<Character> symbolSet = new HashSet<>();
            for(Player pl : players){
                symbolSet.add(pl.getSymbol());
            }
            if(symbolSet.size() < dimension){
                throw new InvalidGameConstructionParametersException("Players can not select same symbols");
            }

            // TODO: validate only 1 bot player
            int count = 0;
            for(Player pl : players){
                if(pl.getPlayerType() == PlayerType.BOT){
                    count++;
                }
            }
            if(count > 1){
                throw new InvalidGameConstructionParametersException("We can have only 1 bot in game");
            }

            return true;
        }

        public Game build() throws InvalidGameConstructionParametersException {
            try {
                valid();
            }catch (Exception e){
                throw new InvalidGameConstructionParametersException(e.getMessage());
            }

            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setBoard(new Board(dimension));
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimension));
            return game;
        }
    }


}
