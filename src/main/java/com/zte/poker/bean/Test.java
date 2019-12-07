package com.zte.poker.bean;

import com.zte.poker.exception.ParameterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ParameterException {
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker("2S"));
        pokers.add(new Poker("2C"));
        pokers.add(new Poker("3H"));
        pokers.add(new Poker("JD"));
        pokers.add(new Poker("KH"));
        Collections.sort(pokers);
        System.out.println(pokers);
        Arrays.stream(PokerRank.values()).forEach(pokerRank -> {
            if (pokerRank.isSatisfy.apply(pokers)) {
//                return pokerRank.
            }
        });
    }

}
