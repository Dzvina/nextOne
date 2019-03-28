package com.mdo.dao.impl;

import com.mdo.dao.TransactionDao;
import com.mdo.model.Transaction;
import com.mdo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao {
    static final Logger LOG = LoggerFactory.getLogger(TransactionDaoImpl.class);

    @Override
    public void addTransaction(Transaction transaction) {
        LOG.info("Add new transaction.");
        Session session = getSession();
        session.beginTransaction();
        session.save(transaction);
        session.getTransaction().commit();
        session.close();
        LOG.info("Add new transaction successful.");
    }

    @Override
    public void editTransaction(Transaction transaction) {
        LOG.info("Edit transaction.");
        Session session = getSession();
        session.beginTransaction();
        session.update(transaction);
        session.getTransaction().commit();
        session.close();
        LOG.info("Edit transaction successful.");
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        LOG.info("Delete transaction.");
        Session session = getSession();
        session.beginTransaction();
        session.delete(transaction);
        session.getTransaction().commit();
        session.close();
        LOG.info("Delete transaction successful.");
    }

    @Override
    public Transaction getTransactionById(Integer transactionId) {
        LOG.info("Get transaction by id.");
        Transaction transaction;
        Session session = getSession();
        session.beginTransaction();
        transaction = session.get(Transaction.class, transactionId);
        session.close();
        LOG.info("Get transaction by id successful.");
        return transaction;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        LOG.info("Get all transactions.");
        List transactions;
        Session session = getSession();
        transactions = (List<Transaction>) session.createQuery("From Transactoin").list();
        LOG.info("Get all transactions successful.");
        return transactions;
    }

    private Session getSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
}
