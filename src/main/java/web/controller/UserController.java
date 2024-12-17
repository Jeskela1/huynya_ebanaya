package web.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import web.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/new")
    public String createUserPage(@ModelAttribute("user") User user) {

        return "user-create";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Validated User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-create";
        }

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUserPage(@RequestParam("id") Long id, Model model) {
        Optional<User> userById = userService.getUserById(id);

        if (userById.isPresent()) {
            model.addAttribute("user", userById.get());
            return "edit-user";
        } else {
            return "redirect:/users";
        }
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") @Validated User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }

        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
