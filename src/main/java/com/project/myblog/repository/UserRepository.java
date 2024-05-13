package com.project.myblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.myblog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsernameAndPassword(String username, String password);
}
