package com.leonard.greeting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/greetings")
@RestController
public class GreetingController {

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public String sayHello(@RequestParam("name") String name) {
    return "Hello: " + name;
  }
}
