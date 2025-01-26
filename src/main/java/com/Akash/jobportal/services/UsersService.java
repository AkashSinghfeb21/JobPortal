package com.Akash.jobportal.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Akash.jobportal.entity.Users;
import com.Akash.jobportal.repository.UsersRepository;

@Service
public class UsersService {

	private final UsersRepository usersRepository;
	
	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		return usersRepository.save(users);
	}
	
}
