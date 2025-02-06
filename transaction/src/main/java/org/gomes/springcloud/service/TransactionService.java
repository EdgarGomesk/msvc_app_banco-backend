package org.gomes.springcloud.service;

import org.gomes.springcloud.entity.Transaction;

import java.util.List;

public interface TransactionService {

    void createTransaction(Transaction transaction);

    Transaction getTransactionById(Long id);

    List<Transaction> getAllTransactions();

    Transaction updateTransaction(Long id, Transaction transaction);
}
