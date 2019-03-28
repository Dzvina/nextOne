package com.mdo.controller;

import com.mdo.model.Transaction;
import com.mdo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/addTransaction")
    public void addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
    }

    @PostMapping(value = "/editeTransaction")
    public void editeTransaction(@RequestBody Transaction transaction) {
        transactionService.editTransaction(transaction);
    }

    @DeleteMapping(value = "/deleteTransaction")
    public void deleteTransaction(@RequestBody Transaction transaction) {
        transactionService.deleteTransactoin(transaction);
    }


    @GetMapping(value = "/getTransactionById/{transactionId}")
    public Transaction getTransactionById(@PathVariable Integer transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        System.out.println(transaction);
        return transaction;
    }

    @GetMapping(value = "/getAllTransactions")
    public List<Transaction> getAllTrasactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        System.out.println(transactions);
        return transactions;
    }
}
