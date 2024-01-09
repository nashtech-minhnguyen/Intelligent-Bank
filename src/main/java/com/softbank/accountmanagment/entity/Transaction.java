package com.softbank.accountmanagment.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "source_account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account sourceAccount;

    @Column(name = "target_account_id")
    private Long targetAccountId;

    @Column(name = "amount")
    private BigDecimal amount;

}
