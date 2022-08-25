package com.hnv.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hnv.pojo.JobPosting;
import com.hnv.repository.JobPostingRepository;
import com.hnv.service.JobPostingService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Long countPosting() {
        return this.jobPostingRepository.countPosting();
    }

    @Override
    public List<JobPosting> getJobPosting(Map<String, String> params, int page) {
        return this.jobPostingRepository.getJobPosting(params, page);
    }

    @Override
    public boolean addPosting(JobPosting jobPosting) {
        try {
            //upload cloudinary
            
            Map res = this.cloudinary.uploader().upload(jobPosting.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
            jobPosting.setImage(res.get("secure_url").toString());
            
            return this.jobPostingRepository.addPosting(jobPosting);
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }

}
