package com.zte.poker.service;

import com.zte.poker.bean.GameResult;

public interface PokerHands {
    GameResult playGame(String black, String white);
}
