package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.common.feign.FeignTest;
import com.zecongbi.ig.domain.question.dto.InterviewResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@FeignTest
@Slf4j
class OpenAIQuestionGeneratorTest {

  @Autowired
  QuestionGenerator questionGenerator;


  @Test
  void generateQuestionTest() {
    List<InterviewResponse> generate = questionGenerator.generate();

    Assertions.assertThat(generate).isNotNull();
    log.info(generate.toString());
  }

}