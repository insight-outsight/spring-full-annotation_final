package org.selffun.sfa;

import org.selffun.sfa.DefaultWebApplicationInitializer;
import org.selffun.sfa.configs.DBConfiguration;
import org.selffun.sfa.configs.MVCConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;


@Configuration
/*@ComponentScan(basePackages = "org.sellfun.sfa", 
	excludeFilters = { @ComponentScan.Filter( 
			type = FilterType.ASSIGNABLE_TYPE, 
			value = { MVCConfiguration.class, DefaultWebApplicationInitializer.class } ) 
	} )*/
@Import(DBConfiguration.class)  
//@ActiveProfiles("integration-test") 

public class TestConfiguration {

}
