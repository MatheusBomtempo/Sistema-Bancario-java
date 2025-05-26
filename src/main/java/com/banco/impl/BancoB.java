package com.banco.impl;

import com.banco.interfaces.Banco;
import com.banco.model.Conta;
import org.springframework.stereotype.Service;

@Service
public class BancoB implements Banco {
    private static final double LIMITE_SAQUE = 500.00;
    
    @Override
    public void sacar(Conta conta, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser maior que zero");
        }
        if (valor > LIMITE_SAQUE) {
            throw new IllegalStateException("Valor do saque excede o limite de R$ " + LIMITE_SAQUE);
        }
        if (conta.getSaldo() < valor) {
            throw new IllegalStateException("Saldo insuficiente para realizar o saque");
        }
        conta.setSaldo(conta.getSaldo() - valor);
    }

    @Override
    public void depositar(Conta conta, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser maior que zero");
        }
        conta.setSaldo(conta.getSaldo() + valor);
    }

    @Override
    public void extrato(Conta conta) {
        System.out.println("=== Extrato da Conta ===");
        System.out.println("CPF: " + conta.getCpf());
        System.out.println("Banco: " + conta.getBanco());
        System.out.println("Saldo Atual: R$ " + conta.getSaldo());
        System.out.println("Limite de Saque: R$ " + LIMITE_SAQUE);
        System.out.println("======================");
    }
} 