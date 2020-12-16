package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {

	@RequestMapping("/login")
	public ModelAndView getLogin(HttpServletRequest request,HttpServletResponse response) {
		String name = request.getParameter("name");
		String password =request.getParameter("password");
		
		ModelAndView mv1 = new ModelAndView();
		mv1.setViewName("display.jsp");
		mv1.addObject("nm", name);
		mv1.addObject("pas", password);
		return mv1;
	}
}
