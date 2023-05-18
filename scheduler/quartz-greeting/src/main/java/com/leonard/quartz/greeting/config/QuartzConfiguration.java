package com.leonard.quartz.greeting.config;

import com.leonard.quartz.greeting.factory.QuartzJobFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@EnableScheduling
public class QuartzConfiguration {

  @Bean
  public SchedulerFactoryBean quartzScheduler(QuartzJobFactory jobFactory) {
    SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
    schedulerFactory.setJobFactory(jobFactory);
    return schedulerFactory;
  }

  @Bean
  public Scheduler scheduler(@Qualifier("quartzScheduler") SchedulerFactoryBean quartzScheduler) throws SchedulerException {
    Scheduler scheduler = quartzScheduler.getScheduler();
    return scheduler;
  }

}
