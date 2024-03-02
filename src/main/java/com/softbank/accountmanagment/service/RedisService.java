package com.softbank.accountmanagment.service;

import com.softbank.common.entity.Account;

public interface RedisService {

    void save(Account account);

    boolean isExistedAccountCode(String accountCode);
}
