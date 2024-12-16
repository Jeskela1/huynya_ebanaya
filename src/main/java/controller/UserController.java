package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showAllUsers(ModelMap model){
        List<User> allUsers = userService.getAllUser();
        model.addAttribute("allUsers", allUsers);
        return "user";
    }
}
