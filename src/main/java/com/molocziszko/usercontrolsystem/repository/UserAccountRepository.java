package com.molocziszko.usercontrolsystem.repository;

import com.molocziszko.usercontrolsystem.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
