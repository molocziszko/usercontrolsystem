package com.molocziszko.usercontrolsystem.service;

import com.molocziszko.usercontrolsystem.models.UserAccount;
import com.molocziszko.usercontrolsystem.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {


    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    public UserAccount getUserAccount(Long id) {
        return userAccountRepository.getOne(id);
    }

    public void save(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }

    public void edit(UserAccount userAccount, Long id) {
        UserAccount accountToEdit = getUserAccount(id);

        accountToEdit.setUsername(userAccount.getUsername());
        accountToEdit.setPassword(userAccount.getPassword());
        accountToEdit.setFirstName(userAccount.getFirstName());
        accountToEdit.setLastName(userAccount.getLastName());
        accountToEdit.setRole(userAccount.getRole());
        accountToEdit.setStatus(userAccount.getStatus());
    }
}