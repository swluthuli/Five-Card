package com.advance.fivehand.domain;

import com.advance.fivehand.domain.enums.Suit;
import com.advance.fivehand.util.Utils;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Card {
    private final Suit suit;
    private String rank;
    final Utils util = new Utils();

    Card(Suit suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }
    @Override
    public String toString() {
        return rank + " " + suit.code;
    }
}
