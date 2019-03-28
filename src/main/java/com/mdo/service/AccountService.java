package com.mdo.service;

import com.mdo.dao.impl.AccountDaoImpl;
import com.mdo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountDaoImpl accountDao;

    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    public void editAccount(Account account) {
        accountDao.editAccount(account);
    }

    public void deleteAccount(Account account) {
        accountDao.deleteAccount(account);
    }

    public Account getAccountById(Integer accountId) {
        return accountDao.getAccountById(accountId);
    }

    public List<Account> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

}
