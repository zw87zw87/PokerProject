package com.zte.poker.bean;

public enum PokerNum {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    ELEVEN("J", 11),
    TWELVE("Q", 12),
    THIRTEEN("K", 13),
    ONE("A", 14);

    private final String name;
    private final int num;

    PokerNum(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
