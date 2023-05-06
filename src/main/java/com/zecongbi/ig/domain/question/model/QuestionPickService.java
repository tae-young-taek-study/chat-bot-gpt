package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.question.dto.QuestionPickResponse;
import java.util.List;

public interface QuestionPickService {

  List<QuestionPickResponse> pickQuestions();
}
