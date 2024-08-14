package org.sid.demo.dto;

public record AddWalletRequestDTO(
        Double balance,
        String currencyCode
) {}
