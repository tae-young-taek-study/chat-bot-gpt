package com.zecongbi.ig.domain.common.exception;

public class APIResultFormatException extends BusinessException{

  public APIResultFormatException() {
  }

  public APIResultFormatException(String message) {
    super(message);
  }

  public APIResultFormatException(String message, Throwable cause) {
    super(message, cause);
  }
}
