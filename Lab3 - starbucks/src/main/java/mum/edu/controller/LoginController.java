package mum.edu.controller;

import mum.edu.domain.User;
import mum.edu.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    UserService userService;

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/login"})
    public String Login() throws Exception {

        return "login";

    }

    @PostMapping(value = "login")
    public String Authenticate(User loginUser) throws Exception {

        User user = userService.findByName(loginUser.getName());

        if (user == null || !user.getPassword().equals(loginUser.getPassword())) {

            throw new RuntimeException("Username or Password is invalid");
        }

//        return "LoginSuccessful";
		return "redirect:advice";
    }

}
