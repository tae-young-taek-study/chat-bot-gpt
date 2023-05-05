package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.question.dto.QuestionPickResponse;
import com.zecongbi.ig.domain.question.entity.Question;
import com.zecongbi.ig.domain.question.repository.QuestionRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class QuestionSQLRandomPickService implements QuestionPickService {

  private final QuestionRepository questionRepository;
  private static final int PICK_COUNT = 3;

  public QuestionSQLRandomPickService(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  public List<QuestionPickResponse> pickQuestions() {
    List<Question> randomQuestions = questionRepository.findQuestionsRandomlyCount(
        PICK_COUNT);
    return randomQuestions.stream().map(QuestionPickResponse::from).toList();
  }
}
