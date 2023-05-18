package com.leonard.quartz.greeting.trigger;

import com.leonard.quartz.greeting.job.GreetingJob;
import com.leonard.quartz.greeting.service.SchedulerService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuartzJobTriggerScheduler {

  private final SchedulerService schedulerService;

  @PostConstruct
  public void trigger() throws SchedulerException {
      schedulerService.scheduleJob(
          GreetingJob.class,
          "job-greeting",
          "job-greeting-trigger",
          "0/30 * * * * ?"
      );
  }
}
