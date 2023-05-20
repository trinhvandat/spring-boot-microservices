package com.leonard.quartz.greeting.entity;

import lombok.Data;

@Data
public class JobEntity {
  private Integer id;
  private String jobName;
  private String className;
  private String cronExpression;
  private String triggerName;
  private String triggerGroup;
}
