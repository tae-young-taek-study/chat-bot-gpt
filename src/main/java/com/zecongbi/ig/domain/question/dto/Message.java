package com.zecongbi.ig.domain.question.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Data
@Getter
public class Message {

  private String role;
  private String content;

  public Message() {}

  public Message(String role, String subject) {
    this.role = role;
    this.content = subject + " 관련해서 개발자 면접 질문 10개만 만들어줘";
  }

}
