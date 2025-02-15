package org.gomes.springcloud.service;

import org.gomes.springcloud.entity.Transaction;
import org.gomes.springcloud.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void createTransaction(Transaction transaction) {
        transaction.setDate(LocalDate.now());
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        Optional<Transaction> transactionId = transactionRepository.findById(id);
        if (transactionId.isPresent()) {
            return transactionRepository.getReferenceById(id);
        }
        throw new RuntimeException("Transaction Not Found");
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> transactionId = transactionRepository.findById(id);
        if (transactionId.isPresent()) {
            Transaction transactionExists = transactionId.get();

            transactionExists.setReference(transaction.getReference());
            transactionExists.setAccountIban(transaction.getAccountIban());
            transactionExists.setDate(transaction.getDate());
            transactionExists.setAmount(transaction.getAmount());
            transactionExists.setFee(transaction.getFee());
            transactionExists.setDescription(transaction.getDescription());
            transactionExists.setStatus(transaction.getStatus());
            transactionExists.setChannel(transaction.getChannel());

            return transactionRepository.save(transactionExists);
        }

        throw new RuntimeException("Transaction Not Found");
    }
}
