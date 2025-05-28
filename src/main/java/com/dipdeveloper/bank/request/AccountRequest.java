package com.dipdeveloper.bank.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private String accountHolderName;
    private Long balance;
}
