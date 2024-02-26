package com.softbank.accountmanagment.entity;

import com.softbank.common.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@RequiredArgsConstructor
@Getter
@Setter
public class Account extends Common {

  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "account_code", unique = true)
  private String accountCode;

  @Column(name= "account_balance")
  private BigDecimal accountBalance;

  @OneToMany(mappedBy = "rootAccount")
  private List<Transaction> transactions;

  @Enumerated(EnumType.STRING)
  private Status status;
}
