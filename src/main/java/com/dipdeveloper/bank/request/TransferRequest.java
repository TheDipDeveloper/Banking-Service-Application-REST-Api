package com.dipdeveloper.bank.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
    private Integer fromAccountNo;
    private Integer toAccountNo;
    private Long amount;
}
