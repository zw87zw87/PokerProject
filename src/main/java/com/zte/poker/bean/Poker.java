package com.zte.poker.bean;

import com.zte.poker.exception.ParameterException;
import com.zte.poker.util.PokerUtil;

public class Poker {
    private PokerColor color;
    private PokerNum num;

    public Poker(PokerColor color, PokerNum num) {
        this.color = color;
        this.num = num;
    }

    public void init(String value) throws ParameterException {
        PokerUtil.ifTrueThrowException(value.length() != 2, String .format("The length %d of poker value is illegal.", value.length()));

    }
}
