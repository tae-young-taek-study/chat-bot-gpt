package com.zecongbi.ig.domain.question.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageResponse {

  private String role;
  private List<InterviewResponse> content;

}
