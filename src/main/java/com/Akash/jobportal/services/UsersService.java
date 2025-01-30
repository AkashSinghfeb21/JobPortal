package com.Akash.jobportal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Akash.jobportal.entity.JobSeekerProfile;
import com.Akash.jobportal.entity.RecruiterProfile;
import com.Akash.jobportal.entity.Users;
import com.Akash.jobportal.repository.JobSeekerProfileRepository;
import com.Akash.jobportal.repository.RecruiterProfileRepository;
import com.Akash.jobportal.repository.UsersRepository;

@Service
public class UsersService {

	private final UsersRepository usersRepository;
	private final JobSeekerProfileRepository jobSeekerProfileRepository;
	private final RecruiterProfileRepository recruiterProfileRepository;
	
	@Autowired
	public UsersService(UsersRepository usersRepository,JobSeekerProfileRepository
			jobSeekerProfileRepository,RecruiterProfileRepository recruiterProfileRepository) {
		this.usersRepository = usersRepository;
		this.jobSeekerProfileRepository = jobSeekerProfileRepository;
		this.recruiterProfileRepository = recruiterProfileRepository;
	}
	
	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		Users savedUser = usersRepository.save(users);
		int userTypeId = users.getUserTypeId().getUserTypeId();
		if(userTypeId == 1) {
			recruiterProfileRepository.save(new RecruiterProfile(savedUser));
		}else {
			jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
		}
		return savedUser;
	}
	
	//Bug Fix:Duplicate Email
	public Optional<Users> getUserByEmail(String email){
		return usersRepository.findByEmail(email);
	}
	
}
