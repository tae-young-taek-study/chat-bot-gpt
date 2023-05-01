package com.zecongbi.ig.domain.question.dto;

import java.time.LocalDate;
import java.util.List;

public record ChatGPTResponse(
    String id,
    String object,
    String model,
    LocalDate created,
    Usage usage,
    List<Choice> choices
) {

}
