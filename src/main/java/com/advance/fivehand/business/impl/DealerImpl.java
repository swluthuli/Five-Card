package com.advance.fivehand.business.impl;

import com.advance.fivehand.business.Dealer;
import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.enums.Suit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.advance.fivehand.domain.enums.Suit.*;

/**
 * @Author : Siyanda Luthuli
 * Implementation of a dealer
 * someone appointed at a gambling table to assist in the conduct of the game
 */
@Component
public class DealerImpl implements Dealer {
    public List<Card> deck = new ArrayList<>();
    @Value("${game.ranks}")
    public String[] ranks;

    private final List<Suit> suits = List.of(DIAMONDS, SPADES, HEARTS, CLUBS);

    /**
     * This method create a deck of cards using ranks given on the properties.
     * @return full deck of card
     */
    @Override
    public List<Card> createDeck() {
        for (Suit suit: suits) {
            deck.addAll(createCard(suit,ranks));
        }
        return deck;
    }

    /**
     * create a set of cards with a single suit
     * @param suit type of card
     * @param ranks a number or sign on the card
     * @return List of cards
     */
    private List<Card> createCard(Suit suit, String[] ranks) {
        List<Card> list = Arrays.stream(ranks).map(i -> Card.builder()
                .suit(suit)
                .rank(String.valueOf(i))
                .build()).collect(Collectors.toList());
        return list;
    }

    /**
     * This method facilitates the shuffling of the deck
     * randomly changing elements positions within the list
     * @param deck List of cards
     */
    @Override
    public void doShuffle(List<Card> deck) {
        System.out.println("shuffling... shuffling.... shuffling");
        Collections.shuffle(deck);
    }

    /**
     * This method is responsible for "dealing" a hand
     * taking a number of cards(hand size) away from the deck
     * @param deck full shuffled deck
     * @param size number of cards per player
     * @return List of cards (hand)
     */
    @Override
    public List<Card> deal(List<Card> deck, int size) {
        List<Card> hand = new ArrayList<>(size);
        hand.addAll(deck.subList(0, size));
        deck.subList(0, size).clear();
        return hand;
    }

    /**
     * This method resets the game to default,
     * clears the deck.
     */
    @Override
    public void reset() {
        this.deck.clear();
    }

}
