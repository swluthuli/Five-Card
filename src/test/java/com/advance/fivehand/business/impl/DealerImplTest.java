package com.advance.fivehand.business.impl;

import com.advance.fivehand.TestUtils;
import com.advance.fivehand.business.Dealer;
import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.enums.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.advance.fivehand.domain.enums.Suit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@ActiveProfiles("test")
class DealerImplTest {
    public static final int HAND_SIZE = 5;
    public static final int FULL_DECK_SIZE = 52;
    @Value("${game.ranks}")
    public String[] ranks;
    @Autowired
     private Dealer dealer;

    private final List<Suit> suits = List.of(DIAMONDS, SPADES, HEARTS, CLUBS);
    TestUtils utils = new TestUtils();

    @BeforeEach
    void setUp(){
        dealer.reset();
    }

    @Test
    void doShuffle() {
        List<Card> deck = utils.createDeck(ranks,suits);
        Card card = deck.get(0);
        dealer.doShuffle(deck);
        Card card2 = deck.get(0);
        assertNotEquals(card, card2);
    }
    @Test
    void deal() {
        List<Card> deck = utils.createDeck(ranks,suits);
        int beforeDeal = deck.size();
        List<Card> Hand = dealer.deal(deck, HAND_SIZE);
        int afterDeal = deck.size();
        assertEquals(HAND_SIZE, Hand.size());
        assertNotEquals(beforeDeal,afterDeal);
        assertEquals(FULL_DECK_SIZE,beforeDeal);
        assertEquals(47,afterDeal);
    }

    @Test
    void createDeck() {
        List<Card>deck = dealer.createDeck();
        assertEquals(FULL_DECK_SIZE,deck.size());
    }
}