package com.mdo.service;

import com.mdo.dao.TransactionDao;
import com.mdo.dao.impl.TransactionDaoImpl;
import com.mdo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionDaoImpl transactionDao;

    public void addTransaction(Transaction transaction) {
        transactionDao.addTransaction(transaction);
    }

    public void editTransaction(Transaction transaction) {
        transactionDao.editTransaction(transaction);
    }

    public void deleteTransactoin(Transaction transaction) {
        transactionDao.deleteTransaction(transaction);
    }

    public Transaction getTransactionById(Integer transactionId) {
        Transaction transaction = transactionDao.getTransactionById(transactionId);
        return transaction;
    }

    public List<Transaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }
}
