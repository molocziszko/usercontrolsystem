package com.molocziszko.usercontrolsystem.service;

import com.molocziszko.usercontrolsystem.models.UserAccount;
import com.molocziszko.usercontrolsystem.repository.UserAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {

    private final UserAccountDao userAccountDao;

    @Autowired
    public UserAccountService(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    public List<UserAccount> getAllUserAccounts() {
        return userAccountDao.getAllAccountList();
    }
}