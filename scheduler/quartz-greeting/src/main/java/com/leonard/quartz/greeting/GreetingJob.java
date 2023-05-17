package com.leonard.quartz.greeting;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class GreetingJob implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.warn("Greeting job say hello leonard");
  }
}
