package com.mdo.controller;

import com.mdo.model.Account;
import com.mdo.service.AccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "This is account controller")
@Controller
@RequestMapping("/account")
public class AccountController {

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
