package com.mdo.dao.impl;

import com.mdo.dao.AccountDao;
import com.mdo.model.Account;
import com.mdo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public void addAccount(Account account) {
        Session session = getSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editAccount(Account account) {
        Session session = getSession();
        session.beginTransaction();
        session.update(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAccount(Account account) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(account);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Account getAccountById(Integer accountId) {
        Account account;
        Session session = getSession();
        session.beginTransaction();
        account = session.get(Account.class, accountId);
        session.close();
        return account;
    }

    @Override
    public List<Account> getAllaccounts() {
        List accounts;
        Session session = getSession();
        accounts = (List<Account>) session.createQuery("From Account").list();
        session.close();
        return accounts;
    }

    private Session getSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
}
