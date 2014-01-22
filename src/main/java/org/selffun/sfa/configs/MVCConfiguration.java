package org.selffun.sfa.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @EnableWebMvc annotation used together with @Configuration enables default
 * Spring MVC configuration, equivalent to <mvc:annotation-driven/> . 
 * With @ComponentScan annotation we make sure our @Controller will be added to 
 * the application context. The configuration class also defines one @Bean: our 
 * default view resolver.
 * 
 * */

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "org.selffun.sfa.web.controllers")
// @ImportResource({ classpath:applicationContext.xml","classpath:/spring/security.xml" })
public class MVCConfiguration {
	
	@Bean
	public InternalResourceViewResolver configureInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	
}
