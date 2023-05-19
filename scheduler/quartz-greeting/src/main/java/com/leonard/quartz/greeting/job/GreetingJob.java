package com.leonard.quartz.greeting.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class GreetingJob extends QuartzJobBase {
  @Override
  protected void executeLogic(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.info("==> Say hello from leonard");
  }
}
