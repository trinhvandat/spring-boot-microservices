package com.leonard.quartz.greeting.service.impl;

import com.leonard.quartz.greeting.entity.JobEntity;
import com.leonard.quartz.greeting.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
  @Override
  public List<JobEntity> listAll() {
    return new ArrayList<>();
  }
}
