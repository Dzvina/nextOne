package com.mdo.dao.impl;

import com.mdo.dao.TransactionDao;
import com.mdo.model.Transaction;
import com.mdo.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao {

    @Override
    public void addTransaction(Transaction transaction) {
        Session session = getSession();
        session.beginTransaction();
        session.save(transaction);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void editTransaction(Transaction transaction) {
        Session session = getSession();
        session.beginTransaction();
        session.update(transaction);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(transaction);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Transaction getTransactionById(Integer transactionId) {
        Transaction transaction;
        Session session = getSession();
        session.beginTransaction();
        transaction = session.get(Transaction.class, transactionId);
        session.close();
        return transaction;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List transactions;
        Session session = getSession();
        transactions = (List<Transaction>) session.createQuery("From Transactoin").list();
        return transactions;
    }

    private Session getSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
}
