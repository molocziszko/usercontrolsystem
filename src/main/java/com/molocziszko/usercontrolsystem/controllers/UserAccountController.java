package com.molocziszko.usercontrolsystem.controllers;

import com.molocziszko.usercontrolsystem.models.UserAccount;
import com.molocziszko.usercontrolsystem.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserAccountController {

    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/user")
    public String starter(Model model) {
        model.addAttribute("list", userAccountService.getAllUserAccounts());
        return "list";
    }

    @GetMapping("/user/{id}")
    public String showDetails(@PathVariable("id") Long id, Model model) {
        // TODO get useraccount by id and admin can change state of the user to Lock/Unlock
        model.addAttribute("view", userAccountService.getUserAccount(id));
        return "view";
    }

    @GetMapping("/user/new")
    public String newUser(@ModelAttribute("user") UserAccount userAccount) {
        return "new";
    }

    @PostMapping("/user/new")
    public String create(@Valid @ModelAttribute("user") UserAccount userAccount, BindingResult result) {
        if (result.hasErrors())
            return "new";
        // TODO save to database
        userAccountService.save(userAccount);
        return "redirect:/user";
    }

    @GetMapping("/user/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userAccountService.getUserAccount(id));
        return "edit";
    }

    @PatchMapping("/user/{id}")
    public String edit(@Valid @ModelAttribute("user") UserAccount userAccount, BindingResult result,
                       @PathVariable("id") Long id) {
        if (result.hasErrors())
            return "edit";
        userAccountService.edit(userAccount, id);
        return "redirect:/user";
    }
}
