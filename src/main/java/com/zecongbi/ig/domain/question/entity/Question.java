package com.zecongbi.ig.domain.question.entity;

import com.zecongbi.ig.domain.common.BaseEntity;
import com.zecongbi.ig.domain.keyword.entity.Keyword;
import com.zecongbi.ig.domain.question.dto.InterviewResponse;
import com.zecongbi.ig.domain.question.vo.Category;
import com.zecongbi.ig.domain.questionKeyword.entity.QuestionKeyword;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String content;

  @Enumerated(value = EnumType.STRING)
  @Column(nullable = false)
  private Category category;

  @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
  private List<QuestionKeyword> keywords = new ArrayList<>();

  protected Question(String content, String categoryName) {
    this.content = content;
    this.category = Category.of(categoryName);
  }

  protected Question() {}

  public static Question of(String content, String categoryName) {
    return new Question(content, categoryName);
  }
}
