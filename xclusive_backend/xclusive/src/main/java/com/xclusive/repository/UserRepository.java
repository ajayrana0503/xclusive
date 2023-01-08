package com.xclusive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xclusive.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

}
