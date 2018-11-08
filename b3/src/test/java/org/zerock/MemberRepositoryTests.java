package org.zerock;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberRepository;

import lombok.Setter;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MemberRepositoryTests {

	@Setter(onMethod_=@Autowired)
	private MemberRepository repo;
	
	@Test
	public void testRead() {
		repo.findById("user50").ifPresent(vo->log.info(""+vo));
	}
	@Test
	public void testInsert() {
		IntStream.range(0,100).forEach(i->{
			repo.save(MemberVO.builder().mid("user"+i).mpw("pw"+i).mname("사용자"+i).build());
		});
	}
}
