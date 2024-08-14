package org.sid.demo.repositories;

import org.sid.demo.entities.Wallet;
import org.sid.demo.entities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
}
