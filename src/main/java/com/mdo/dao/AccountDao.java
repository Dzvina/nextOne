package com.mdo.dao;

import com.mdo.model.Account;

import java.util.List;

public interface AccountDao {

    void addAccount(Account account);

    void editAccount(Account account);

    void deleteAccount(Account account);

    Account getAccountById(Integer accountId);

    List<Account> getAllaccounts();
}
