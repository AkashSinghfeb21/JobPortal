package com.Akash.jobportal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Akash.jobportal.entity.RecruiterProfile;
import com.Akash.jobportal.repository.RecruiterProfileRepository;

@Service
public class RecruiterProfileService {
	
	private final RecruiterProfileRepository recruiterRepository;

	@Autowired
	public RecruiterProfileService(RecruiterProfileRepository recruiterProfileRepository) {
		this.recruiterRepository = recruiterProfileRepository;
	}
	
	public Optional<RecruiterProfile> getOne(Integer id){
		return recruiterRepository.findById(id);
	}

	public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
		
		return recruiterRepository.save(recruiterProfile);
	}
}
