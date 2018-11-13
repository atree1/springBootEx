package org.zerock.persietence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoard;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {

	@Query("select b from FreeBoard b where b.bno>0")
	public List<FreeBoard> list(Pageable pageable);
}
