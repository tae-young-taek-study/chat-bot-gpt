package com.zecongbi.ig.domain.question.entity;

import com.zecongbi.ig.domain.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(nullable = false)
  public String content;

  protected Question(String content) {
    this.content = content;
  }

  protected Question() {}
}
