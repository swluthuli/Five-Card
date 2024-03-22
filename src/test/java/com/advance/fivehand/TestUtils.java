package com.advance.fivehand;

import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.enums.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Card> createDeck(String[] ranks, List<Suit> suits){
        List<Card> deck = new ArrayList<>();
        for (Suit suit :  suits) {
            deck.addAll(Arrays.stream(ranks)
                    .map(rank -> Card.builder()
                            .suit(suit)
                            .rank(rank)
                            .build())
                    .collect(Collectors.toList()));
        }
        return deck;
    }
}
