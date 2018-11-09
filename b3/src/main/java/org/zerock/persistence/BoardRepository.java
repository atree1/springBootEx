package org.zerock.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.BoardVO;

public interface BoardRepository extends CrudRepository<BoardVO, Long>{
	public Page<BoardVO> findByBnoGreaterThan(Long bno,Pageable pageable);
	
//	public List<BoardVO> findByBnoGreaterThan(Long bno,Pageable pageable);
	public List<BoardVO> findByTitleContainingAndBnoGreaterThan(String keyword,Long bno,Pageable pageable);
	
	

}
