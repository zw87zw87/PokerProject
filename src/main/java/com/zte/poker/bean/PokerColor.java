package com.zte.poker.bean;

public enum PokerColor {
    SPADE('S', 4),
    HEART('H', 3),
    DIAMOND('D', 2),
    CLUB('C', 1);

    private final char name;
    private final int priority;

    PokerColor(char name, int priority) {
        this.name = name;
        this.priority = priority;
    }

//    PokerColor getPokerColor(char name) {
//        switch (name) {
//            case 'S':
//                return PokerColor.SPADE;
//        }
//    }
}
