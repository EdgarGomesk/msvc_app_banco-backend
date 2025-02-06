package org.gomes.springcloud.controller;

import org.gomes.springcloud.entity.Transaction;
import org.gomes.springcloud.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping("/save")
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {
        transactionService.createTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaction successfully created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transactionId = transactionService.getTransactionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(transactionId);
    }

    @GetMapping("/")
    public ResponseEntity<List<Transaction>> getAllTransaction() {
        List<Transaction> transactionList = transactionService.getAllTransactions();
        return ResponseEntity.status(HttpStatus.OK).body(transactionList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }
}
