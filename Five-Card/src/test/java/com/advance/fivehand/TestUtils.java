package com.advance.fivehand;

import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.enums.Suit;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public List<Card> deal(List<String> ranks,List<Suit> suits){
        int size = ranks.size();
        List<Card> hand = new ArrayList<>();
        for(int i = 0; i < size; i++){
         hand.add(Card.builder()
                   .suit(suits.get(i))
                   .rank(ranks.get(i))
                   .build());
       }
        return hand;
    }
}
