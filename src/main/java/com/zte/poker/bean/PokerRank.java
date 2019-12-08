package com.zte.poker.bean;

import com.zte.poker.constant.PokerConstant;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public enum PokerRank {
    STRAIGHT_FLUSH(9, pokers -> isFlush(pokers) && isStraight(pokers), PokerRank::compareStraight),
    FOUR_OF_A_KIND(8, pokers -> isNumOfPairs(pokers, 4L, 2), PokerRank::comparePairs),
    FULL_HOUSE(7, pokers -> isNumOfPairs(pokers, 3L, 2), PokerRank::comparePairs),
    FLUSH(6, PokerRank::isFlush, PokerRank::comparePokerOneByOne),
    STRAIGHT(5, PokerRank::isStraight, PokerRank::compareStraight),
    THREE_OF_A_KIND(4, pokers -> isNumOfPairs(pokers, 3L, 3), PokerRank::comparePairs),
    TWO_PAIR(3, pokers -> isNumOfPairs(pokers, 2L, 3), PokerRank::comparePairs),
    ONE_PAIR(2, pokers -> isNumOfPairs(pokers, 2L, 4), PokerRank::comparePairs),
    HIGH_CARD(1, pokers -> true, PokerRank::comparePokerOneByOne);

    public final Integer priority;
    public final Function<List<Poker>, Boolean> isSatisfy;
    public final BiFunction<List<Poker>, List<Poker>, GameResult> compareSameRank;

    PokerRank(Integer priority, Function<List<Poker>, Boolean> isSatisfy, BiFunction<List<Poker>, List<Poker>, GameResult> compareSameRank) {
        this.priority = priority;
        this.isSatisfy = isSatisfy;
        this.compareSameRank = compareSameRank;
    }

    private static boolean isFlush(List<Poker> pokers) {
        return pokers.stream().map(Poker::getColor).distinct().count() == 1;
    }

    private static boolean isStraight(List<Poker> pokers) {
        return IntStream.range(0, pokers.size() - 1).allMatch(index -> pokers.get(index).compareTo(pokers.get(index + 1)) == -1);
    }

    private static boolean isNumOfPairs(List<Poker> pokers, Long pairsNum, int pairsSize) {
        Map<PokerNum, Long> pokerNum2SizeMap = pokers.stream().collect(groupingBy(Poker::getNum, counting()));
        return pokerNum2SizeMap.containsValue(pairsNum) && pokerNum2SizeMap.size() == pairsSize;
    }

    private static GameResult comparePokerOneByOne(List<Poker> pokers1, List<Poker> pokers2) {
        List<PokerNum> pokerNums1 = getPokerNums(pokers1);
        List<PokerNum> pokerNums2 = getPokerNums(pokers2);

        return compareNumOneByOne(pokerNums1, pokerNums2);
    }

    private static List<PokerNum> getPokerNums(List<Poker> pokers) {
        return pokers.stream().map(Poker::getNum).collect(Collectors.toList());
    }

    private static GameResult compareNumOneByOne(List<PokerNum> pokers1, List<PokerNum> pokers2) {
        for (int index = 0; index < pokers1.size(); index++) {
            int poker1Num = pokers1.get(index).num;
            int poker2Num = pokers2.get(index).num;
            if (poker1Num > poker2Num) {
                return GameResult.WIN;
            } else if (poker1Num < poker2Num) {
                return GameResult.LOSS;
            }
        }
        return GameResult.DRAW;
    }

    private static GameResult comparePairs(List<Poker> pokers1, List<Poker> pokers2) {
        List<PokerNum> sortedPokers1 = getSortedPokerPairs(pokers1);
        List<PokerNum> sortedPokers2 = getSortedPokerPairs(pokers2);

        return compareNumOneByOne(sortedPokers1, sortedPokers2);
    }

    private static List<PokerNum> getSortedPokerPairs(List<Poker> pokers) {
        return pokers.stream()
                .collect(groupingBy(Poker::getNum, counting()))
                .entrySet()
                .stream()
                .sorted(PokerRank::compareEntry)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static int compareEntry(Map.Entry<PokerNum, Long> entry1, Map.Entry<PokerNum, Long> entry2) {
        int compare = entry2.getValue().compareTo(entry1.getValue());
        if (compare == 0) {
            return entry2.getKey().compareTo(entry1.getKey());
        }
        return compare;
    }

    private static GameResult compareStraight(List<Poker> pokers1, List<Poker> pokers2) {
        List<PokerNum> pokerNums1 = getPokerNums(pokers1);
        List<PokerNum> pokerNums2 = getPokerNums(pokers2);

        if (pokers1.containsAll(PokerConstant.POKER_NUM_OF_1_2_3_4_5)) {
            if (pokers2.containsAll(PokerConstant.POKER_NUM_OF_1_2_3_4_5)) {
                return GameResult.DRAW;
            }
            return GameResult.LOSS;
        } else if (pokers2.containsAll(PokerConstant.POKER_NUM_OF_1_2_3_4_5)) {
            return GameResult.WIN;
        }

        return compareNumOneByOne(pokerNums1, pokerNums2);
    }
}