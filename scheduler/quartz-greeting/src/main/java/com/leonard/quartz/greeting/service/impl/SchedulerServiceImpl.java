package com.leonard.quartz.greeting.service.impl;

import com.leonard.quartz.greeting.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class SchedulerServiceImpl implements SchedulerService {

  private final Scheduler scheduler;

  @Override
  public void scheduleJob(Class<? extends Job> tClass, String jobName, String jobGroup, String cron) throws SchedulerException {
    log.info("=== start schedule a job [{}] ===", jobName);
    var jobDetail = JobBuilder.newJob(tClass)
        .withIdentity(jobName, jobGroup)
        .build();

    var cronTrigger = TriggerBuilder.newTrigger()
        .withIdentity(jobName, jobGroup)
        .withSchedule(CronScheduleBuilder.cronSchedule(cron))
        .build();

    scheduler.scheduleJob(jobDetail, cronTrigger);
  }
}
