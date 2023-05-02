package com.zecongbi.ig.domain.question.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewQuestion {

  private String question;
  private List<String> keywords;

}
