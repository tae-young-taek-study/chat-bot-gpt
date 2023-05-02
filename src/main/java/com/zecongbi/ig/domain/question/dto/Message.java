package com.zecongbi.ig.domain.question.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Data
@Getter
public class Message {

  private String role;
  private String content;

  public Message() {}

  public Message(String role, List<String> subject) {
    this.role = role;
    this.content = StringUtils.join(subject, ",") + " 관련해서 개발자 면접 질문 3개씩만 만들어서 한글로 번역해줘. 같은 의미의 키워드는 제거해줘. 형식은 JSON 형식으로 다음과 같이 해줘 : [{\"category\" : \"DB\", \"questions\" : [\"question\" : \"질문 내용\", \"keywords\" : [\"키워드1\", \"키워드2\"...]}, ...]";
  }
}
