package com.advance.fivehand.business;

import com.advance.fivehand.domain.Card;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface Dealer {
    List<Card> createDeck();
    void doShuffle(List<Card> deck);
    List<Card> deal(List<Card> deck,int size);
    void reset();

}
