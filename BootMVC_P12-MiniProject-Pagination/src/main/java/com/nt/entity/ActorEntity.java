package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "JPA_ACTOR_TAB2")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@SQLDelete(sql = "UPDATE JPA_ACTOR_TAB2 SET ACTIVE_SW='inactive' WHERE ACTOR_ID=? AND UPDATE_COUNT=?")
@SQLRestriction(value = "ACTIVE_SW <> 'inactive'")
public class ActorEntity {

	@Id
	@Column(name = "actor_id")
	@SequenceGenerator(name = "gen1", sequenceName = "AID_SEQ1", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NonNull
	@Column(length = 30, name = "ACTOR_NAME")
	private String name;

	@NonNull
	@Column(length = 30, name = "ACTOR_ADDRESS")
	private String address;

	@NonNull
	@Column(length = 30, name = "ACTOR_CATEGORY")
	private String category;

	@NonNull
	@Column(name = "ACTOR_FEE")
	private Float fee;

	// Meta Data Properties

	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	@Version
	private Integer updateCount;
	@Column(length = 30)
	private String createdBy;
	@Column(length = 30)
	private String updatedBy;
	@Column(length = 30)
	private String active_SW = "active";

}
