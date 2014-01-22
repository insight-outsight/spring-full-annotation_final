package org.selffun.sfa.configs;

import java.lang.reflect.Method;
import java.util.List;

import org.selffun.sfa.DefaultWebApplicationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.selffun.sfa.web.controllers")
//@Profile("container") Spring 3.1新增加的<beans>的profile属性，详见
//spring-beans-3.1.xsd
@Import(DBConfiguration.class)
public class MVCConfigurationInvade extends WebMvcConfigurerAdapter {

/*	@Bean
	public ViewResolver contentNegotiatingViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/views/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setViewClass(JstlView.class);
		return internalResourceViewResolver;
	}*/
	
	@Bean
	public InternalResourceViewResolver configureInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/views/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);//支持JSTL标签
		return resolver;
	}
/*	@Bean
	public ModelAndViewResolver modelAndViewResolver() {
		return new ModelAndViewResolver() {
			@Override
			public ModelAndView resolveModelAndView(Method arg0, Class arg1,
					Object arg2, ExtendedModelMap arg3, NativeWebRequest arg4) {
				// TODO Auto-generated method stub
				return UNRESOLVED;
			}
		};
	}*/

	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		super.addArgumentResolvers(argumentResolvers);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		super.addFormatters(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		super.addInterceptors(registry);
	}

/*	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		// registry.addResourceHandler("");
		super.addResourceHandlers(registry);
	}*/
	
	/*下面这个方法是上面方法的有力补充解释	 	
	等价于
	<mvc:resources mapping="/resources/**" location="/resources/"/>
	配置
	*/
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) { 
		//registry.addResourceHandler("/*.html").addResourceLocations("/"); 
		//registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		//registry.addResourceHandler("/css/**").addResourceLocations("/css/"); 
		//registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		registry.addResourceHandler("/frontend/**").addResourceLocations("/frontend/"); 
	} 
	
	@Override
	public void addReturnValueHandlers(
			List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		super.addReturnValueHandlers(returnValueHandlers);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		super.addViewControllers(registry);
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		// configurer.enable();
		super.configureDefaultServletHandling(configurer);
	}

	@Override
	public void configureHandlerExceptionResolvers(
			List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}

/*	@SuppressWarnings("rawtypes")
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		converters.add(new MappingJacksonHttpMessageConverter());
		converters.add(new SourceHttpMessageConverter());
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		converters.add(new ByteArrayHttpMessageConverter());
		super.configureMessageConverters(converters);
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		Validator v = super.getValidator();
		return v;
	}*/

}
