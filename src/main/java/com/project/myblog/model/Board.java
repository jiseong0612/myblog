package com.project.myblog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 100)
	private String title;
//	@Lob
	@Column(columnDefinition = "TEXT")
	private String content;

	private int count;
	@ManyToOne // Board : User == N:1
	@JoinColumn(name = "userId")
	private User user; // DB는 오브젝트 저장 불가, 자바는 가능 JPA는 오브젝트로 저장
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // EAGER 있으면 무조건 땡겨와!
	private List<Reply> reply;
	@CreationTimestamp
	private Timestamp createDate;
}
