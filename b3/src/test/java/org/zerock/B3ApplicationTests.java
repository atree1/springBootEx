package org.zerock;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Cleanup;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class B3ApplicationTests {

	@Setter(onMethod_=@Autowired)
	private DataSource ds;
	@Test
	public void contextLoads() {
		
	}
	@Test
	@SneakyThrows(Exception.class)
	public void testConnection() {
		
		@Cleanup Connection con =ds.getConnection();
		log.info(""+con);
	}
}
