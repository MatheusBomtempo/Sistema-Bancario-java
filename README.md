# Sistema Bancário

Este é um sistema bancário simples implementado em Java usando Spring Boot, Maven e MySQL.

## Requisitos

- Java 11 ou superior
- Maven
- MySQL 8.0 ou superior

## Configuração

1. Clone o repositório
2. Configure o banco de dados MySQL:
   - Crie um banco de dados chamado `banco_db`
   - Configure o usuário e senha no arquivo `src/main/resources/application.properties`

## Estrutura do Projeto

- `src/main/java/com/banco/model`: Contém as classes de modelo
- `src/main/java/com/banco/interfaces`: Contém as interfaces do sistema
- `src/main/java/com/banco/impl`: Contém as implementações dos bancos

## Funcionalidades

### BancoA
- Saque (sem limite)
- Depósito
- Extrato
- Transferência entre contas

### BancoB
- Saque (com limite de R$ 500,00)
- Depósito
- Extrato

## Como Executar

1. Execute o comando Maven para compilar o projeto:
```bash
mvn clean install
```

2. Execute a aplicação:
```bash
mvn spring-boot:run
```

## Exemplo de Uso

```java
// Criar uma conta
Conta conta = new Conta();
conta.setCpf("123.456.789-00");
conta.setBanco("BancoA");
conta.setSaldo(1000.00);

// Realizar operações
BancoA bancoA = new BancoA();
bancoA.depositar(conta, 500.00);
bancoA.sacar(conta, 200.00);
bancoA.extrato(conta);
``` 