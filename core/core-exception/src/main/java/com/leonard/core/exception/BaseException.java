package com.leonard.core.exception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class BaseException extends RuntimeException {
  private String message;
  private String code;
  private int status;
  private Map<String, String> params;

  public void addParam(String key, String value) {
    if (Objects.isNull(params)) {
      this.params = new HashMap<>();
    }
    this.params.put(key, value);
  }
}
