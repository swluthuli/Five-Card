package com.advance.fivehand.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
public final class ValidationParam {
    private final List<Card> dealt;
    private final Set<String> simpleRanks;
    private final Set<Integer> simpleSuits;

}
