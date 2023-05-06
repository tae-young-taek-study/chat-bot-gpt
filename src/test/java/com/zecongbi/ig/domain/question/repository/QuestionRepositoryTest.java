package com.zecongbi.ig.domain.question.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.zecongbi.ig.domain.question.dto.QuestionPickResponse;
import com.zecongbi.ig.domain.question.entity.Question;
import java.util.List;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Slf4j
class QuestionRepositoryTest {

  @Autowired
  DataSource dataSource;

  @Autowired
  QuestionRepository questionRepository;

  @Test
  @DisplayName("랜덤하게 특정 개수의 질문을 조회할 수 있다.")
  void findRandomQuestionTest() throws Exception {
    Question question1 = Question.of("question1", "DB");
    Question question2 = Question.of("question2", "Network");
    Question question3 = Question.of("question3", "OperatingSystem");

    questionRepository.save(question1);
    questionRepository.save(question2);
    questionRepository.save(question3);

    List<Question> questionsRandomlyCount = questionRepository.findQuestionsRandomlyCount(2);

    Assertions.assertThat(questionsRandomlyCount).hasSize(2);

    questionsRandomlyCount.forEach(question -> log.info(question.getContent()));
  }

}