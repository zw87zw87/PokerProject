package com.zte.poker.service;

import com.zte.poker.bean.GameResult;
import com.zte.poker.bean.PokerPlayer;
import com.zte.poker.bean.PokerRank;
import com.zte.poker.exception.ParameterException;

public class PokerHandsImpl implements PokerHands {

    public GameResult playGame(String black, String white) throws ParameterException {
        PokerPlayer player1 = new PokerPlayer(black);
        PokerPlayer player2 = new PokerPlayer(white);
        for (PokerRank rank : PokerRank.values()) {
            setPokerRank(player1, rank);
            setPokerRank(player2, rank);
        }
        if (player1.getPokerRank().priority > player2.getPokerRank().priority) {
            return GameResult.WIN;
        } else if (player1.getPokerRank().priority < player2.getPokerRank().priority) {
            return GameResult.LOSS;
        }

        return player1.getPokerRank().compareSameRank.apply(player1.getPokers(), player2.getPokers());
    }

    private static void setPokerRank(PokerPlayer player, PokerRank rank) {
        if (player.getPokerRank() == null && rank.isSatisfy.apply(player.getPokers())) {
            player.setPokerRank(rank);
        }
    }
}
