package com.page.service;

import com.page.dto.AccountDto;
import com.page.entity.Account;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id,double amount);

    List<AccountDto> getAllAccount();

    void  deleteAccount(Long id);

}
