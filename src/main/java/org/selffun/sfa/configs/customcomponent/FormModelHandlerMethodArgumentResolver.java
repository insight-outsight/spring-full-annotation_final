package org.selffun.sfa.configs.customcomponent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;



public class FormModelHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
/*		Class<?> klass = parameter.getParameterType();
		if (klass.isAssignableFrom(UserDetails.class) || klass.isAssignableFrom(Long.class)) {
			Annotation[] as = parameter.getParameterAnnotations();
			for (Annotation a : as) {
				if (a.annotationType() == CurrentUser.class) {
					return true;
				}
			}
		}
		return false;*/
		System.out.println("y m d");
		return parameter.hasParameterAnnotation(FormModel.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
/*		if ((SecurityUtils.isAuthenticated() || SecurityUtils.isRemembered()) == false) {
			return null;
		}
		
		Class<?> klass = parameter.getParameterType();
		
		UserDetails userDetails = SecurityUtils.getUserDetails();
		
		if (klass.isAssignableFrom(UserDetails.class)) {
			return SecurityUtils.getUserDetails();
		}
		
		if (klass.isAssignableFrom(Long.class)) {
			return userDetails != null ? userDetails.getId() : null;
		}*/
		FormModel formModelAnnotation = parameter.getParameterAnnotation(FormModel.class);
		if(formModelAnnotation==null){
			return null;
		}
		String formModelName = formModelAnnotation.value();
	
		//are you kidding me?
/*		String objName = parameter.getParameterName() + ".";
		Object o = BeanUtils.instantiate(parameter.getParameterType());
		StringBuffer tmp;
		String[] val;
		Field[] frr = parameter.getParameterType().getDeclaredFields();
		
		for (Iterator<String> itr = webRequest.getParameterNames(); itr.hasNext();) {
			tmp = new StringBuffer(itr.next());
			if (tmp.indexOf(objName) < 0)
				continue;
			for (int i = 0; i < frr.length; i++) {
				frr[i].setAccessible(true);
				if (tmp.toString().equals(objName + frr[i].getName())) {
					val = webRequest.getParameterValues(tmp.toString());
					frr[i].set(o, val[0]);
				}
			}
		}*/
		
		System.out.println(">>>>>>>>>>"+parameter.getParameterName());
		return null;
	}
	
}
