package com.zecongbi.ig.domain.question.repository;

import com.zecongbi.ig.domain.question.entity.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Long> {

  @Query(value = """
      select * from Question order by rand() limit :count
      """, nativeQuery = true
  )
  List<Question> findQuestionsRandomlyCount(@Param("count") int count);
}
