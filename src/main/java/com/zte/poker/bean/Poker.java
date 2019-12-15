package com.zte.poker.bean;

import com.zte.poker.exception.ParameterException;
import com.zte.poker.util.PokerUtil;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Poker implements Comparable<Poker>{
    private final PokerColor color;
    private final PokerNum num;

    Poker(String value) throws ParameterException {
        PokerUtil.ifTrueThrowException(value.length() != 2, String .format("The length %d of poker value is illegal.", value.length()));
        this.num = PokerNum.getPokerNum(value.charAt(0));
        this.color = PokerColor.getPokerColor(value.charAt(1));
    }

    @Override
    public int compareTo(Poker o) {
        return o.getNum().compareTo(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Poker poker = (Poker) o;
        return num == poker.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
