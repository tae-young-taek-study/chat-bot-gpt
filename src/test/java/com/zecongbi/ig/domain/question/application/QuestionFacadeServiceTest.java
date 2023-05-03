package com.zecongbi.ig.domain.question.application;

import com.zecongbi.ig.domain.keyword.repository.KeywordRepository;
import com.zecongbi.ig.domain.question.dto.InterviewQuestion;
import com.zecongbi.ig.domain.question.dto.InterviewResponse;
import com.zecongbi.ig.domain.question.repository.QuestionRepository;
import com.zecongbi.ig.domain.questionKeyword.repository.QuestionKeywordRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class QuestionFacadeServiceTest {

  @Autowired
  QuestionFacadeService questionFacadeService;
  @Autowired
  KeywordRepository keywordRepository;
  @Autowired
  QuestionRepository questionRepository;
  @Autowired
  QuestionKeywordRepository questionKeywordRepository;

  @Test
  @DisplayName("InterviewResponse 리스트를 입력받아 데이터베이스에 나누어 저장할 수 있다.")
  void saveProperlyFromListOfInterviewResponse() {
    List<InterviewResponse> interviewResponses = getInterviewResponses();
    questionFacadeService.saveQuestions(interviewResponses);

    Assertions.assertThat(questionRepository.findAll()).hasSize(2);
    Assertions.assertThat(keywordRepository.findAll()).hasSize(4);
    Assertions.assertThat(questionKeywordRepository.findAll()).hasSize(5);
  }

  private List<InterviewResponse> getInterviewResponses() {
    return List.of(
        new InterviewResponse("DB",
            List.of(new InterviewQuestion("질문1", List.of("데이터베이스", "인덱스")))),
        new InterviewResponse("Network",
            List.of(new InterviewQuestion("질문2", List.of("네트워크", "TCP", "인덱스"))))
        );
  }

}