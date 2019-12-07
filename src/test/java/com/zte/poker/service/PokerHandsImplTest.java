package com.zte.poker.service;

import com.zte.poker.bean.GameResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandsImplTest {
    private PokerHands hands = new PokerHandsImpl();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        // 结果是白色选手获胜
        String black = "2H 3D 5S 9C KD";
        String white = "2C 3H 4S 8C AH";
        GameResult result = hands.playGame(black, white);
        // 黑方在前，因此结果为LOSS
        assertEquals(GameResult.LOSS, result);
    }
}