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

    private static final Map<Character, PokerColor> name2PokerColor = new HashMap<>(4);

    static {
        name2PokerColor.put(SPADE.name, SPADE);
        name2PokerColor.put(HEART.name, HEART);
        name2PokerColor.put(DIAMOND.name, DIAMOND);
        name2PokerColor.put(CLUB.name, CLUB);
    }

    public static PokerColor getPokerColor(Character name) throws ParameterException {
        return Optional.ofNullable(name2PokerColor.get(name))
                .orElseThrow(() -> new ParameterException(String.format("The name %c of poker color is illegal.", name)));
    }
}
