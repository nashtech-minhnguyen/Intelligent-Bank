package com.softbank.accountmanagment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {

  private BigDecimal accountBalance;
}
