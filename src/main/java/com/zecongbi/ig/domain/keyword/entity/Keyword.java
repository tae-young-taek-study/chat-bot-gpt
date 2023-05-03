package com.zecongbi.ig.domain.keyword.entity;

import com.zecongbi.ig.domain.common.BaseEntity;
import com.zecongbi.ig.domain.questionKeyword.entity.QuestionKeyword;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Keyword extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String keyword;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "keyword")
  private List<QuestionKeyword> questions = new ArrayList<>();

  protected Keyword(String keyword) {
    this.keyword = keyword;
  }

  protected Keyword() {}

  public static Keyword toEntity(String keyword) {
    return new Keyword(keyword);
  }
}
