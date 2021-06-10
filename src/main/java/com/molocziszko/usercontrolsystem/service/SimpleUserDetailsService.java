package com.molocziszko.usercontrolsystem.service;

import com.molocziszko.usercontrolsystem.models.UserAccount;
import com.molocziszko.usercontrolsystem.repository.UserAccountRepository;
import org.springframework.data.domain.Example;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Optional;

@Service(value = "simpleUserService")
public class SimpleUserDetailsService implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private UserAccountRepository repository;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return user;
    }

    @Override
    public void createUser(UserDetails user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateUser(UserDetails user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUser(String username) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean userExists(String username) {
        try {
            loadUserByUsername(username);
            return true;
        } catch (UsernameNotFoundException e) {
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserAccount example = new UserAccount();
        example.setUsername(username);
        Optional<UserAccount> optionalResult = repository.findOne(Example.of(example));
        UserAccount result;
        if (optionalResult.isPresent()) {
            result = optionalResult.get();
        } else {
            throw new UsernameNotFoundException(username);
        }

        return new User(username, result.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(result.getRole().toString())));
    }
}