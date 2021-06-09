package com.molocziszko.usercontrolsystem.controllers;

import com.molocziszko.usercontrolsystem.models.UserAccount;
import com.molocziszko.usercontrolsystem.repository.UserAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListUserAccountController {

    private final UserAccountDao userAccountDao;

    @Autowired
    public ListUserAccountController(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    @GetMapping("/user")
    public String starter(Model model) {
        model.addAttribute("list", userAccountDao.getAllAccountList());
        return "list";
    }

    @GetMapping("/user/{username}")
    public String showDetails(@PathVariable("username") String username, Model model) {
        // TODO get useraccount by id and admin can change state of the user to Lock/Unlock
        model.addAttribute("view", userAccountDao.getAccount(username));
        return "view";
    }

    @GetMapping("/user/new")
    public String newUser(@ModelAttribute("user") UserAccount userAccount) {
        return "new";
    }

    @PostMapping("/user/new")
    public String create(@ModelAttribute("user") UserAccount userAccount) {
        // TODO save to database
        userAccountDao.save(userAccount);
        return "redirect:/user";
    }
}
