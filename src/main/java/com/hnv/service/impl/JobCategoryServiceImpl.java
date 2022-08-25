package com.hnv.service.impl;

import com.hnv.pojo.JobCategory;
import com.hnv.repository.JobCategoryRepository;
import com.hnv.service.JobCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobCategoryServiceImpl implements JobCategoryService{
    @Autowired
    private JobCategoryRepository categoryRepository;
    
    @Override
    public List<JobCategory> getJobCategories() {
        return this.categoryRepository.getJobCategories();
    }
    
}
