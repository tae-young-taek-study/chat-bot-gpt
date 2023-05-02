package com.zecongbi.ig.domain.question.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
  DB,
  OperatingSystem,
  Network,
  DataStructure;

  public static List<String> collectCategories() {
    return Arrays.stream(values()).map(Enum::toString).collect(Collectors.toList());
  }
}
