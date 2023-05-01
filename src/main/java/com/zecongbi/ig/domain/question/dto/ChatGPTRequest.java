package com.zecongbi.ig.domain.question.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class ChatGPTRequest {
  private String model;

  private List<Message> messages;

  public ChatGPTRequest(String model, List<Message> messages) {
    this.model = model;
    this.messages = messages;
  }
}
