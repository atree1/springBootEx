package org.zerock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Profile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long fno;
	
	private String fname;
	
	private boolean current;
	
	@ManyToOne  //fk 자동 생성
	private Member member;
	
}
