package com.advance.fivehand.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SpecialCards {

    ACE("1","A"),
    JACK("11","J"),
    QUEEN("12","Q"),
    KING("13","K");
   public final String value;
   public final String rank;
}
