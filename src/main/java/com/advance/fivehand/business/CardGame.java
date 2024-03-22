package com.advance.fivehand.business;

import com.advance.fivehand.domain.Card;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

public interface CardGame extends CommandLineRunner {
    List<Card> createDeck();
    void play(int handSize,List<Card> deck);
    void reset();
}
