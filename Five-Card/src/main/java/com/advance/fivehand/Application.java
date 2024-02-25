package com.advance.fivehand;

import com.advance.fivehand.business.CardGenerator;
import com.advance.fivehand.business.Utils;
import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.ValidationParam;
import com.advance.fivehand.domain.enums.Hand;
import com.advance.fivehand.validation.engine.RuleEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.advance.fivehand.validation.engine.RuleEngine.*;

@SpringBootApplication
public class Application implements CommandLineRunner {




	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Utils util = new Utils();
		CardGenerator generator = new CardGenerator();
		List<Card> deck = generator.createDeck();
		util.shuffle(deck);

		List<Card> hand = util.deal(deck,5);

		System.out.println("Your Hand : " + hand);
		Hand validate = isStraightFlushHand()
				.and(isFlushHand())
				.and(isStraightHand())
				.and(isFullHouseHand())
				.and(isFourKindHand())
				.and(isThreeKindHand())
				.and(isTwoPairHand())
				.and(isOnePairHand())
				.apply(ValidationParam.builder().dealt(hand).build());

		System.out.println("You have : " + validate.description);
	}
}
