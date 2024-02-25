package com.advance.fivehand.business;

import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.enums.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.advance.fivehand.domain.enums.Suit.*;

public class CardGenerator {

    public List<Card> deck = new ArrayList<>();

    private final List<Suit> suits = List.of(DIAMONDS, SPADES, HEARTS, CLUBS);

    public List<Card> createDeck() {
        for (Suit suit: suits) {
            deck.addAll(createSuite(suit,14));
        }
    return deck;
    }

    private List<Card> createSuite(Suit suit, int number) {
        List<Card> list = IntStream.range(1, number).mapToObj(i -> Card.builder()
                .suit(suit)
                .rank(String.valueOf(i))
                .build()).collect(Collectors.toList());
        return list;
    }

}
