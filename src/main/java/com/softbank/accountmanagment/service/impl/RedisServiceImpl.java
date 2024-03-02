package com.softbank.accountmanagment.service.impl;

import com.softbank.common.entity.Account;
import com.softbank.accountmanagment.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(Account account) {
        redisTemplate.opsForValue().set(account.getAccountCode(), account.getStatus());
    }

    @Override
    public boolean isExistedAccountCode(String accountCode) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(accountCode));
    }
}
