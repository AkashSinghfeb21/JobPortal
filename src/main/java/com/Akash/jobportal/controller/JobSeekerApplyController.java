package com.Akash.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Akash.jobportal.entity.JobPostActivity;
import com.Akash.jobportal.services.JobPostActivityService;
import com.Akash.jobportal.services.UsersService;

@Controller
public class JobSeekerApplyController {
	
	private final JobPostActivityService jobPostActivityService;
	private final UsersService usersService;

	@Autowired
	public JobSeekerApplyController(JobPostActivityService jobPostActivityService,
			UsersService usersService) {
		this.jobPostActivityService = jobPostActivityService;
		this.usersService = usersService;
	}
	
	@GetMapping("job-details-apply/{id}")
	public String display(@PathVariable("id")int id,Model model) {
		JobPostActivity jobDetails = jobPostActivityService.getOne(id);
		
		model.addAttribute("jobDetails",jobDetails);
		model.addAttribute("user",usersService.getCurrentUserProfile());
		return "job-details";
	}
}
