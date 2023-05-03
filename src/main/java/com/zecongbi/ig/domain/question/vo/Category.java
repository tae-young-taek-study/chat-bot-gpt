package com.zecongbi.ig.domain.question.vo;

import com.zecongbi.ig.domain.question.exception.CategoryNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
  DB,
  OperatingSystem,
  Network,
  DataStructure;

  private static final String CATEGORY_NOT_FOUND = "해당하는 카테고리가 없습니다.";

  public static List<String> collectCategories() {
    return Arrays.stream(values()).map(Enum::toString).collect(Collectors.toList());
  }

  public static Category of(String categoryName) {
    return Arrays.stream(values())
        .filter(category -> category.toString().equals(categoryName))
        .findFirst()
        .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
  }
}
