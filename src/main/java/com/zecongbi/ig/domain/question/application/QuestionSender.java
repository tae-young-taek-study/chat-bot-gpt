package com.zecongbi.ig.domain.question.application;

import com.zecongbi.ig.domain.question.dto.QuestionPickResponse;
import com.zecongbi.ig.domain.question.model.QuestionDecorator;
import com.zecongbi.ig.domain.question.model.QuestionPickService;
import com.zecongbi.ig.domain.question.model.QuestionSendService;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class QuestionSender {

  private final QuestionSendService questionSendService;
  private final QuestionPickService questionPickService;
  private final QuestionDecorator questionDecorator;


  public QuestionSender(QuestionSendService questionSendService,
      QuestionPickService questionPickService, QuestionDecorator questionDecorator) {
    this.questionSendService = questionSendService;
    this.questionPickService = questionPickService;
    this.questionDecorator = questionDecorator;
  }

  public void send() {
    List<QuestionPickResponse> questionPickResponses = questionPickService.pickQuestions();
    String decoratedQuestion = questionDecorator.decorateQuestion(questionPickResponses);
    questionSendService.sendQuestions(decoratedQuestion);
  }
}
