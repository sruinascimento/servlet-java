CREATE SCHEMA rempresas;
USE rempresas;

CREATE TABLE empresa(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(255) NOT NULL,
    data_cadastro DATE NOT NULL
);