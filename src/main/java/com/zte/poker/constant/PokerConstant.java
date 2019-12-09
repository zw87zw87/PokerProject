package com.zte.poker.constant;

import com.google.common.collect.ImmutableList;
import com.zte.poker.bean.PokerNum;

import java.util.List;

public class PokerConstant {
    public static final int POKER_NUMBER = 5;
    public static final List<PokerNum> POKER_NUM_OF_1_2_3_4_5 =
            ImmutableList.of(PokerNum.ONE, PokerNum.TWO, PokerNum.THREE, PokerNum.FOUR, PokerNum.FIVE);
}
