package org.gomes.springcloud.repository;

import org.gomes.springcloud.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
