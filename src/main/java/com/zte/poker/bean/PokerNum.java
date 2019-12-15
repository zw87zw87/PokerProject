package com.zte.poker.bean;

import com.zte.poker.exception.ParameterException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum PokerNum {
    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('T', 10),
    ELEVEN('J', 11),
    TWELVE('Q', 12),
    THIRTEEN('K', 13),
    ONE('A', 14);

    public final Character name;
    public final int num;

    PokerNum(Character name, int num) {
        this.name = name;
        this.num = num;
    }

    private static final Map<Character, PokerNum> NAME_2_POKER_NUM = new HashMap<>(13);

    static {
        NAME_2_POKER_NUM.put(TWO.name, TWO);
        NAME_2_POKER_NUM.put(THREE.name, THREE);
        NAME_2_POKER_NUM.put(FOUR.name, FOUR);
        NAME_2_POKER_NUM.put(FIVE.name, FIVE);
        NAME_2_POKER_NUM.put(SIX.name, SIX);
        NAME_2_POKER_NUM.put(SEVEN.name, SEVEN);
        NAME_2_POKER_NUM.put(EIGHT.name, EIGHT);
        NAME_2_POKER_NUM.put(NINE.name, NINE);
        NAME_2_POKER_NUM.put(TEN.name, TEN);
        NAME_2_POKER_NUM.put(ELEVEN.name, ELEVEN);
        NAME_2_POKER_NUM.put(TWELVE.name, TWELVE);
        NAME_2_POKER_NUM.put(THIRTEEN.name, THIRTEEN);
        NAME_2_POKER_NUM.put(ONE.name, ONE);
    }

    public static PokerNum getPokerNum(Character name) throws ParameterException {
        return Optional.ofNullable(NAME_2_POKER_NUM.get(name))
                .orElseThrow(() -> new ParameterException(String.format("The name %c of poker num is illegal.", name)));
    }
}
