package com.softbank.accountmanagment.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "root_account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account rootAccount;

    @Column(name = "partner_account_id")
    private Long partnerAccountId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;

}
