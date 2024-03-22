package com.advance.fivehand.util;

import com.advance.fivehand.domain.Card;
import com.advance.fivehand.domain.enums.Hand;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static com.advance.fivehand.domain.enums.SpecialCards.*;

@Component
public class Utils {

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

    private Map<String, String> mapRank() {
        Map<String, String> rankMap = new HashMap<>();
            rankMap.put(ACE.rank, ACE.value);
            rankMap.put(JACK.rank, JACK.value);
            rankMap.put(QUEEN.rank, QUEEN.value);
            rankMap.put(KING.rank, KING.value);
        return rankMap;
    }
    public List<Card> mapHand(List<Card> dealt){
        for (Card hand: dealt) {
            hand.setRank(mapRank().getOrDefault(hand.getRank(), hand.getRank()));
        }
        return dealt;
    }


}
