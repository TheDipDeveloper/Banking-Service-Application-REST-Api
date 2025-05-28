package com.dipdeveloper.bank.controller;

import com.dipdeveloper.bank.request.AccountRequest;
import com.dipdeveloper.bank.request.AmountRequest;
import com.dipdeveloper.bank.request.TransferRequest;
import com.dipdeveloper.bank.response.AccountResponse;
import com.dipdeveloper.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // POST api to create a new account
    @PostMapping("/add")
    public ResponseEntity<AccountResponse> add(@RequestBody AccountRequest accountRequest){
        AccountResponse accountResponse = accountService.save(accountRequest);
        return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
    }

    // GET api to get the account detail
    @GetMapping("/get/{accountNo}")
    public ResponseEntity<AccountResponse> get(@PathVariable("accountNo") Integer accountNo){
        AccountResponse accountResponse = accountService.findById(accountNo);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    // GET api to get all account detail
    @GetMapping("/get/all")
    public ResponseEntity<List<AccountResponse>> getAll(){
        List<AccountResponse> accountResponseList = accountService.findAll();
        return new ResponseEntity<>(accountResponseList, HttpStatus.OK);
    }

    // Put Api to withdraw amount
    @PutMapping("/withdraw")
    public ResponseEntity<AccountResponse> withdraw(@RequestBody AmountRequest amountRequest){
        AccountResponse accountResponse = accountService.withdraw(amountRequest);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    // Put Api to deposit amount
    @PutMapping("/deposit")
    public ResponseEntity<AccountResponse> deposit(@RequestBody AmountRequest amountRequest){
        AccountResponse accountResponse = accountService.deposit(amountRequest);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    // Put Api to transfer amount
    @PutMapping("/transfer")
    public ResponseEntity<List<AccountResponse>> transfer(@RequestBody TransferRequest transferRequest){
        List<AccountResponse> accountResponseList = accountService.transfer(transferRequest);
        return new ResponseEntity<>(accountResponseList, HttpStatus.OK);
    }

    // DELETE api to delete the account detail
    @DeleteMapping("/delete/{accountNo}")
    public ResponseEntity<?> delete(@PathVariable("accountNo") Integer accountNo){
        accountService.delete(accountNo);
        return new ResponseEntity<>("Account deleted successfully.", HttpStatus.OK);
    }
}
