package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.question.dto.QuestionPickResponse;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class NewLineQuestionDecorator implements QuestionDecorator{

  @Override
  public String decorateQuestion(List<QuestionPickResponse> questions) {
    StringBuilder sb = new StringBuilder();
    sb.append(getDefaultMessage());

    questions.forEach(question -> {
      sb.append("\u2022");
      sb.append(question.content()).append("\n");
      sb.append("category : ").append(question.category().name()).append("\n\n");
    });
    return sb.toString();
  }
}
