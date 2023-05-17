package com.leonard.quartz.greeting;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
@EnableScheduling
public class QuartzConfiguration {

  @Bean
  public JobDetailFactoryBean jobDetail() {
    JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
    factoryBean.setJobClass(GreetingJob.class);
    factoryBean.setDurability(true);
    return factoryBean;
  }

  @Bean
  public SimpleTriggerFactoryBean trigger(JobDetail job) {
    SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
    factoryBean.setJobDetail(job);
    factoryBean.setRepeatInterval(30000); // 30 seconds
    factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
    return factoryBean;
  }
}
