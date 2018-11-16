package org.zerock.persietence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeReply;

public interface ReplyRepository extends CrudRepository<FreeReply, Long>{

	@Query("select r from FreeReply r where r.board =?1 order by r.rno asc")
	public List<FreeReply> getListByBoard(FreeBoard  board);
}
