create database bdMercado;
use bdMercado;


create table categoria(
	cat_id int not null auto_increment primary key,
	cat_nome varchar(30) not null,
	car_descricao varchar(100) 
);

create table produto(
	pro_id int not null auto_increment primary key,
    pro_nome varchar(30) not null,
    pro_preco decimal(6,2) not null,
    pro_codigoBarras varchar(20) not null,
    cat_id int,
    FOREIGN KEY (cat_id) REFERENCES categoria(cat_id)
);

create table fornecedores(
	for_CPNJ varchar(50) not null primary key,
    for_nome varchar(50) not null unique,
    for_nomeFantasia varchar(50) not null
);

create table cliente(
	cli_CPF varchar(50) not null primary key,
    cli_nome varchar(50) not null,
    cli_email varchar(50) not null unique
);

