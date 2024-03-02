package com.softbank.accountmanagment.mapper;

import com.softbank.accountmanagment.dto.AccountDto;
import com.softbank.common.entity.Account;

public interface AccountMapper {

  Account toEntityAccount(AccountDto accountDto);
}
