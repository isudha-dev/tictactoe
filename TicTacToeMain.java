package lld.projects.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lld.projects.tictactoe.controller.GameController;
import lld.projects.tictactoe.models.Bot;
import lld.projects.tictactoe.models.BotDifficultyLevel;
import lld.projects.tictactoe.models.Game;
import lld.projects.tictactoe.models.GameStatus;
import lld.projects.tictactoe.models.Player;
import lld.projects.tictactoe.models.PlayerType;
import lld.projects.tictactoe.strategy.BotPlayingStrategy.RandomBotPlayingStrategy;

public class TicTacToeMain {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);
        System.out.println("What should be the dimension of game?");
        int dimension = scanner.nextInt();
        System.out.println("Will there be any bot? y/n");
        String isBotString = scanner.next();

        int toIterate = dimension - 1;
        if (isBotString.equals("y")) {
            toIterate = dimension - 2;
        }

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < toIterate; ++i) {
            System.out.println("What is the name of player " + i);
            String playerName = scanner.next();

            System.out.println("What is the char of player " + i);
            String playerSymbol = scanner.next();

            players.add(new Player(playerName, playerSymbol.charAt(0), PlayerType.HUMAN));
        }

        if (isBotString.equals("y")) {
            System.out.println("What is the name of bot?");
            String playerName = scanner.next();

            System.out.println("What is the char of bot?");
            String playerSymbol = scanner.next();

            players.add(new Bot(playerName, playerSymbol.charAt(0), BotDifficultyLevel.EASY, new RandomBotPlayingStrategy()));
        }

        Game game = gameController.createGame(dimension, players);
        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("This is the current board:");
            gameController.displayBoard(game);

            System.out.println("Does anyone want to undo? y/n");
            String input = scanner.next();
            if (input.equals("y")) {
                gameController.undo(game);
            } else {
                gameController.executeNextMove(game);
            }
        }

        System.out.println("Game has ended. Board was: ");
        gameController.displayBoard(game);
        if (!game.getGameStatus().equals(GameStatus.DRAW)) {
            System.out.println("Winner is: " + gameController.getWinner(game).getName());
        }

    }

}
