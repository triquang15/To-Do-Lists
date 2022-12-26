package com.devteam.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProjectTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false)
	private String projectSequence;
	
	@NotBlank(message = "Please include a project summary")
	private String summary;
	
	private String acceptanceCriteria;
	private String status;
	private Integer priority;
	private Date dueDate;
	
	@Column(updatable = false)
	private String projectIdentifier;
	
	private Date create_At;
	private Date update_At;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "backlog_id", updatable = false, nullable = false)
	@JsonIgnore
	private Backlog backlog;
	
	@PrePersist
	protected void onCreate() {
		this.create_At = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.update_At = new Date();
	}
}
