package org.zerock.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.MemberVO;

public interface MemberRepository extends CrudRepository<MemberVO, String>{

	
}
