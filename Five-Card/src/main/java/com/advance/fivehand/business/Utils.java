package com.advance.fivehand.business;

import com.advance.fivehand.domain.Card;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Utils {

    public void shuffle(List<Card> deck){
        System.out.println("shuffling... shuffling.... shuffling");
        Collections.shuffle(deck);
    }
    public Set<String> simplifyRank(List<Card> dealt){
        return dealt.stream()
                .map(Card::getRank)
                .collect(Collectors.toSet());
    }
    public Set<Integer> simplifySuits(List<Card> dealt) {
        Set<Integer> weight = new HashSet<>();
        for (Card card: dealt) {
            weight.add(card.getSuit().weight);
        }
        return weight;
    }
    public List<Card> deal(List<Card> deck,int size){
        return deck.subList(0,size);
    }
}
