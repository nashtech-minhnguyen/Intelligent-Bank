package com.softbank.accountmanagment.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransactionDto {

    private Long rootAccountId;

    private Long partnerAccountId;

    private BigDecimal amount;
}
