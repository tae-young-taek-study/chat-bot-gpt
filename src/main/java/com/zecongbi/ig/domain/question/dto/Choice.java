package com.zecongbi.ig.domain.question.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Choice {

  private Message message;
  @JsonProperty(value = "finish_reason")
  private String finishReason;
  private int index;
}
