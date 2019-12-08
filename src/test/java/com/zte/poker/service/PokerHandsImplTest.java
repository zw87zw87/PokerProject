package com.zte.poker.service;

import com.zte.poker.bean.GameResult;
import com.zte.poker.exception.ParameterException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandsImplTest {
    private PokerHands hands = new PokerHandsImpl();

    @Test(expected = ParameterException.class)
    public void throw_exception_when_value_is_null() throws ParameterException {
        assertEquals(GameResult.LOSS, hands.playGame("2H 3D 5S 9C KD", null));
    }

    @Test(expected = ParameterException.class)
    public void throw_exception_when_value_is_illegal() throws ParameterException {
        assertEquals(GameResult.LOSS, hands.playGame("2H 3D 5S 9C KD", "2H 3D 5S 9C A"));
    }

    @Test
    public void test() throws ParameterException {
        // 结果是白色选手获胜
        String black = "2H 3D 5S 9C KD";
        String white = "2C 3H 4S 8C AH";
        GameResult result = hands.playGame(black, white);
        // 黑方在前，因此结果为LOSS
        assertEquals(GameResult.LOSS, result);
    }

    @Test
    public void same_rank_compare() throws ParameterException {
        assertEquals(GameResult.LOSS, hands.playGame("2H 3D 5S 9C KD", "2H 3D 5S 9C AD"));
        assertEquals(GameResult.LOSS, hands.playGame("2H 3D 2S 9C 3D", "2H 4D 2S 9C 4D"));
        assertEquals(GameResult.LOSS, hands.playGame("3H 3D 2S 8S 8D", "2H 4D 2S 9C 9D"));
        assertEquals(GameResult.LOSS, hands.playGame("3H 3D 2S 8S 3D", "9H 4D 2S 9C 9D"));

        assertEquals(GameResult.DRAW, hands.playGame("3H AD 2S 5S 4D", "2H AD 5S 4C 3D"));
        assertEquals(GameResult.LOSS, hands.playGame("3H AD 2S 5S 4D", "2H 6D 5S 4C 3D"));
        assertEquals(GameResult.LOSS, hands.playGame("3H 6D 2S 5S 4D", "TH KD JS QC AD"));
        assertEquals(GameResult.WIN, hands.playGame("3H 6D 7S 5S 4D", "2H 4D 3S 5C 6D"));

        assertEquals(GameResult.DRAW, hands.playGame("2D 3D 5D 9D KD", "3H 2H 5H 9H KH"));
    }

    @Test
    public void diff_rank_compare() throws ParameterException {
        assertEquals(GameResult.WIN, hands.playGame("2H 3D 2S 9C 7D", "2C 3H 4S 8C AH"));
    }
}