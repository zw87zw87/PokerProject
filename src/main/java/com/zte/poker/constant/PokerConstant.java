package com.zte.poker.constant;

import com.zte.poker.bean.PokerNum;

import java.util.ArrayList;
import java.util.List;

public class PokerConstant {
    public static final int POKER_NUMBER = 5;
    public static final List<PokerNum> POKER_NUM_OF_1_2_3_4_5 = new ArrayList<>(POKER_NUMBER);

    static {
        POKER_NUM_OF_1_2_3_4_5.add(PokerNum.ONE);
        POKER_NUM_OF_1_2_3_4_5.add(PokerNum.TWO);
        POKER_NUM_OF_1_2_3_4_5.add(PokerNum.THREE);
        POKER_NUM_OF_1_2_3_4_5.add(PokerNum.FOUR);
        POKER_NUM_OF_1_2_3_4_5.add(PokerNum.FIVE);
    }
}
