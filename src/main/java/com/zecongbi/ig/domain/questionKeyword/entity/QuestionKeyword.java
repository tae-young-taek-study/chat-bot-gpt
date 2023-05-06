package com.zecongbi.ig.domain.questionKeyword.entity;

import com.zecongbi.ig.domain.common.BaseEntity;
import com.zecongbi.ig.domain.keyword.entity.Keyword;
import com.zecongbi.ig.domain.question.entity.Question;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuestionKeyword extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "question_id")
  private Question question;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "keyword_id")
  private Keyword keyword;

  protected QuestionKeyword(Question question, Keyword keyword) {
    this.question = question;
    this.keyword = keyword;
  }

  protected QuestionKeyword() {}

  public static QuestionKeyword of(Question question, Keyword keyword) {
    return new QuestionKeyword(question, keyword);
  }
}
