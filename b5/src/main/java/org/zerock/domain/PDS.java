package org.zerock.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude="files")
@EqualsAndHashCode
public class PDS {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pno;
	private String title;
	private String writer;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //eager 로딩시 하위 테이블도 다 로딩하므로 성능에 저하가 크다
	@JoinColumn(name="pdsno")
	private List<PDSFile> files;
	
}
