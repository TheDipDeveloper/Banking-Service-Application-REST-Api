package com.dipdeveloper.bank.mapper;

import com.dipdeveloper.bank.entity.Account;
import com.dipdeveloper.bank.request.AccountRequest;
import com.dipdeveloper.bank.response.AccountResponse;

public class AccountMapper {
    public static Account accountRequestToAccount(AccountRequest accountRequest){
        Account account = new Account();
        account.setAccountHolderName(accountRequest.getAccountHolderName());
        account.setBalance(accountRequest.getBalance());
        return account;
    }

    public static AccountResponse accountToAccountResponse(Account account){
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountNo(account.getAccountNo());
        accountResponse.setAccountHolderName(account.getAccountHolderName());
        accountResponse.setBalance(account.getBalance());
        return accountResponse;
    }
}
