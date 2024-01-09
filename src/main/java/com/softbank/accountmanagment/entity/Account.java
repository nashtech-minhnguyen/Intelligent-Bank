package com.softbank.accountmanagment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accounts")
@Data
public class Account {

  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name= "account_balance")
  private BigDecimal accountBalance;

  @OneToMany(mappedBy = "accounts", fetch = FetchType.LAZY)
  private List<Transaction> transactions;
}
