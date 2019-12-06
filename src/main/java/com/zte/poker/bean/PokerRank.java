package com.zte.poker.bean;

public enum PokerRank {
    STRAIGHT_FLUSH(9),
    FOUR_OF_A_KIND(8),
    FULL_HOUSE(7),
    FLUSH(6),
    STRAIGHT(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    ONE_PAIR(2),
    HIGH_CARDk(1);

    private final Integer priority;

    PokerRank(Integer priority) {
        this.priority = priority;
    }
}