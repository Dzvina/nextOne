package com.mdo.dao;

import com.mdo.model.Transaction;

import java.util.List;

public interface TransactionDao {
    void addTransaction(Transaction transaction);

    void editTransaction(Transaction transaction);

    void deleteTransaction(Transaction transaction);

    Transaction getTransactionById(Integer transactionId);

    List<Transaction> getAllTransactions();
}
