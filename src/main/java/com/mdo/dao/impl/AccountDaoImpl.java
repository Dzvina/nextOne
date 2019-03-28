package com.mdo.dao.impl;

import com.mdo.dao.AccountDao;
import com.mdo.model.Account;
import com.mdo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    static final Logger LOG = LoggerFactory.getLogger(AccountDaoImpl.class);

    @Override
    public void addAccount(Account account) {
        LOG.info("Add new account.");
        Session session = getSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();
        LOG.info("Add new account successful.");
    }

    @Override
    public void editAccount(Account account) {
        LOG.info("Edit account.");
        Session session = getSession();
        session.beginTransaction();
        session.update(account);
        session.getTransaction().commit();
        session.close();
        LOG.info("Edit account successful.");
    }

    @Override
    public void deleteAccount(Account account) {
        LOG.info("Delete account.");
        Session session = getSession();
        session.beginTransaction();
        session.delete(account);
        session.getTransaction().commit();
        session.close();
        LOG.info("Delete account successful.");
    }

    @Override
    public Account getAccountById(Integer accountId) {
        LOG.info("Get account by id.");
        Account account;
        Session session = getSession();
        session.beginTransaction();
        account = session.get(Account.class, accountId);
        session.close();
        LOG.info("Get account by id successful.");
        return account;
    }

    @Override
    public List<Account> getAllAccounts() {
        LOG.info("Get all accounts.");
        List accounts;
        Session session = getSession();
        accounts = (List<Account>) session.createQuery("From Account").list();
        session.close();
        LOG.info("Get all accounts successful.");
        return accounts;
    }

    private Session getSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
}
