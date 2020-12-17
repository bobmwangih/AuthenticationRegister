package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.UserBusiness;

@Controller
public class Login {

	@RequestMapping("/login")
	public ModelAndView getLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String email = request.getParameter("name");
		String password =request.getParameter("password");
		
		ConfigurableApplicationContext cp = new ClassPathXmlApplicationContext("resource/applicationContext.xml");
		
		UserBusiness details =(UserBusiness) cp.getBean("bizLogic");
		if (details.authenticateLogInDetails(email, password)) {
			ModelAndView mv1 = new ModelAndView();
			mv1.setViewName("display.jsp");
			mv1.addObject("nm", email);
			mv1.addObject("pas", password);
			return mv1;
		}
		else {
			ModelAndView mv1 = new ModelAndView();
			mv1.setViewName("fail.jsp");
			mv1.addObject("nm", email);
			mv1.addObject("pas", password);
			return mv1;
		}
		
	}
}
