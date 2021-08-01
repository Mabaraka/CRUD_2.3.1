package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserService;
import web.models.User;


@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("Users", userService.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute ("user") User user, @PathVariable("id") int id){
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }

}
