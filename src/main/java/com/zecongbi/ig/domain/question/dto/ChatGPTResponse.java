package com.zecongbi.ig.domain.question.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatGPTResponse {

  private String id;
  private String object;
  private String model;
  private LocalDate created;
  private Usage usage;
  private List<Choice> choices;
}
