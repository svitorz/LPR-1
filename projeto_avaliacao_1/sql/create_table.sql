CREATE TABLE veiculos (
    id serial,
    marca varchar(50),
    modelo varchar(50),
    ano int,
    color varchar(50),
    placa varchar(15),
    chassi varchar(255),
    combustivel varchar(100),
    quilometragem DOUBLE PRECISION,
    preco real,
    proprietario varchar(255),
    data_registro date,
    CONSTRAINT pk_veiculos PRIMARY KEY (id),
    CONSTRAINT chassi_unique UNIQUE(chassi)
);