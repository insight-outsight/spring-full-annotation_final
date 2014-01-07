package org.selffun.sfa;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.selffun.sfa.configs.MVCConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.util.IntrospectorCleanupListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.filter.CharacterEncodingFilter;

public class DefaultWebApplicationInitializer implements WebApplicationInitializer {

@Override
public void onStartup(ServletContext servletContext) throws ServletException {

	AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	rootContext.register(MVCConfiguration.class); 
	//rootContext.scan("com.foo"); 
	rootContext.refresh();
	
	ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
	        "mvc", new DispatcherServlet(rootContext));
	dispatcher.setLoadOnStartup(1);
	//dispatcher.addMapping("/");
	dispatcher.addMapping("*.do");
	//dispatcher.setInitParameter("spring.profiles.active", "container"); 
	
	servletContext.addListener(new ContextLoaderListener(rootContext));//spring监听	
//	servletContext.addListener(new RequestContextListener());
//	servletContext.addListener(new IntrospectorCleanupListener());
//	servletContext.setInitParameter("log4jRefreshInterval", "6000");//配置context初始化参数
//	servletContext.setInitParameter("webAppRootKey", "AppFrame.root");
//	servletContext.setInitParameter("log4jConfigLocation", "classpath:log4j.xml");
//	servletContext.setInitParameter("contextConfigLocation", "classpath:applicationContext.xml");
//	Map<String,String> map = new HashMap<String,String>();
//	map.put("encoding", "UTF-8");
//	map.put("forceEncoding", "true");
//	servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter()).setInitParameters(map);
//	rootContext.setServletContext(servletContext);
	
	}

}
