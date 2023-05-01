package com.zecongbi.ig.domain.keyword.entity;

import com.zecongbi.ig.domain.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Keyword extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(nullable = false)
  public String keyword;

  protected Keyword(String keyword) {
    this.keyword = keyword;
  }

  protected Keyword() {}
}
