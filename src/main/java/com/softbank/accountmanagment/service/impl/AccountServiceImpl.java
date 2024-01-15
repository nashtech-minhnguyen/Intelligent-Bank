package com.softbank.accountmanagment.service.impl;

import com.softbank.accountmanagment.dto.AccountDto;
import com.softbank.accountmanagment.entity.Account;
import com.softbank.accountmanagment.mapper.AccountMapper;
import com.softbank.accountmanagment.repository.AccountRepository;
import com.softbank.accountmanagment.service.AccountService;
import com.softbank.common.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  private final AccountMapper accountMapper;

  @Override
  @Transactional
  public void addBalance(Long accountId, BigDecimal amountOfMoney) {
    Account account = accountRepository.getReferenceById(accountId);
    account.setAccountBalance(account.getAccountBalance().add(amountOfMoney));
    accountRepository.save(account);
  }

  @Override
  @Transactional
  public void createAccount(AccountDto accountDto) {
   Account account = accountMapper.toEntityAccount(accountDto);
   account.setStatus(Status.ACTIVE);
   accountRepository.save(account);
  }
}
