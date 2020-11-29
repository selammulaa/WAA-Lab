package mum.edu.controller;

import mum.edu.domain.User;
import mum.edu.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("userInfo")
public class LoginController {

    UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String login() throws Exception {

        return "login";

    }

    @PostMapping(value = "/login")
    public String authenticate(User loginUser, Model model) throws Exception {

        User user = userService.findByName(loginUser.getName());

        if (user == null || !user.getPassword().equals(loginUser.getPassword())) {

            throw new RuntimeException("Username or Password is invalid");
        }

        model.addAttribute("userInfo", user);

        return "redirect:advice";
    }

    @PostMapping(value = "/logout")
    public String logout(Model model, SessionStatus status) throws Exception {

        status.setComplete();

        return "redirect:advice";

    }


}
