package com.mdo.controller;

import com.mdo.model.Account;
import com.mdo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    static final Logger LOG = LoggerFactory.getLogger(Account.class);

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/addAccount")
    public void addAccount(@RequestBody Account account) {
        accountService.addAccount(account);
    }

    @PostMapping(value = "/editAccount")
    public void editAccount(@RequestBody Account account) {
        accountService.editAccount(account);
    }

    @DeleteMapping(value = "/deleteAccount")
    public void deleteAccount(@RequestBody Account account) {
        accountService.deleteAccount(account);
    }

    @GetMapping(value = "/getAccountById/{accountId}")
    public Account getAccountById(@PathVariable Integer accountId) {
        Account account = accountService.getAccountById(accountId);
        System.out.println(account);
        return account;
    }

    @GetMapping(value = "/getAllAccounts")
    public List<Account> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        System.out.println(accounts);
        return accounts;
    }
}
