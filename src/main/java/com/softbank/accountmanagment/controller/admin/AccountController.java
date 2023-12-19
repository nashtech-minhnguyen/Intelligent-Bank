package com.softbank.accountmanagment.controller.admin;

import com.softbank.accountmanagment.dto.AccountDto;
import com.softbank.accountmanagment.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AccountController {

  private final AccountService accountService;

  @PutMapping(value = "/accounts/{id}/balance")
  public ResponseEntity<Void> addBalance(@PathVariable Long id, @RequestParam BigDecimal amountOfMoney) {
    accountService.addBalance(id, amountOfMoney);
    return ResponseEntity.noContent().build();
  }

  @PostMapping(value = "/accounts")
  public ResponseEntity<Void> addAccount(@RequestBody AccountDto accountDto) {
    accountService.createAccount(accountDto);
    return ResponseEntity.noContent().build();
  }

}
