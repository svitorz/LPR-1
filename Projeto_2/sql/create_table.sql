CREATE TABLE fornecedor (
  id_for serial,
  cnpj_for character varying(15),
  nome_for character varying(50),
  tel_for character varying(13),
  data_cad_for date,
  CONSTRAINT pk_fornecedor PRIMARY KEY(id_for)
);


