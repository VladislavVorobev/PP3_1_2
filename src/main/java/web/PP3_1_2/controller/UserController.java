package web.PP3_1_2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.PP3_1_2.model.User;
import web.PP3_1_2.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/show")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUserTable());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/show";
    }

    @GetMapping("/update")
    public String editUser(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.findUser(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") @Valid User user) {
        userService.updateUser(user);
        return "redirect:/show";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/show";
    }

}