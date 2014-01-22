package org.selffun.sfa;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.selffun.sfa.configs.MVCConfiguration;
import org.selffun.sfa.configs.MVCConfigurationInvade;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.util.IntrospectorCleanupListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.filter.CharacterEncodingFilter;

public class DefaultWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		//rootContext.register(MVCConfiguration.class);
		rootContext.register(MVCConfigurationInvade.class); 
		//rootContext.scan("com.foo"); 
		rootContext.setServletContext(servletContext);//一定在要在rootContext的refresh方法前设置这些内容，否则MVCConfiguration类上加@EnableWebMvc注解会抛错
														//Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'defaultServletHandlerMapping' defined in class path resource [org/springframework/web/servlet/config/annotation/DelegatingWebMvcConfiguration.class]: Instantiation of bean failed; nested exception is org.springframework.beans.factory.BeanDefinitionStoreException: Factory method [public org.springframework.web.servlet.HandlerMapping org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.defaultServletHandlerMapping()] threw exception; nested exception is java.lang.IllegalArgumentException: A ServletContext is required to configure default servlet handling
														//		at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:581)
														//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1015)
														//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:911)
														//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:485)
														//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:456)
														//		at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:294)
														//		at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:225)
														//		at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:291)
														//		at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:193)
														//		at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:585)
														//		at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:913)
														//		at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:464)
														//		at org.selffun.sfa.DefaultWebApplicationInitializer.onStartup(DefaultWebApplicationInitializer.java:27)
														//		at org.springframework.web.SpringServletContainerInitializer.onStartup(SpringServletContainerInitializer.java:162)
														//		at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5280)
														//		at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:150)
														//当然MVCConfiguration类可以不加@EnableWebMvc注解，至于怎样选择，@EnableWebMvc类的文档中这样说：
														//If the customization options of WebMvcConfigurer do not expose something you 
														//need to configure, consider removing the @EnableWebMvc annotation and 
														//extending directly from WebMvcConfigurationSupport overriding selected @Bean methods: 
		rootContext.refresh();
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
		        "mvc", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		//dispatcher.addMapping("*.do");
		//dispatcher.setInitParameter("spring.profiles.active", "container"); 
		
	//	servletContext.addListener(new ContextLoaderListener(rootContext));//spring监听	
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
