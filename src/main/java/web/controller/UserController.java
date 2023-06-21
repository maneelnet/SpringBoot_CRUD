package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.usersList());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping(value = "save")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    @PostMapping(value = "/update")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user, user.getId());
        return "redirect:/";
    }

    @PostMapping(value = "/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
