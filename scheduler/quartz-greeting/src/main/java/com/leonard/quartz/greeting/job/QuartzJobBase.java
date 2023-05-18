package com.leonard.quartz.greeting.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public abstract class QuartzJobBase implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.info("=== Start execute job [{}]", jobExecutionContext.getJobDetail().getKey());
    executeLogic(jobExecutionContext);
  }

  protected abstract void executeLogic(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}
