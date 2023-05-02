package com.zecongbi.ig.domain.question.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Usage(
    @JsonProperty(value = "prompt_tokens")
    int promptTokens,
    @JsonProperty(value = "completion_tokens")
    int completionTokens,
    @JsonProperty(value = "total_tokens")
    int totalTokens
) {
}
