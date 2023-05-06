package com.zecongbi.ig.domain.question.dto;

import com.zecongbi.ig.domain.question.entity.Question;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewResponse {

  private String category;
  private List<InterviewQuestion> questions;

  public InterviewResponse(String category, List<InterviewQuestion> questions) {
    this.category = category;
    this.questions = questions;
  }
}
