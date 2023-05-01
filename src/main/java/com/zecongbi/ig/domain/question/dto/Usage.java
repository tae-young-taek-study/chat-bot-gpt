package com.zecongbi.ig.domain.question.dto;

public record Usage(
    int promptUsage,
    int completionTokens,
    int totalTokens
) {
}
