package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeReply;
import org.zerock.persietence.ReplyRepository;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/replies")
@Log
@AllArgsConstructor
public class ReplyController {

	private ReplyRepository repository;
	
	@GetMapping("/{bno}")
	public ResponseEntity<List<FreeReply>> getList(@PathVariable("bno") Long bno){

		log.info("board:"+bno);
		FreeBoard board=new FreeBoard();
		board.setBno(bno);
		List<FreeReply> list=repository.getListByBoard(board);
		
		list.forEach(reply->{
			log.info(""+reply);
		});
		return new ResponseEntity<List<FreeReply>>(list,HttpStatus.OK);
	}
	
}
