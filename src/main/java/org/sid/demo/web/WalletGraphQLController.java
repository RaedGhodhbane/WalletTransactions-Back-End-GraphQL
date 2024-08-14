package org.sid.demo.web;

import org.sid.demo.dto.AddWalletRequestDTO;
import org.sid.demo.entities.Currency;
import org.sid.demo.entities.Wallet;
import org.sid.demo.entities.WalletTransaction;
import org.sid.demo.repositories.CurrencyRepository;
import org.sid.demo.repositories.WalletRepository;
import org.sid.demo.services.WalletService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class WalletGraphQLController {
    private WalletRepository walletRepository;
    private CurrencyRepository currencyRepository;
    private WalletService walletService;

    public WalletGraphQLController(WalletRepository walletRepository, CurrencyRepository currencyRepository, WalletService walletService) {
        this.walletRepository = walletRepository;
        this.currencyRepository = currencyRepository;
        this.walletService = walletService;
    }

    @QueryMapping
    public List<Wallet> userWallets() {
        return walletRepository.findAll();
    }

    @QueryMapping
    public Wallet walletById(@Argument String id) {
        return walletRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Wallet %s not found", id)));
    }

    @QueryMapping
    public List<Currency> currencies() {
        return currencyRepository.findAll();
    }

    @MutationMapping
    public Wallet addWallet(@Argument AddWalletRequestDTO wallet) {
        return walletService.save(wallet);
    }

    @MutationMapping
    public List<WalletTransaction> walletTransfert(@Argument String sourceWalletId,
                                                   @Argument String destinationWalletId,
                                                   @Argument Double amount) {
        return walletService.walletTransfert(sourceWalletId,destinationWalletId,amount);
    }
}

