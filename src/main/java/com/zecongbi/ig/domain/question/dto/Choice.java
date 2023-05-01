package com.zecongbi.ig.domain.question.dto;

public record Choice(
    Message message,
    String finishReason,
    int index
) {

}
