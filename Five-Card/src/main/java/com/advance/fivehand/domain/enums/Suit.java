package com.advance.fivehand.domain.enums;

public enum Suit {
    DIAMONDS(1, '\u2662'),
    SPADES(2, '\u2664'),
    HEARTS(3, '\u2661'),
    CLUBS(4, '\u2667');
    public final int weight;
    public final char code;

    Suit(int weight, char code) {
        this.weight = weight;
        this.code = code;
    }
}
