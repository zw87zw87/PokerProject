package com.zte.poker.bean;

import com.zte.poker.exception.ParameterException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerRankTest {

    @Test
    public void current_rank_whether_or_not_straight_flush() throws ParameterException {
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));

        assertTrue(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertTrue(PokerRank.STRAIGHT_FLUSH.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));
    }

    @Test
    public void current_rank_whether_or_not_four_of_a_kind() throws ParameterException {
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertFalse(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));

        assertTrue(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));
        assertTrue(PokerRank.FOUR_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("AH 2D AS AC AD").getPokers()));
    }

    @Test
    public void current_rank_whether_or_not_full_house() throws ParameterException {
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));
        assertFalse(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("AH 2D AS AC AD").getPokers()));

        assertTrue(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertTrue(PokerRank.FULL_HOUSE.isCurrentRank.apply(new PokerPlayer("TH TD 2S TC 2D").getPokers()));
    }

    @Test
    public void current_rank_whether_or_not_flush() throws ParameterException {
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("AH 2D AS AC AD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertFalse(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("TH TD 2S TC 2D").getPokers()));

        assertTrue(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertTrue(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));
        assertTrue(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));
        assertTrue(PokerRank.FLUSH.isCurrentRank.apply(new PokerPlayer("4H 3H 5H AH 2H").getPokers()));
    }

    @Test
    public void current_rank_whether_or_not_straight() throws ParameterException {
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("AH 2D AS AC AD").getPokers()));
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("TH TD 2S TC 2D").getPokers()));
        assertFalse(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));

        assertTrue(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertTrue(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertTrue(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertTrue(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));
        assertTrue(PokerRank.STRAIGHT.isCurrentRank.apply(new PokerPlayer("4H 3H 5H AH 2H").getPokers()));
    }

    @Test
    public void current_rank_whether_or_not_there_of_a_kind() throws ParameterException {
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("AH 2D AS AC AD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("4H 3H 5H AH 2H").getPokers()));
        assertFalse(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("TH TD 2S TC 2D").getPokers()));

        assertTrue(PokerRank.THREE_OF_A_KIND.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));
    }

    @Test
    public void current_rank_whether_or_not_two_pair() throws ParameterException {
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("AH 2D AS AC AD").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("4H 3H 5H AH 2H").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("TH TD 2S TC 2D").getPokers()));
        assertFalse(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));

        assertTrue(PokerRank.TWO_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));
    }

    @Test
    public void current_rank_whether_or_not_one_pair() throws ParameterException {
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("AH 2D AS AC AD").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("4H 3H 5H AH 2H").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("TH TD 2S TC 2D").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));
        assertFalse(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));

        assertTrue(PokerRank.ONE_PAIR.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
    }

    @Test
    public void current_rank_whether_or_not_high_card() throws ParameterException {
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2H 3D 5S 9C KD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 2C KD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("AH 2D AS AC AD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2H 2D 2S KC KD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2H 3H 5H 9H KH").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2H 4D 5S 3C AD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("AH QD TS JC KD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2D 4D 5D 3D AD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("AC QC TC JC KC").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("4H 3H 5H AH 2H").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("TH TD 2S TC 2D").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2H 2D 2S 9C KD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 5C KD").getPokers()));
        assertTrue(PokerRank.HIGH_CARD.isCurrentRank.apply(new PokerPlayer("2H 2D 5S 9C KD").getPokers()));
    }

    @Test
    public void compare_same_rank_of_straight_flush() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.STRAIGHT_FLUSH.compareSameRank.apply(new PokerPlayer("2D 3D 5D 6D 4D").getPokers(),
                new PokerPlayer("2D 3D 5D AD 4D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.STRAIGHT_FLUSH.compareSameRank.apply(new PokerPlayer("KD JD QD AD TD").getPokers(),
                new PokerPlayer("2D 3D 5D AD 4D").getPokers()));
    }

    @Test
    public void compare_same_rank_of_four_of_a_kind() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.FOUR_OF_A_KIND.compareSameRank.apply(new PokerPlayer("3H 3D 3S 3C 2D").getPokers(),
                new PokerPlayer("2H 2D 2S 9C 2D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.FOUR_OF_A_KIND.compareSameRank.apply(new PokerPlayer("AD AD QD AD AD").getPokers(),
                new PokerPlayer("2H 2D 2S 9C 2D").getPokers()));
    }

    @Test
    public void compare_same_rank_of_full_house() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.FULL_HOUSE.compareSameRank.apply(new PokerPlayer("3H 3D AS 3C AD").getPokers(),
                new PokerPlayer("3H 3D 2S 3C 2D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.FULL_HOUSE.compareSameRank.apply(new PokerPlayer("3H 3D AS 3C AD").getPokers(),
                new PokerPlayer("3H 3D KS 3C KD").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.FULL_HOUSE.compareSameRank.apply(new PokerPlayer("4H 4D 2S 4C 2D").getPokers(),
                new PokerPlayer("3H 3D AS 3C AD").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.FULL_HOUSE.compareSameRank.apply(new PokerPlayer("AH AD 2S AC 2D").getPokers(),
                new PokerPlayer("KH 3D KS 3C KD").getPokers()));
    }

    @Test
    public void compare_same_rank_of_flush() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.FLUSH.compareSameRank.apply(new PokerPlayer("3H 6H AH 2H KH").getPokers(),
                new PokerPlayer("3H 6H AH 2H QH").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.FLUSH.compareSameRank.apply(new PokerPlayer("3H 6H KH 2H QH").getPokers(),
                new PokerPlayer("3H 6H JH 2H QH").getPokers()));
    }

    @Test
    public void compare_same_rank_of_straight() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.STRAIGHT.compareSameRank.apply(new PokerPlayer("3H 4C 6S 2H 5D").getPokers(),
                new PokerPlayer("3H 4C AS 2H 5D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.STRAIGHT.compareSameRank.apply(new PokerPlayer("KH JC TS AH QD").getPokers(),
                new PokerPlayer("3H 4C AS 2H 5D").getPokers()));
    }

    @Test
    public void compare_same_rank_of_three_of_a_kind() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.THREE_OF_A_KIND.compareSameRank.apply(new PokerPlayer("3H 4C 3S KH 3D").getPokers(),
                new PokerPlayer("3H 2C 3S 2H QD").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.THREE_OF_A_KIND.compareSameRank.apply(new PokerPlayer("3H 4C 3S AH 3D").getPokers(),
                new PokerPlayer("3H 2C 3S 2H KD").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.THREE_OF_A_KIND.compareSameRank.apply(new PokerPlayer("3H 4C 3S 2H 3D").getPokers(),
                new PokerPlayer("2H 2C 3S 2H KD").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.THREE_OF_A_KIND.compareSameRank.apply(new PokerPlayer("AH 4C AS 2H AD").getPokers(),
                new PokerPlayer("KH 2C TS KH KD").getPokers()));
    }

    @Test
    public void compare_same_rank_of_two_pair() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.TWO_PAIR.compareSameRank.apply(new PokerPlayer("3H 4C 4S KH 3D").getPokers(),
                new PokerPlayer("3H 2C 3S 2H 4D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.TWO_PAIR.compareSameRank.apply(new PokerPlayer("3H AC 3S AH 4D").getPokers(),
                new PokerPlayer("3H KC 3S KH 4D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.TWO_PAIR.compareSameRank.apply(new PokerPlayer("AH AC 3S 2H 3D").getPokers(),
                new PokerPlayer("2H KC 3S 2H KD").getPokers()));
    }

    @Test
    public void compare_same_rank_of_one_pair() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.ONE_PAIR.compareSameRank.apply(new PokerPlayer("3H 4C QS KH 3D").getPokers(),
                new PokerPlayer("3H 2C 3S QH 4D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.ONE_PAIR.compareSameRank.apply(new PokerPlayer("3H AC 5S AH 4D").getPokers(),
                new PokerPlayer("3H KC TS KH 4D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.ONE_PAIR.compareSameRank.apply(new PokerPlayer("2H AC 4S 2H 3D").getPokers(),
                new PokerPlayer("2H KC 3S 2H TD").getPokers()));
    }

    @Test
    public void compare_same_rank_of_high_card() throws ParameterException {
        assertEquals(GameResult.WIN, PokerRank.HIGH_CARD.compareSameRank.apply(new PokerPlayer("2H 4C QS KH 3D").getPokers(),
                new PokerPlayer("3H 2C 5S QH 4D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.HIGH_CARD.compareSameRank.apply(new PokerPlayer("3H AC 5S TH 4D").getPokers(),
                new PokerPlayer("3H KC TS QH 4D").getPokers()));
        assertEquals(GameResult.WIN, PokerRank.HIGH_CARD.compareSameRank.apply(new PokerPlayer("2H AC 4S KH 3D").getPokers(),
                new PokerPlayer("2H KC 3S QH TD").getPokers()));
    }
}