package com.project.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.myblog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	@Modifying
	@Transactional
	@Query("DELETE FROM Board e WHERE e.id = :id")
	Integer deleteById(@Param("id") int id);
}