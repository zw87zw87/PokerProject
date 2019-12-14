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

    private static final Map<Character, PokerNum> name2PokerNum = new HashMap<>(13);

    static {
        name2PokerNum.put(TWO.name, TWO);
        name2PokerNum.put(THREE.name, THREE);
        name2PokerNum.put(FOUR.name, FOUR);
        name2PokerNum.put(FIVE.name, FIVE);
        name2PokerNum.put(SIX.name, SIX);
        name2PokerNum.put(SEVEN.name, SEVEN);
        name2PokerNum.put(EIGHT.name, EIGHT);
        name2PokerNum.put(NINE.name, NINE);
        name2PokerNum.put(TEN.name, TEN);
        name2PokerNum.put(ELEVEN.name, ELEVEN);
        name2PokerNum.put(TWELVE.name, TWELVE);
        name2PokerNum.put(THIRTEEN.name, THIRTEEN);
        name2PokerNum.put(ONE.name, ONE);
    }

    public static PokerNum getPokerNum(Character name) throws ParameterException {
        return Optional.ofNullable(name2PokerNum.get(name))
                .orElseThrow(() -> new ParameterException(String.format("The name %c of poker num is illegal.", name)));
    }
}
