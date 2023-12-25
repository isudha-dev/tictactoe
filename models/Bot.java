package lld.projects.tictactoe.models;

import lld.projects.tictactoe.strategy.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(final String name, final char symbol, BotDifficultyLevel botDifficultyLevel, BotPlayingStrategy botPlayingStrategy) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move decideMove(Board board){
        return botPlayingStrategy.decideMove(board,this);
    }
}
