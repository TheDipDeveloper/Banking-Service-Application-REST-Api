package com.dipdeveloper.bank.service;

import com.dipdeveloper.bank.entity.Account;
import com.dipdeveloper.bank.mapper.AccountMapper;
import com.dipdeveloper.bank.repository.AccountRepository;
import com.dipdeveloper.bank.request.AccountRequest;
import com.dipdeveloper.bank.request.AmountRequest;
import com.dipdeveloper.bank.request.TransferRequest;
import com.dipdeveloper.bank.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountResponse save(AccountRequest accountRequest) {
        Account newAccount = accountRepository
                .save(AccountMapper.accountRequestToAccount(accountRequest));

        return AccountMapper.accountToAccountResponse(newAccount);
    }

    public AccountResponse findById(Integer accountNo) {
        Optional<Account> optionalAccount = accountRepository.findById(accountNo);

        if(optionalAccount.isPresent()){
            return AccountMapper.accountToAccountResponse(optionalAccount.get());
        }

        throw new RuntimeException("Account Not Found.");
    }

    public List<AccountResponse> findAll() {
        return accountRepository.findAll().stream()
                .map(account -> AccountMapper.accountToAccountResponse(account))
                .collect(Collectors.toList());
    }

    public AccountResponse withdraw(AmountRequest amountRequest) {
        Optional<Account> optionalAccount = accountRepository.findById(amountRequest.getAccountNo());

        if(!optionalAccount.isPresent()){
            throw new RuntimeException("Account Not Found.");
        }

        Account account = optionalAccount.get();

        if(account.getBalance() < amountRequest.getAmount()){
            throw new RuntimeException("Insufficient Balance");
        }

        account.setBalance(account.getBalance()-amountRequest.getAmount());
        Account updatedAccount  = accountRepository.save(account);

        return AccountMapper.accountToAccountResponse(updatedAccount);
    }

    public AccountResponse deposit(AmountRequest amountRequest) {
        Optional<Account> optionalAccount = accountRepository.findById(amountRequest.getAccountNo());

        if(!optionalAccount.isPresent()){
            throw new RuntimeException("Account Not Found.");
        }

        Account account = optionalAccount.get();

        account.setBalance(account.getBalance()+amountRequest.getAmount());
        Account updatedAccount  = accountRepository.save(account);

        return AccountMapper.accountToAccountResponse(updatedAccount);
    }

    public List<AccountResponse> transfer(TransferRequest transferRequest) {
        Optional<Account> optionalFromAccount = accountRepository.findById(transferRequest.getFromAccountNo());
        Optional<Account> optionalToAccount = accountRepository.findById(transferRequest.getToAccountNo());

        if(!optionalFromAccount.isPresent() || !optionalToAccount.isPresent()){
            throw new RuntimeException("Account Not Found.");
        }

        Account fromAccount = optionalFromAccount.get();
        Account toAccount = optionalToAccount.get();

        if(fromAccount.getBalance() < transferRequest.getAmount()){
            throw new RuntimeException("Insufficient Balance");
        }

        fromAccount.setBalance(fromAccount.getBalance()-transferRequest.getAmount());
        toAccount.setBalance(toAccount.getBalance()+transferRequest.getAmount());

        Account updatedFromAccount  = accountRepository.save(fromAccount);
        Account updatedToAccount  = accountRepository.save(toAccount);

        return new ArrayList<>(Arrays.asList(
                AccountMapper.accountToAccountResponse(updatedFromAccount),
                AccountMapper.accountToAccountResponse(updatedToAccount)
        ));
    }

    public void delete(Integer accountNo) {
        accountRepository.deleteById(accountNo);
    }
}
