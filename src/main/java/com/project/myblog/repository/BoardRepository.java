package com.project.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.myblog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}