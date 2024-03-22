package com.advance.fivehand.business.impl;

import com.advance.fivehand.TestDataGenerator;
import com.advance.fivehand.business.CardGame;
import com.advance.fivehand.business.Dealer;
import com.advance.fivehand.domain.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class FiveCardImplTest {

    @Autowired
    private CardGame cardGame;
    @MockBean
    private Dealer dealer;

    TestDataGenerator dataGenerator = new TestDataGenerator();

    @Test
    void createDeck() {
        List<Card> deck = cardGame.createDeck();
        when(dealer.createDeck()).thenReturn(new ArrayList<>());
        verify(dealer, times(1)).createDeck();
    }

    @Test
    void playFullHouseHand() {
        List<Card> deck = dataGenerator.FullhouseHand();
        when(dealer.deal(anyList(), anyInt())).thenReturn(deck);
        doNothing().when(dealer).doShuffle(anyList());
        cardGame.play(5, deck);
        verify(dealer,atLeastOnce()).doShuffle(anyList());
        verify(dealer,atLeastOnce()).deal(anyList(), anyInt());
    }

    @Test
    void playFlushHand() {
        List<Card> deck = dataGenerator.flushHand();
        when(dealer.deal(anyList(), anyInt())).thenReturn(deck);
        doNothing().when(dealer).doShuffle(anyList());
        cardGame.play(5, deck);
        verify(dealer, atLeastOnce()).doShuffle(anyList());
        verify(dealer, atLeastOnce()).deal(anyList(), anyInt());
    }

    @Test
    void playFourKindHand() {
        List<Card> deck = dataGenerator.FourKindHand();
        when(dealer.deal(anyList(), anyInt())).thenReturn(deck);
        doNothing().when(dealer).doShuffle(anyList());
        cardGame.play(5, deck);
        verify(dealer, atLeastOnce()).doShuffle(anyList());
        verify(dealer, atLeastOnce()).deal(anyList(), anyInt());
    }

    @Test
    void playOnePairHand() {
        List<Card> deck = dataGenerator.OnePairHand();
        when(dealer.deal(anyList(), anyInt())).thenReturn(deck);
        doNothing().when(dealer).doShuffle(anyList());
        cardGame.play(5, deck);
        verify(dealer, atLeastOnce()).doShuffle(anyList());
        verify(dealer, atLeastOnce()).deal(anyList(), anyInt());
    }

    @Test
    void playStraightHand() {
        List<Card> deck = dataGenerator.StraightHand();
        when(dealer.deal(anyList(), anyInt())).thenReturn(deck);
        doNothing().when(dealer).doShuffle(anyList());
        cardGame.play(5, deck);
        verify(dealer, atLeastOnce()).doShuffle(anyList());
        verify(dealer, atLeastOnce()).deal(anyList(), anyInt());
    }
    @Test
    void playStraightFlushHand() {
        List<Card> deck = dataGenerator.StraightFlushHand();
        when(dealer.deal(anyList(), anyInt())).thenReturn(deck);
        doNothing().when(dealer).doShuffle(anyList());
        cardGame.play(5, deck);
        verify(dealer, atLeastOnce()).doShuffle(anyList());
        verify(dealer, atLeastOnce()).deal(anyList(), anyInt());
    }

    @Test
    void playThreeKindHand() {
        List<Card> deck = dataGenerator.ThreeKindHand();
        when(dealer.deal(anyList(), anyInt())).thenReturn(deck);
        doNothing().when(dealer).doShuffle(anyList());
        cardGame.play(5, deck);
        verify(dealer, atLeastOnce()).doShuffle(anyList());
        verify(dealer, atLeastOnce()).deal(anyList(), anyInt());
    }
    @Test
    void playTwoPairHand() {
        List<Card> deck = dataGenerator.TwoPairHand();
        when(dealer.deal(anyList(), anyInt())).thenReturn(deck);
        doNothing().when(dealer).doShuffle(anyList());
        cardGame.play(5, deck);
        verify(dealer, atLeastOnce()).doShuffle(anyList());
        verify(dealer, atLeastOnce()).deal(anyList(), anyInt());
    }

    @Test
    void reset() {
        dealer.reset();
        verify(dealer, times(1)).reset();
    }
}