package com.softbank.accountmanagment.mapper;

import com.softbank.accountmanagment.dto.AccountDto;
import com.softbank.accountmanagment.entity.Account;
import org.springframework.stereotype.Component;

public interface AccountMapper {

  Account toEntityAccount(AccountDto accountDto);
}
