package lld.projects.tictactoe.strategy.BotPlayingStrategy;

import lld.projects.tictactoe.models.Move;
import lld.projects.tictactoe.models.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player);
}
