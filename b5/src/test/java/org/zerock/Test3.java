package org.zerock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeReply;
import org.zerock.persietence.FreeBoardRepository;
import org.zerock.persietence.ReplyRepository;

import lombok.Setter;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class Test3 {

	@Setter(onMethod_=@Autowired)
	private FreeBoardRepository BoardRepository;
	
	@Setter(onMethod_=@Autowired)
	private ReplyRepository replyRepository;
	
	@Test
	public void testPageList() {
		Pageable pageable=PageRequest.of(0, 10,Sort.DEFAULT_DIRECTION.DESC,"bno");
		Page<Object[]> result=BoardRepository.listPage(pageable);
		
		log.info(""+result);
		result.getContent().forEach(arr->log.info(""+Arrays.toString(arr)));
				
	}
	@Test
	public void testTitlePageList() {
		Pageable pageable=PageRequest.of(0, 10,Sort.DEFAULT_DIRECTION.DESC,"bno");
		Page<Object[]> result=BoardRepository.listByTitlePage("Title", pageable);
		
		log.info(""+result);
		result.getContent().forEach(arr->log.info(""+Arrays.toString(arr)));
				
	}
	@Test
	public void testTitleorContentPageList() {
		Pageable pageable=PageRequest.of(0, 10,Sort.DEFAULT_DIRECTION.DESC,"bno");
		Page<Object[]> result=BoardRepository.listByTitleOrContentPage("300", pageable);
		
		log.info(""+result);
		result.getContent().forEach(arr->log.info(""+Arrays.toString(arr)));
				
	}
	@Test
	public void testList() {
		
		List<FreeBoard> list=BoardRepository.list(PageRequest.of(0, 10,Sort.DEFAULT_DIRECTION.DESC,"bno"));
		list.stream().forEach(vo->{
			log.info(vo.getBno() +":"+vo.getTitle());
		});
	}
	@Test
	public void insertReply() {
		FreeReply reply=new FreeReply();
		reply.setReply("댓글 ~");
		reply.setReplyer("replyer1");
		
		FreeBoard board=new FreeBoard();
		board.setBno(300L);
		
		reply.setBoard(board);
		
		replyRepository.save(reply);
	}
	@Test
	public void insertFreeBoard() {
		
		IntStream.range(1, 301).forEach(i->{
			FreeBoard board=new FreeBoard();
			board.setTitle("Title "+i);
			board.setContent("Content "+i);
			board.setWriter("user"+(i%10));
			
			BoardRepository.save(board);
		});
	}
	
	
	
}
