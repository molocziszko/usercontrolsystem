package com.molocziszko.usercontrolsystem.repository;

import com.molocziszko.usercontrolsystem.models.Role;
import com.molocziszko.usercontrolsystem.models.Status;
import com.molocziszko.usercontrolsystem.models.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserAccountDao {
    private static int COUNTER;
    private final List<UserAccount> accountList;

    {
        accountList = new ArrayList<>();
        accountList.add(new UserAccount(++COUNTER, "admin", "12345abc",
                "Bob", "Schmidt", Role.ADMIN, Status.ACTIVE));
        accountList.add(new UserAccount(++COUNTER, "user1", "123a",
                "Alex", "Warner", Role.USER, Status.ACTIVE));
    }

    public List<UserAccount> getAllAccountList() {
        return accountList;
    }

    public UserAccount getAccount(String username) {
        return accountList
                .stream()
                .filter(account -> account.getUsername().equals(username))
                .findAny()
                .orElse(null);
    }

    public void save(UserAccount userAccount) {
        userAccount.setId(++COUNTER);
        accountList.add(userAccount);
    }

    public void edit(UserAccount userAccount, String username) {
        UserAccount accountToEdit = getAccount(username);

        accountToEdit.setUsername(userAccount.getUsername());
        accountToEdit.setPassword(userAccount.getPassword());
        accountToEdit.setFirstName(userAccount.getFirstName());
        accountToEdit.setLastName(userAccount.getLastName());
        accountToEdit.setRole(userAccount.getRole());
        accountToEdit.setStatus(userAccount.getStatus());
    } 
}
