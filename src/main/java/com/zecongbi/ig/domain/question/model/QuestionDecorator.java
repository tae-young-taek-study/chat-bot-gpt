package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.question.dto.QuestionPickResponse;
import java.util.List;

public interface QuestionDecorator {

  String defaultMessage = "서비스를 이용해주셔서 감사드립니다.\n\n 오늘의 질문입니다.\n\n";

  String decorateQuestion(List<QuestionPickResponse> questions);

  default String getDefaultMessage() {
    return defaultMessage;
  }

}
