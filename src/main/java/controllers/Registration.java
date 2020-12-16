package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Registration {
	
	@RequestMapping("/register")
	public ModelAndView getRegistration(HttpServletRequest request,HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("nm", name);
		mv.addObject("em", email);
		mv.addObject("ps",password);
		
		return mv;
		
	}

}
