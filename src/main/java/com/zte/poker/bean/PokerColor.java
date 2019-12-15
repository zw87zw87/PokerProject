package com.zte.poker.bean;

import com.zte.poker.exception.ParameterException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum PokerColor {
    SPADE('S', 4),
    HEART('H', 3),
    DIAMOND('D', 2),
    CLUB('C', 1);

    private final Character name;
    private final int priority;

    PokerColor(Character name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    private static final Map<Character, PokerColor> NAME_2_POKER_COLOR = new HashMap<>(4);

    static {
        NAME_2_POKER_COLOR.put(SPADE.name, SPADE);
        NAME_2_POKER_COLOR.put(HEART.name, HEART);
        NAME_2_POKER_COLOR.put(DIAMOND.name, DIAMOND);
        NAME_2_POKER_COLOR.put(CLUB.name, CLUB);
    }

    public static PokerColor getPokerColor(Character name) throws ParameterException {
        return Optional.ofNullable(NAME_2_POKER_COLOR.get(name))
                .orElseThrow(() -> new ParameterException(String.format("The name %c of poker color is illegal.", name)));
    }
}
