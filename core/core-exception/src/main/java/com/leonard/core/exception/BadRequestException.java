package com.leonard.core.exception;

public class BadRequestException extends BaseException {
  public BadRequestException() {
    setCode("com.leonard.core.exception.BadRequestException");
    setStatus(404);
  }
}
