package com.Akash.jobportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Akash.jobportal.entity.IRecruiterJobs;
import com.Akash.jobportal.entity.JobLocation;
import com.Akash.jobportal.entity.JobPostActivity;
import com.Akash.jobportal.entity.RecruiterJobsDto;
import com.Akash.jobportal.repository.JobPostActivityRepository;

@Service
public class JobPostActivityService {
	
	private final JobPostActivityRepository jobPostActivityRepository;
	
	@Autowired
	public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
		this.jobPostActivityRepository = jobPostActivityRepository;
	}
	
	public JobPostActivity addNew(JobPostActivity jobPostActivity) {
		
		return jobPostActivityRepository.save(jobPostActivity);
	}
	
	public List<RecruiterJobsDto> getRecruiterJobs(int recruiter){
		List<IRecruiterJobs> recruiterJobsDtos = jobPostActivityRepository.getRecruiterJobs(recruiter);
	
	    List<RecruiterJobsDto> recruiterJobsDtoList = new ArrayList<>();
	    
	    for(IRecruiterJobs rec: recruiterJobsDtos) {
	    	JobLocation loc = new JobLocation(rec.getLocationId(),rec.getCity(),
	    			rec.getState(),rec.getCountry());
	    }
	}

}
