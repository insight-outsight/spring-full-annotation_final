package org.selffun.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration 
@ImportResource( { "classpath:/spring/security.xml" } ) 
@PropertySource(value = { "classpath:some.properties"}) 
public class ApplicationConfiguration {

	 @Autowired 
	 private Environment environment; 
	 /*
	 ... Various beans for your application that aren't web 
	 specific and should be made available to tests as well... 
	 */
/*	 public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		 UserCredentials userCredentials = new UserCredentials(environment.getProperty("mongodb.username"), environment.getProperty("mongodb.password")); 
		 return new SimpleMongoDbFactory(mongo().getObject(), environment.getProperty("mongodb.database"), userCredentials); 
	 } */
}
