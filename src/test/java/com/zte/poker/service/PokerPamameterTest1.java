package com.zte.poker.service;

import com.zte.poker.bean.GameResult;
import com.zte.poker.exception.ParameterException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertEquals;

public class PokerPamameterTest1 {

    @ParameterizedTest(name = "{index}: black={0}, white={1}, expected={2}")
    @CsvFileSource(resources = {"/poker_result.csv"})
    public void test(String black, String white, GameResult result) throws ParameterException {
        PokerHands hands = new PokerHandsImpl();
        assertEquals(result, hands.playGame(black, white));
    }
}
