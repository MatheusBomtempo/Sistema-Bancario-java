package com.banco.impl;

import com.banco.interfaces.Banco;
import com.banco.model.Conta;
import org.springframework.stereotype.Service;

@Service
public class BancoA implements Banco {
    
    @Override
    public void sacar(Conta conta, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser maior que zero");
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
        System.out.println("======================");
    }

    public void transferenciaConta(Conta contaOrigem, Conta contaDestino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser maior que zero");
        }
        if (contaOrigem.getSaldo() < valor) {
            throw new IllegalStateException("Saldo insuficiente para realizar a transferência");
        }
        
        sacar(contaOrigem, valor);
        depositar(contaDestino, valor);
    }
} 