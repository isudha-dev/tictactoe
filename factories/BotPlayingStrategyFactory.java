package lld.projects.tictactoe.factories;

import lld.projects.tictactoe.models.BotDifficultyLevel;
import lld.projects.tictactoe.strategy.BotPlayingStrategy.BotPlayingStrategy;
import lld.projects.tictactoe.strategy.BotPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        return new RandomBotPlayingStrategy();

    }
}
