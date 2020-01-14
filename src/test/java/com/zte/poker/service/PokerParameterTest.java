package com.zte.poker.service;

import com.zte.poker.bean.GameResult;
import com.zte.poker.exception.ParameterException;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class PokerParameterTest {
    private String black;
    private String white;
    private GameResult result;

    @Parameterized.Parameters(name = "{index}: black={0}, white={1}, expected={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2H 3D 5S 9C KD", "2C 3H 4S 8C AH", GameResult.LOSS},
                {"2C 3H 4S 8C AH", "2H 3D 5S 9C KD", GameResult.WIN},
                {"2H 3D 5S 9C KD", "2H 3D 5S 9C AD", GameResult.LOSS},
                {"2H 3D 2S 9C 3D", "2H 4D 2S 9C 4D", GameResult.LOSS},
                {"3H 3D 2S 8S 8D", "2H 4D 2S 9C 9D", GameResult.LOSS},
                {"3H 3D 2S 8S 3D", "9H 4D 2S 9C 9D", GameResult.LOSS},
                {"2H 3D AS 5S 4D", "AH 4D 5S 3C 2D", GameResult.DRAW},
                {"2H 3D AS 5S 4D", "6H 4D 5S 3C 2D", GameResult.LOSS},
                {"6H 3D 2S 5S 4D", "AH 4D 5S 3C 2D", GameResult.WIN},
                {"3H AD 2S 5S 4D", "2H AD 5S 4C 3D", GameResult.DRAW},
                {"3H AD 2S 5S 4D", "2H 6D 5S 4C 3D", GameResult.LOSS},
                {"3H 6D 2S 5S 4D", "TH KD JS QC AD", GameResult.LOSS},
                {"3H 6D 7S 5S 4D", "2H 4D 3S 5C 6D", GameResult.WIN},
                {"2D 3D 5D 9D KD", "3H 2H 5H 9H KH", GameResult.DRAW}
        });
    }

    @Test
    public void test() throws ParameterException {
        PokerHands hands = new PokerHandsImpl();
        assertEquals(result, hands.playGame(black, white));
    }
}
