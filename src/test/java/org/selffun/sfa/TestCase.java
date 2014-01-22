package org.selffun.sfa;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.selffun.sfa.models.TreeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes=TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class) 
public class TestCase {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test 
	public void testJdbcTemplate_select() { 
		TreeInfo ti = jdbcTemplate.queryForObject(
				"select id,node_id,parent_id,position,title,type from tree_info where id=?",
				new ParameterizedRowMapper<TreeInfo>(){
					public TreeInfo mapRow(ResultSet rs,int rowNum) throws SQLException{
						TreeInfo TreeInfo=new TreeInfo();
						TreeInfo.setId(rs.getLong(1));
						TreeInfo.setNodeId(rs.getInt(2));
						TreeInfo.setParentId(rs.getInt(3));
						TreeInfo.setPosition(rs.getInt(4));
						TreeInfo.setTitle(rs.getString(5));
						TreeInfo.setType(rs.getInt(6));
						return TreeInfo;
					}
				},
				61
				);
		System.out.println(ti.getId()+","+ti.getTitle());
	}
	
}
