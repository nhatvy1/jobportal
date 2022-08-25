package com.hnv.service;

import com.hnv.pojo.JobPosting;
import java.util.List;
import java.util.Map;

public interface JobPostingService {
    Long countPosting();
    List<JobPosting> getJobPosting(Map<String, String> params,  int page);
    boolean addPosting(JobPosting jobPosting);
}
