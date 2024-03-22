package com.advance.fivehand;

import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.enums.Suit;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.advance.fivehand.domain.enums.Suit.*;
import static com.advance.fivehand.domain.enums.Suit.SPADES;
@NoArgsConstructor
public class TestDataGenerator {

    public List<Card> flushHand(){
        List<Card> Hand = new ArrayList<>();
        List<String> ranks = List.of("7","8","9","2","6");
        List<Suit> suits = List.of(DIAMONDS,DIAMONDS,DIAMONDS,DIAMONDS,DIAMONDS);
        for (int i = 0; i < ranks.size(); i++) {
            Hand.add(Card.builder().suit(suits.get(i)).rank(ranks.get(i)).build());
        }
        return Hand;
    }
    public List<Card> FourKindHand(){
        List<Card> Hand = new ArrayList<>();
        List<String> ranks = List.of("7","7","7","7","K");
        List<Suit> suits = List.of(DIAMONDS,SPADES,DIAMONDS,HEARTS,DIAMONDS);
        for (int i = 0; i < ranks.size(); i++) {
            Hand.add(Card.builder().suit(suits.get(i)).rank(ranks.get(i)).build());
        }
        return Hand;
    }
    public List<Card> FullhouseHand(){
        List<Card> Hand = new ArrayList<>();
        List<String> ranks = List.of("7","7","6","6","6");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);
        for (int i = 0; i < ranks.size(); i++) {
            Hand.add(Card.builder().suit(suits.get(i)).rank(ranks.get(i)).build());
        }
        return Hand;
    }
    public List<Card> OnePairHand(){
        List<Card> Hand = new ArrayList<>();
        List<String> ranks = List.of("7","7","1","6","4");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,DIAMONDS,DIAMONDS);
        for (int i = 0; i < ranks.size(); i++) {
            Hand.add(Card.builder().suit(suits.get(i)).rank(ranks.get(i)).build());
        }
        return Hand;
    }
    public List<Card> StraightHand(){
        List<Card> Hand = new ArrayList<>();
        List<String> ranks = List.of("1","2","3","4","5");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);
        for (int i = 0; i < ranks.size(); i++) {
            Hand.add(Card.builder().suit(suits.get(i)).rank(ranks.get(i)).build());
        }
        return Hand;
    }
    public List<Card> StraightFlushHand(){
        List<Card> Hand = new ArrayList<>();
        List<String> ranks = List.of("1","2","3","4","5");
        List<Suit> suits = List.of(DIAMONDS,DIAMONDS,DIAMONDS,DIAMONDS,DIAMONDS);
        for (int i = 0; i < ranks.size(); i++) {
            Hand.add(Card.builder().suit(suits.get(i)).rank(ranks.get(i)).build());
        }
        return Hand;
    }
    public List<Card> ThreeKindHand(){
        List<Card> Hand = new ArrayList<>();
        List<String> ranks = List.of("7","7","7","6","K");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);
        for (int i = 0; i < ranks.size(); i++) {
            Hand.add(Card.builder().suit(suits.get(i)).rank(ranks.get(i)).build());
        }
        return Hand;
    }
    public List<Card> TwoPairHand(){
        List<Card> Hand = new ArrayList<>();
        List<String> ranks = List.of("7","7","6","6","10");
        List<Suit> suits = List.of(DIAMONDS,CLUBS,HEARTS,SPADES,DIAMONDS);
        for (int i = 0; i < ranks.size(); i++) {
            Hand.add(Card.builder().suit(suits.get(i)).rank(ranks.get(i)).build());
        }
        return Hand;
    }
}
