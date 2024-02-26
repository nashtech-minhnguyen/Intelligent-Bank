package com.softbank.accountmanagment.service;

import com.softbank.accountmanagment.entity.Account;

public interface RedisService {

    void save(Account account);

    boolean isExistedAccountCode(String accountCode);
}
