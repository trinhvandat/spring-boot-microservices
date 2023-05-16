package com.leonard.greeting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/greetings")
@RestController
@Slf4j
public class GreetingController {

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public String sayHello(@RequestParam("name") String name, @RequestHeader("test_header") String testHeader) {
    log.info("Start sayHello with testHeader: [{}]", testHeader);
    return "Hello: " + name;
  }
}
