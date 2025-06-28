create database bdMercado;
use bdMercado;


create table categoria(
	cat_id int not null auto_increment primary key,
	cat_nome varchar(30) not null,
	cat_descricao varchar(255) 
);

-- alter table categoria
-- DROP car_descricao;

-- alter table categoria
-- add cat_descricao varchar(255);

create table produto(
	pro_id int not null auto_increment primary key,
    pro_nome varchar(30) not null,
    pro_preco decimal(6,2) not null,
    pro_codigoBarras varchar(20) not null,
    pro_estoque int not null,
    cat_id int,
    FOREIGN KEY (cat_id) REFERENCES categoria(cat_id)
);

create table fornecedor(
	for_CNPJ varchar(50) not null primary key,
    for_nome varchar(50) not null unique,
    for_nomeFantasia varchar(50) not null
);

create table cliente(
	cli_CPF varchar(50) not null primary key,
    cli_nome varchar(50) not null,
    cli_email varchar(50) not null unique
);


select * from cliente;
select * from categoria;
select * from produto;
select * from fornecedor;

create table notaEntrada(
	noE_id int not null auto_increment primary key,
    noE_data date not null,
    noE_valorTotal decimal (10,2),
    noE_notaFiscal varchar(20) unique,
    for_CNPJ varchar(50),
    FOREIGN KEY (for_CNPJ) REFERENCES fornecedor(for_CNPJ)
);

create table notaSaida(
	noS_id int not null auto_increment primary key,
    noS_data date not null,
    noS_valorTotal decimal (10,2),
    noS_notaFiscal varchar(20) unique,
    cli_CPF varchar(50),
    FOREIGN KEY (cli_CPF) REFERENCES cliente(cli_CPF)
);

create table notaEntradaProduto(
	nEP_id int not null auto_increment primary key,
    nEP_quantidade int not null,
    nEP_valorUnitario decimal (10,2) not null,
    nEP_valorTotal decimal (10,2) not null,
    pro_id int,
    noE_id int,     
    FOREIGN KEY (pro_id) REFERENCES produto(pro_id),
    FOREIGN KEY (noE_id) REFERENCES notaEntrada(noE_id)
);

create table notaSaidaProduto(
	nSP_id int not null auto_increment primary key,
    nSP_quantidade int not null,
    nSP_valorUnitario decimal (10,2) not null,
    nSP_valorTotal decimal (10,2) not null,
    pro_id int,
    noS_id int,     
    FOREIGN KEY (pro_id) REFERENCES produto(pro_id),
    FOREIGN KEY (noS_id) REFERENCES notaSaida(noS_id)
);

