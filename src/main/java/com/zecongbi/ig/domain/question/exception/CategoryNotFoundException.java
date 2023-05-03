package com.zecongbi.ig.domain.question.exception;

import com.zecongbi.ig.domain.common.exception.BusinessException;

public class CategoryNotFoundException extends BusinessException {

  public CategoryNotFoundException() {
  }

  public CategoryNotFoundException(String message) {
    super(message);
  }

  public CategoryNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
