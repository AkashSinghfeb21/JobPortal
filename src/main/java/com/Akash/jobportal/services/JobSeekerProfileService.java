package com.Akash.jobportal.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Akash.jobportal.entity.JobSeekerProfile;
import com.Akash.jobportal.repository.JobSeekerProfileRepository;

@Service
public class JobSeekerProfileService {

	private final JobSeekerProfileRepository jobSeekerProfileRepository;
	
	
	
	public JobSeekerProfileService(JobSeekerProfileRepository jobSeekerProfileRepository) {
		
		this.jobSeekerProfileRepository = jobSeekerProfileRepository;
	}



	public Optional<JobSeekerProfile> getOne(Integer id){
		return jobSeekerProfileRepository.findById(id);
	}



	public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
		
		return jobSeekerProfileRepository.save(jobSeekerProfile);
	}
	
}
