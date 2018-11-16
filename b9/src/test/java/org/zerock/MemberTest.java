package org.zerock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Member;
import org.zerock.domain.MemberAuth;
import org.zerock.persistence.MemberRepository;

import lombok.Setter;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTest {
	
	@Setter(onMethod_=@Autowired)
	private MemberRepository repo;
	
	@Setter(onMethod_=@Autowired)
	private PasswordEncoder encoder;
	
	@Test
	public void testUpdate() {
		
		repo.findAll().forEach(member-> {
			member.setMpw(encoder.encode("1111"));
			
			repo.save(member);
		});
	}
	@Transactional
	@Test
	public void testInsert() {
		
		IntStream.range(0, 200).forEach(i -> {
			
			Member member = new Member();
			member.setMid("user"+i);
			
			
			member.setMname("사용자" +i);
			member.setMpw("1111");
			
			List<MemberAuth> list = new ArrayList<>();
			
			list.add(new MemberAuth("MEMBER"));
			
			if(i % 3 == 0) {
				list.add(new MemberAuth("BUYER"));
			}
			
			if(i % 10 == 0) {
				list.add(new MemberAuth("ADMIN"));
			}
			
			member.setAuthList(list);
			
			repo.save(member);
			
		});
	
		
	}
}
