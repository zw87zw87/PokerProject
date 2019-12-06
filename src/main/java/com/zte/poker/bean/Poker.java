package com.zte.poker.bean;

import com.zte.poker.exception.ParameterException;
import com.zte.poker.util.PokerUtil;
import lombok.Getter;

@Getter
public class Poker {
    private PokerColor color;
    private PokerNum num;

    public Poker(String value) throws ParameterException {
        PokerUtil.ifTrueThrowException(value.length() != 2, String .format("The length %d of poker value is illegal.", value.length()));
        this.num = PokerNum.getPokerNum(value.charAt(0));
        this.color = PokerColor.getPokerColor(value.charAt(1));
    }
}
