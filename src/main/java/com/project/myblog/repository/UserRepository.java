package com.project.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.myblog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}