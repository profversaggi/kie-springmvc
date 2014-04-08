package com.kiespring.mvc.controller;

import org.kie.spring.beans.Person;
import org.kie.spring.KieSpringUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/welcome")
public class HelloController {

    @Inject
    KieSpringUtil rulesExecutor;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        Person person = new Person("HAL");

        rulesExecutor.executeRules(person);

        model.addAttribute("isHappy", person.isHappy());
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}
	
}