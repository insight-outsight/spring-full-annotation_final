package org.selffun.sfa.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {"classpath:/properties/db.properties"}) 
/**
 *@PropertySource("classpath:/com/${my.placeholder:default/path}/app.properties")
 *Any ${...} placeholders present in a @PropertySource resource 
 *location will be resolved against the set of property sources 
 *already registered against the environment.
 *Assuming that "my.placeholder" is present in one of the property 
 *sources already registered, e.g. system properties or environment 
 *variables, the placeholder will be resolved to the corresponding 
 *value. If not, then "default/path" will be used as a default. 
 *Expressing a default value (delimited by colon ":") is optional. 
 *If no default is specified and a property cannot be resolved, 
 *an IllegalArgumentException will be thrown.
**/
public class DBConfiguration {
	
	@Autowired
    private Environment env;
	 
	@Bean
    public DataSource dataSource() {
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource(
						env.getProperty("jdbc.url"),
						env.getProperty("jdbc.username"), 
						env.getProperty("jdbc.password"));
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());		
	}
	
/*    @Bean
    public TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setName(env.getProperty("testbean.name"));
        return testBean;
    }*/
	

	

/*	private @Value("${jdbc.driver}")
	String driver;
	private @Value("${jdbc.url}")
	String url;
	private @Value("${jdbc.username}")
	String username;
	private @Value("${jdbc.password}")
	String password;*/
/*	public @Bean
	DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}*/
	

}
