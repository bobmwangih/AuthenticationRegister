package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.UserBusiness;
import models.User;

@Controller
public class Registration {
	
	@RequestMapping("/register")
	public ModelAndView getRegistration(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		
		ConfigurableApplicationContext cp = new ClassPathXmlApplicationContext("resource/applicationContext.xml");
		UserBusiness ub =(UserBusiness) cp.getBean("bizLogic");
		int i = ub.createUser(new User(name,email,password));
		System.out.println(i);
		cp.close();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("nm", name);
		mv.addObject("em", email);
		mv.addObject("ps",password);
		
		return mv;
		
	}

}
