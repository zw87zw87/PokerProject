package com.zte.poker.service;

import com.zte.poker.bean.GameResult;
import com.zte.poker.exception.ParameterException;

public interface PokerHands {
    GameResult playGame(String black, String white) throws ParameterException;
}
