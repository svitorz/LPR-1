-- Tabela categoria (entidade independente)
CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

-- Tabela autor (entidade independente)
CREATE TABLE autor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    nacionalidade VARCHAR(100),
    data_nascimento VARCHAR(20),
    email VARCHAR(120),
    telefone VARCHAR(20)
);

-- Tabela livro (1-N com categoria)
CREATE TABLE livro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    ano_publicacao INT,
    isbn VARCHAR(20),
    editora VARCHAR(120),
    edicao INT,
    quantidade_paginas INT,
    id_categoria INT REFERENCES categoria(id)
);

-- Tabela N-N entre livro e autor
CREATE TABLE livro_autor (
    id_livro INT REFERENCES livro(id),
    id_autor INT REFERENCES autor(id),
    PRIMARY KEY (id_livro, id_autor)
);
