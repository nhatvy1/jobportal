package com.hnv.controller;

import com.hnv.pojo.JobPosting;
import com.hnv.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ControllerAdvice
public class JobPostingController {
    @Autowired
    private JobPostingService jobPostingService;
    
    @GetMapping("/jobposting")
    public String jobPostingView(Model model) {
        model.addAttribute("posting", new JobPosting());
        return "jobposting";
    }
    
    @PostMapping("/jobposting")
    public String addPost(Model model, @ModelAttribute(value = "posting") JobPosting jobPosting) {
        if (this.jobPostingService.addPosting(jobPosting) == true) {
            return "redirect:/jobs";
        } else {
            model.addAttribute("errMsg", "Something wrong");
        }
        
        return "jobs";
    }
}
