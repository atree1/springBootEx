package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

@RestController
public class SampleController {

	@GetMapping("/doA")
	public ResponseEntity<SampleVO> doA(){
		return new ResponseEntity<SampleVO>(SampleVO.builder().v1("v1").v2("v2").v3("v3").build(),HttpStatus.OK);
	}
}
