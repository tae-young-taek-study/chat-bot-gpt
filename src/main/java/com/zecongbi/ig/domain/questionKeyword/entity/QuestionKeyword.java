package com.zecongbi.ig.domain.questionKeyword.entity;

import com.zecongbi.ig.domain.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionKeyword extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(nullable = false)
  public Long questionId;

  @Column(nullable = false)
  public Long keywordId;

  protected QuestionKeyword(Long questionId, Long keywordId) {
    this.questionId = questionId;
    this.keywordId = keywordId;
  }

  protected QuestionKeyword() {}
}
