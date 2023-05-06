package com.zecongbi.ig.domain.question.application;

import com.zecongbi.ig.domain.question.dto.InterviewResponse;
import com.zecongbi.ig.domain.question.model.QuestionGenerator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class QuestionLoader {

  private final QuestionGenerator questionGenerator;
  private final QuestionFacadeService questionFacadeService;

  public QuestionLoader(QuestionGenerator questionGenerator,
      QuestionFacadeService questionFacadeService) {
    this.questionGenerator = questionGenerator;
    this.questionFacadeService = questionFacadeService;
  }


  public void load() {
    List<InterviewResponse> interviewResponses = questionGenerator.generate();
    questionFacadeService.saveQuestions(interviewResponses);
  }

}
