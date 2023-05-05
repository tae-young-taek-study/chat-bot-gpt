package com.zecongbi.ig.domain.question.dto;

import com.zecongbi.ig.domain.question.entity.Question;
import com.zecongbi.ig.domain.question.vo.Category;

public record QuestionPickResponse (
    String content,
    Category category
) {
  public static QuestionPickResponse from(Question question) {
    return new QuestionPickResponse(question.getContent(), question.getCategory());
  }
}
