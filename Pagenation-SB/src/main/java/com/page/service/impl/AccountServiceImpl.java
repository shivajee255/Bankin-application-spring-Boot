package com.page.service.impl;

import com.page.dto.AccountDto;
import com.page.entity.Account;
import com.page.mapper.AccountMapper;
import com.page.repository.AccountRepository;
import com.page.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {


    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
       Account saveAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account account= accountRepository.findById(id).
               orElseThrow(()->new RuntimeException("Account dose not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account= accountRepository.findById(id).
                orElseThrow(()->new RuntimeException("Account dose not exists"));
 double total=account.getBalance()+amount;
account.setBalance(total);
 Account savedAccount=accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account= accountRepository.findById(id).
                orElseThrow(()->new RuntimeException("Account dose not exists"));

        if (account.getBalance()<amount){
            throw new RuntimeException("Insufficient amount");

        }
        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {

        List<Account>accounts=accountRepository.findAll();

        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {


    }
}
