package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.question.dto.QuestionPickResponse;
import com.zecongbi.ig.domain.question.entity.Question;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Slf4j
class NewLineQuestionDecoratorTest {

  NewLineQuestionDecorator questionDecorator = new NewLineQuestionDecorator();

  @Test
  @DisplayName("질문을 원하는 컨셉에 따라 꾸밀 수 있다.")
  void decorateQuestion() {
    List<QuestionPickResponse> questions = List.of(
        QuestionPickResponse.from(Question.of("question1", "DB")),
        QuestionPickResponse.from(Question.of("question2", "Network")),
        QuestionPickResponse.from(Question.of("question3", "OperatingSystem"))
    );

    String decorated = questionDecorator.decorateQuestion(questions);

    log.info(decorated);
  }

}