package org.selffun.sfa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes=TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class) 
public class TestCase {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Test 
	public void testJdbcTemplate_select() { } 
}
