package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDAO;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("Users", userDAO.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.show(id));
        return "show";
    }
}
