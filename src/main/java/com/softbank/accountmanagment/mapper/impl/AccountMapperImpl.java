package com.softbank.accountmanagment.mapper.impl;

import com.softbank.accountmanagment.dto.AccountDto;
import com.softbank.common.entity.Account;
import com.softbank.accountmanagment.mapper.AccountMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEntityAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountBalance(accountDto.getAccountBalance());
        return account;
    }
}
