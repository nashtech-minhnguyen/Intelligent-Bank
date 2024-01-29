package com.softbank.accountmanagment.service.impl;

import com.softbank.accountmanagment.dto.AccountDto;
import com.softbank.accountmanagment.entity.Account;
import com.softbank.accountmanagment.mapper.AccountMapper;
import com.softbank.accountmanagment.repository.AccountRepository;
import com.softbank.accountmanagment.service.AccountService;
import com.softbank.common.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private static final int ACCOUNT_CODE_LENGTH = 9;

    private static final int LETTER_ACCOUNT_CODE_LENGTH = 2;

    private static final int NUMBER_OF_DIGITS = 10;

    private static final int NUMBER_OF_LETTERS = 26;

    private static final Random RANDOM = new Random();

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Value("kafka.topic.create-account")
    private String KAFKA_TOPIC_CREATE_ACCOUNT;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


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
        String accountCode = createAccountCode();
        while (isExistedAccountCode(accountCode)) {
          accountCode = createAccountCode();
        }
        account.setAccountCode(accountCode);
        accountRepository.save(account);
        redisTemplate.opsForValue().set(accountCode, account.getStatus());
        kafkaTemplate.send(KAFKA_TOPIC_CREATE_ACCOUNT, accountCode);
    }

    private boolean isExistedAccountCode(String accountCode) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(accountCode));
    }

    private String createAccountCode() {
        StringBuilder accountCode = new StringBuilder();
        for (int i = 0; i < ACCOUNT_CODE_LENGTH; i++) {
            if (i < LETTER_ACCOUNT_CODE_LENGTH) {
                accountCode.append((char) ('A' + RANDOM.nextInt(NUMBER_OF_LETTERS)));
            } else {
                accountCode.append(RANDOM.nextInt(NUMBER_OF_DIGITS));
            }
        }
        return accountCode.toString();
    }
}
