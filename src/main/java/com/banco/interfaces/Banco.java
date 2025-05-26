package com.banco.interfaces;

import com.banco.model.Conta;

public interface Banco {
    void sacar(Conta conta, double valor);
    void depositar(Conta conta, double valor);
    void extrato(Conta conta);
} 