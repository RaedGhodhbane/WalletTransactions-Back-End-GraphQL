package org.sid.demo.repositories;

import org.sid.demo.entities.Currency;
import org.sid.demo.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
