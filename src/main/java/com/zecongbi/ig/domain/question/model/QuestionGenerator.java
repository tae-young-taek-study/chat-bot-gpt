package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.question.dto.InterviewResponse;
import java.util.List;

public interface QuestionGenerator {

  List<InterviewResponse> generate();

}
