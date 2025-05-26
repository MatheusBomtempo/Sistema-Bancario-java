package com.banco.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String cpf;
    
    @Column(nullable = false)
    private String banco;
    
    @Column(nullable = false)
    private double saldo;
} 