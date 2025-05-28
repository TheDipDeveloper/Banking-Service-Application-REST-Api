package com.dipdeveloper.bank.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private Integer accountNo;
    private String accountHolderName;
    private Long balance;
}
