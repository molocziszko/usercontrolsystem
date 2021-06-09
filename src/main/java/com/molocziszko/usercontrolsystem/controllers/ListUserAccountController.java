package com.molocziszko.usercontrolsystem.controllers;

import com.molocziszko.usercontrolsystem.models.UserAccount;
import com.molocziszko.usercontrolsystem.repository.UserAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{username}/edit")
    public String edit(@PathVariable("username") String username, Model model) {
        model.addAttribute("user", userAccountDao.getAccount(username));
        return "edit";
    }

    @PatchMapping("/user/{username}")
    public String edit(@ModelAttribute("user") UserAccount userAccount, @PathVariable("username") String username) {
        userAccountDao.edit(userAccount, username);
        return "redirect:/user";
    }
}
