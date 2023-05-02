package com.zecongbi.ig.domain.question.dto;

import java.util.List;
import lombok.Data;

@Data
public class ChatGPTRequest {
  private String model;

  private List<Message> messages;

  public ChatGPTRequest(String model, List<Message> messages) {
    this.model = model;
    this.messages = messages;
  }
}
