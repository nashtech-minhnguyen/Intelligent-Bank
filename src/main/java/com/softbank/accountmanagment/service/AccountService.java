package com.softbank.accountmanagment.service;

import com.softbank.accountmanagment.dto.AccountDto;

import java.math.BigDecimal;

public interface AccountService {

  void addBalance(Long accountId, BigDecimal amountOfMoney);

  void createAccount(AccountDto accountDto);
}
