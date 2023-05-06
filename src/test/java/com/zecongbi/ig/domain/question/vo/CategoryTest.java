package com.zecongbi.ig.domain.question.vo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class CategoryTest {

  @Test
  @DisplayName("카테고리 명을 리스트로 collect할 수 있다.")
  void collectTest() {
    List<String> categories = Category.collectCategories();

    log.info(categories.toString());
    Assertions.assertThat(categories).hasSize(4);
  }

}