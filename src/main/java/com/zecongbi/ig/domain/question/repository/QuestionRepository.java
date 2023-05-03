package com.zecongbi.ig.domain.question.repository;

import com.zecongbi.ig.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {


}
