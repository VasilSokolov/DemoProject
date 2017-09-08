package com.java.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();
}
