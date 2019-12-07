package com.zte.poker.bean;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public enum PokerRank {
    STRAIGHT_FLUSH(9, pokers -> isFlush(pokers) && isStraight(pokers)),
    FOUR_OF_A_KIND(8, pokers -> isNumOfPairs(pokers, 4L, 2)),
    FULL_HOUSE(7, pokers -> isNumOfPairs(pokers, 3L, 2)),
    FLUSH(6, PokerRank::isFlush),
    STRAIGHT(5, PokerRank::isStraight),
    THREE_OF_A_KIND(4, pokers -> isNumOfPairs(pokers, 3L, 3)),
    TWO_PAIR(3, pokers -> isNumOfPairs(pokers, 2L, 3)),
    ONE_PAIR(2, pokers -> isNumOfPairs(pokers, 2L, 4)),
    HIGH_CARDk(1, pokers -> true);

    public final Integer priority;
    public final Function<List<Poker>, Boolean> isSatisfy;

    PokerRank(Integer priority, Function<List<Poker>, Boolean> isSatisfy) {
        this.priority = priority;
        this.isSatisfy = isSatisfy;
    }

    public static boolean isFlush(List<Poker> pokers) {
        return pokers.stream().map(Poker::getColor).distinct().count() == 1;
    }

    public static boolean isStraight(List<Poker> pokers) {
        return IntStream.range(0, pokers.size() - 1).allMatch(num -> pokers.get(num).compareTo(pokers.get(num + 1)) == -1);
    }

    public static boolean isNumOfPairs(List<Poker> pokers, Long pairsNum, int pairsSize) {
        Map<PokerNum, Long> pokerNum2SizeMap = pokers.stream().collect(groupingBy(Poker::getNum, counting()));
        return pokerNum2SizeMap.containsValue(pairsNum) && pokerNum2SizeMap.size() == pairsSize;
    }
}