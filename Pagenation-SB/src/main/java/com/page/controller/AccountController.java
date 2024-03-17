package com.page.controller;

import com.page.dto.AccountDto;
import com.page.service.AccountService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//Add Account rest Api
@PostMapping()
    public ResponseEntity <AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return  new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //get Account rest api
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
//deposit account api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(
            @PathVariable Long id,@RequestBody Map<String,Double>request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

//withdraw rest api
@PutMapping("/{id}/withdraw")
    public  ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double>request){
        double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
//GetAll rest api
@GetMapping
    public  ResponseEntity<List<AccountDto>>getAllAccount(){
        List<AccountDto> accounts=accountService.getAllAccount();
        return ResponseEntity.ok(accounts);

    }
}
