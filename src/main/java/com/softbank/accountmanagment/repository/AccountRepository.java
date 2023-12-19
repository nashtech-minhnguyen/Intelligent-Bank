package com.softbank.accountmanagment.repository;

import com.softbank.accountmanagment.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
