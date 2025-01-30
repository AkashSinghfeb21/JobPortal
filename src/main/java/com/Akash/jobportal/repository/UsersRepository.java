package com.Akash.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Akash.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
	//Bug Fix:Duplicate Email
	Optional<Users> findByEmail(String email);
}
