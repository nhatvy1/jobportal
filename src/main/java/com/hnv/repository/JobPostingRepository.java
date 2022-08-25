package com.hnv.repository;

import com.hnv.pojo.JobPosting;
import java.util.List;
import java.util.Map;

public interface JobPostingRepository {
    Long countPosting();
    List<JobPosting> getJobPosting(Map<String, String> params,  int page);
    boolean addPosting(JobPosting jobPosting);
}
