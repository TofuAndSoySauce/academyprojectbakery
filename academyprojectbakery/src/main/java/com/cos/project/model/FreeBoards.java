package com.cos.project.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="FreeBoards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(
		name= "FREEBOARD_SEQ_GENERATOR"
		, sequenceName= "FREEBOARD_SEQ"
		, initialValue= 1
		, allocationSize= 1
		)

@Entity
public class FreeBoards {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FREEBOARD_SEQ_GENERATOR")
	private int num;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob 
	private String content;
	
	@Column
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="username")
	private Users users;
	
	@OneToMany(mappedBy="boards", fetch=FetchType.EAGER)
	private List<Replys> reply;
	
	@Column
	private int recommend;

	@CreationTimestamp
	private Timestamp createDate;
}
