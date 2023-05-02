package com.zecongbi.ig.domain.question.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewResponse {

  private String category;
  private List<InterviewQuestion> questions;

}
