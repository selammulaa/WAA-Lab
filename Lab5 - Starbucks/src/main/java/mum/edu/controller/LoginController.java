package mum.edu.controller;

import mum.edu.domain.User;
import mum.edu.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
 
/**
 * Servlet implementation class AuthenticationServlet
 */
@Controller
@SessionAttributes("userInfo")
public class LoginController   {
 
 
 	  @Autowired
	  UserService userService;
 
	  /**
	   * Landing page method - Login facility
	   * @return
	   * @throws Exception
	   */
 	 @RequestMapping(value="/login",method = RequestMethod.GET)
	 public String login( ) throws Exception {

	       return  "login" ;    

	}

	  @RequestMapping (value="/login",method = RequestMethod.POST)
	  public String authenticate( User loginUser, Model model) throws Exception {

		User user = userService.findByName(loginUser.getName());
		
		if(user == null || !user.getPassword().equals(loginUser.getPassword())) {
				
			throw new RuntimeException("Username or Password is invalid");
		} 
 		
		// Add to Session
		model.addAttribute("userInfo",user);
		
		return "redirect:advice";
	}

	  @RequestMapping (value="/logout",method = RequestMethod.GET)
	  public String logout(Model model, SessionStatus status ) throws Exception {

 		  status.setComplete();
	       
		  return  "redirect:advice";  

	}


}
