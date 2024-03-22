package com.advance.fivehand.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Hand {

    STRAIGHT_FLUSH("Straight Flush"),
    FOUR_KIND("Four of a Kind"),
    FULL_HOUSE("Full House"),
    FLUSH("Flush"),
    STRAIGHT("Straight"),
    THREE_KIND("Three of a Kind"),
    TWO_PAIR("Two Pair"),
    ONE_PAIR("One Pair"),
    HIGH_CARDS("High Cards");

    public final String description;

}
