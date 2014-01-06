package org.selffun;

import org.selffun.configs.ApplicationConfiguration;
import org.selffun.configs.MvcConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;


@Configuration
@ComponentScan(basePackages = "com.spring.my", 
	excludeFilters = { @ComponentScan.Filter( 
			type = FilterType.ASSIGNABLE_TYPE, 
			value = { MvcConfig.class, DefaultWebApplicationInitializer.class } ) 
	} )
@Import(ApplicationConfiguration.class)  
@ActiveProfiles("integration-test") 

public class TestConfig {

}
