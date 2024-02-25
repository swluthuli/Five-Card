package com.advance.fivehand.domain;

import com.advance.fivehand.domain.enums.Suit;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Card {
    private final Suit suit;
    private String rank;

    public Card(Suit suit, String sign) {
        this.suit = suit;
        this.rank = sign;
    }

    @Override
    public String toString() {
        String replace = rank;
        switch(rank) {
            case "11":
                replace = "J";
                break;
            case "12":
                replace= "K";
                break;
            case "13":
                replace= "Q";
                break;
        }
        return "" + replace + " " + suit.code;
    }
}
