package com.zte.poker.bean;

import com.zte.poker.exception.ParameterException;
import com.zte.poker.util.PokerUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.zte.poker.constant.PokerConstant.POKER_NUMBER;

@Getter
@Setter
public class PokerPlayer {
    private List<Poker> pokers = new ArrayList<>(POKER_NUMBER);

    private PokerRank pokerRank;

    public PokerPlayer(String pokersValue) throws ParameterException {
        initPokers(pokersValue);
    }

    private void initPokers(String pokersValue) throws ParameterException {
        PokerUtil.ifNullThrowException(pokersValue, "The pokers value can not be null.");
        String[] pokersArray = pokersValue.split("\\s+");
        PokerUtil.ifTrueThrowException(pokersArray.length != POKER_NUMBER, String.format("The pokers value %s is illegal.", pokersValue));
        for (String pokerValue : pokersArray) {
            pokers.add(new Poker(pokerValue));
        }
        Collections.sort(pokers);
    }
}
