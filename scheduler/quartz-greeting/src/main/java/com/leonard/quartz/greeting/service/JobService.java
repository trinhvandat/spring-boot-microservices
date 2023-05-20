package com.leonard.quartz.greeting.service;

import com.leonard.quartz.greeting.entity.JobEntity;

import java.util.List;

public interface JobService {
  List<JobEntity> listAll();
}
