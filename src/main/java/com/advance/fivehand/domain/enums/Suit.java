package com.advance.fivehand.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Suit {
    DIAMONDS(1, '\u2662'),
    SPADES(2, '\u2664'),
    HEARTS(3, '\u2661'),
    CLUBS(4, '\u2667');
    public final int weight;
    public final char code;
}
