package com.xclusive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xclusive.entity.Users;

public class UserRepository {

	
	@Repository
	public interface EmployeeRepository extends JpaRepository<Users, Long>{

	}
}
