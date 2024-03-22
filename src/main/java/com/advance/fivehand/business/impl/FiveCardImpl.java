package com.advance.fivehand.business.impl;

import com.advance.fivehand.business.CardGame;
import com.advance.fivehand.business.Dealer;
import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.ValidationParam;
import com.advance.fivehand.domain.enums.Hand;
import com.advance.fivehand.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.advance.fivehand.validation.engine.RuleEngine.evaluate;

/**
 * @Author: Siyanda Luthuli
 * Implementation of a five card game
 */
@RequiredArgsConstructor
@Component
public class FiveCardImpl implements CardGame {
    private final Dealer dealer;
    @Value("${game.hand.size}")
    private int handSize;

    /**
     * This method is part of Commandline runner extended in the interface
     * This method runs just after the application starts which triggers our Game
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        play(handSize, createDeck());
    }

    /**
     * This method creates a deck of cards.
     *
     * @return List of Card (Deck)
     */
    @Override
    public List<Card> createDeck() {
        return dealer.createDeck();
    }

    /**
     * Given a deck of cards and number of card per player
     * this method deals the cards and validate the dealt hand
     *
     * @param handSize number of card per player
     * @param deck     a full deck of cards
     */
    @Override
    public void play(int handSize, List<Card> deck) {
        Utils utils = new Utils();
        List<Card> hand;
        dealer.doShuffle(deck);

        hand = dealer.deal(deck, handSize);
        System.out.println("Your Hand : " + hand);
        if (!hand.isEmpty()) {
            Hand validate = evaluate(ValidationParam.builder()
                    .dealt(utils.mapHand(hand))
                    .build());
            System.out.println("You have : " + validate.description);
        } else System.out.println("You need a hand to play");

    }
    /**
     * This method resets the game to default,
     * ready to play again.
     */
    @Override
    public void reset() {
        dealer.reset();
    }
}
