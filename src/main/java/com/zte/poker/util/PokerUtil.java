package com.zte.poker.util;

import com.zte.poker.exception.ParameterException;

public class PokerUtil {

    public static void ifTrueThrowException(boolean expression, String errorMessage) throws ParameterException {
        if (expression) {
            throw new ParameterException(errorMessage);
        }
    }

    public static <T> void ifNullThrowException(T t, String errorMessage) throws ParameterException {
        if (t == null) {
            throw new ParameterException(errorMessage);
        }
    }
}
