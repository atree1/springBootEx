package org.zerock.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_members")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MemberVO {
	
	@Id
	@Column(length=100)
	private String mid;
	@NotNull
	private String mpw;
	private String mname;
	private String email;
	
	@CreationTimestamp
	private Timestamp regdate;
	@CreationTimestamp
	private Timestamp updatedate;
	
}
