package org.zerock;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.PDS;
import org.zerock.domain.PDSFile;
import org.zerock.persietence.PDSRepository;

import lombok.Setter;
import lombok.extern.java.Log;


@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class Test2 {
	
	@Setter(onMethod_=@Autowired)
	private PDSRepository pdsRepository;
	
	@Transactional
	@Test
	public void tesOldWay() {
		PDS pds=pdsRepository.findById(1L).get();
		
		List<PDSFile> files= pds.getFiles();
		log.info(""+files);
		
		PDSFile newFile= new PDSFile();
		newFile.setFno(2L);
		newFile.setFname("갱신된 파일");
		int idx=files.indexOf(newFile);
		
		log.info("idx:" +idx);
		if(idx>=0) {
			files.remove(idx);
			files.add(newFile);
		}
		pds.setFiles(files);
		pdsRepository.save(pds);
		
	}
	@Transactional
	@Test
	public void testdelete() {
		pdsRepository.deletePDSFile(3L);
	}
	@Transactional
	@Test
	public void testUpdate() {
		pdsRepository.updatePDSFile(3L, "새 파일~~~~~~~~~~~");
	}
	@Test
	public void testRead() {
		pdsRepository.findById(1L).ifPresent(vo->log.info(""+vo));
	}
	
	@Test
	public void testInsert() {
		
		log.info("-------------------------------");
		log.info("" + pdsRepository);
		log.info("-------------------------------");
		
		
		
		PDS vo=new PDS();
		vo.setTitle("Sample PDS");
		
		vo.setWriter("user00");
		
		List<PDSFile> list=IntStream.range(0, 3).mapToObj(i->{
			PDSFile fileObj=new PDSFile();
			fileObj.setFname("파일이름"+i);
			
			return fileObj;
		}).collect(Collectors.toList());
		vo.setFiles(list);
		log.info(""+vo);
		pdsRepository.save(vo);
	}
}
