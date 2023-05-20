package com.leonard.quartz.greeting.trigger;

import com.leonard.quartz.greeting.service.JobService;
import com.leonard.quartz.greeting.service.SchedulerService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuartzJobTriggerScheduler {

  private final SchedulerService schedulerService;
  private final JobService jobService;

  @PostConstruct
  public void trigger() throws SchedulerException, ClassNotFoundException {
    var jobs = jobService.listAll();
    for (var job : jobs) {
      schedulerService.scheduleJob(
          (Class<? extends Job>) Class.forName(job.getClassName()),
          job.getJobName(),
          job.getTriggerName(),
          job.getCronExpression()
      );
    }
  }
}
