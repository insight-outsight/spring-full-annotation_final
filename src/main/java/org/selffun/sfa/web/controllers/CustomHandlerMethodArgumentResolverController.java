package org.selffun.sfa.web.controllers;

import org.selffun.sfa.configs.customcomponent.FormModel;
import org.selffun.sfa.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomHandlerMethodArgumentResolverController {

	@RequestMapping(value = "/CustomHandlerMethodArgumentResolver", method = RequestMethod.GET)
	public String businessMethod(@FormModel("p") Person aPer) {
		System.out.println("accepted-" + aPer);
		return "Welcome business Method";
	}

}