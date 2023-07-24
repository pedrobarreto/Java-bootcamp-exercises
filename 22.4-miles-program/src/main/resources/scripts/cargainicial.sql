CREATE SCHEMA IF NOT EXISTS milhas AUTHORIZATION sa;

-- Usuario #####

CREATE TABLE IF NOT EXISTS milhas.PESSOA (
   idpessoa INT auto_increment,
   login VARCHAR(100) NOT NULL,
   hash VARCHAR(64) NOT NULL,
   PRIMARY KEY (idpessoa),
   UNIQUE KEY login_UNIQUE (login)  
);

DELETE FROM milhas.PESSOA;

INSERT INTO milhas.PESSOA (LOGIN, HASH) VALUES ('huguinho' , '63a9f0ea7bb98050796b649e85481845'); -- root
INSERT INTO milhas.PESSOA (LOGIN, HASH) VALUES ('zezinho' , 'e8d95a51f3af4a3b134bf6bb680a213a'); -- senha

-- Tipo lançamento #####

CREATE TABLE IF NOT EXISTS milhas.TIPOLANCAMENTO (
   idtipolancamento INT,
   descricao VARCHAR(100) NOT NULL,
   PRIMARY KEY (idtipolancamento)
);

DELETE FROM milhas.TIPOLANCAMENTO;

INSERT INTO milhas.TIPOLANCAMENTO (IDTIPOLANCAMENTO, DESCRICAO) VALUES (1, 'Bônus');
INSERT INTO milhas.TIPOLANCAMENTO (IDTIPOLANCAMENTO, DESCRICAO) VALUES (2, 'Transferência');
INSERT INTO milhas.TIPOLANCAMENTO (IDTIPOLANCAMENTO, DESCRICAO) VALUES (3, 'Acúmulo');
INSERT INTO milhas.TIPOLANCAMENTO (IDTIPOLANCAMENTO, DESCRICAO) VALUES (4, 'Resgate');

-- Parceiro #####

CREATE TABLE IF NOT EXISTS milhas.PARCEIRO (
   idparceiro INT,
   descricao VARCHAR(100) NOT NULL,
   PRIMARY KEY (idparceiro)
);

DELETE FROM milhas.PARCEIRO;

INSERT INTO milhas.PARCEIRO (IDPARCEIRO, DESCRICAO) VALUES (1, 'Bem-te-vi Airlines');
INSERT INTO milhas.PARCEIRO (IDPARCEIRO, DESCRICAO) VALUES (2, 'Repimboca Rent a car');


-- Produto #####

CREATE TABLE IF NOT EXISTS milhas.PRODUTO (
   idproduto INT,
   idparceiro INT,
   valor INT NOT NULL,
   descricao VARCHAR(100) NOT NULL,
   PRIMARY KEY (idproduto),
   foreign key (idparceiro) references milhas.PARCEIRO(idparceiro)
);

DELETE FROM milhas.PRODUTO;

INSERT INTO milhas.PRODUTO (IDPRODUTO, IDPARCEIRO, VALOR, DESCRICAO) VALUES (1, 1, 1500, 'Passagem aérea nacional');
INSERT INTO milhas.PRODUTO (IDPRODUTO, IDPARCEIRO, VALOR, DESCRICAO) VALUES (2, 1, 3500, 'Passagem aérea internacional');
INSERT INTO milhas.PRODUTO (IDPRODUTO, IDPARCEIRO, VALOR, DESCRICAO) VALUES (3, 2, 200, 'Diária de carro básico');
INSERT INTO milhas.PRODUTO (IDPRODUTO, IDPARCEIRO, VALOR, DESCRICAO) VALUES (4, 2, 400, 'Diária de carro premium');

-- Lançamento #####

CREATE TABLE IF NOT EXISTS milhas.LANCAMENTO (
   idlancamento INT auto_increment,
   idpessoa INT NOT NULL,
   idtipolancamento INT NOT NULL,
   idparceiro INT,
   idproduto INT,
   valor INT NOT NULL,
   descricao VARCHAR(200),
   data DATE NOT NULL,
   PRIMARY KEY (idlancamento),
   foreign key (idpessoa) references milhas.PESSOA(idpessoa),
   foreign key (idtipolancamento) references milhas.TIPOLANCAMENTO(idtipolancamento),
   foreign key (idparceiro) references milhas.PARCEIRO(idparceiro)
);

DELETE FROM milhas.LANCAMENTO;

INSERT INTO milhas.LANCAMENTO (IDPESSOA, IDTIPOLANCAMENTO, IDPARCEIRO, VALOR, DATA) 
	VALUES (SELECT IDPESSOA FROM milhas.PESSOA WHERE login = 'huguinho', 1, NULL, 10000, '2022-02-01');
INSERT INTO milhas.LANCAMENTO (IDPESSOA, IDTIPOLANCAMENTO, IDPARCEIRO, VALOR, DATA) 
	VALUES (SELECT IDPESSOA FROM milhas.PESSOA WHERE login = 'zezinho', 1, NULL, 10000, '2022-02-02');