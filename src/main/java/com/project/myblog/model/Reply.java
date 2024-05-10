package com.project.myblog.model;

import java.sql.Timestamp;

import org.apache.el.parser.AstFalse;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 200)
	private String content;
	@ManyToOne	//여러답변은 한명의 회원으로 부터
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne	//여러 답변은 하나의 게시물로 부터
	@JoinColumn(name = "boardId")
	private Board board;
	@CreationTimestamp
	private Timestamp createDate;
}
