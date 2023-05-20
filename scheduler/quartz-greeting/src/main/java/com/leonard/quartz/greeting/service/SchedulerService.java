package com.leonard.quartz.greeting.service;

import org.quartz.Job;
import org.quartz.SchedulerException;

public interface SchedulerService {
  void scheduleJob(Class<? extends Job> tClass, String jobName, String jobGroup, String cron) throws SchedulerException;
}
