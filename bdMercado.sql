drop database bdMercado;
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

create table notaEntrada(
	noE_id int not null auto_increment primary key,
    noE_data varchar(10) not null,
    noE_valorTotal decimal (10,2),
    noE_notaFiscal varchar(20) unique not null,
    for_CNPJ varchar(50),
    FOREIGN KEY (for_CNPJ) REFERENCES fornecedor(for_CNPJ)
);

create table notaSaida(
	noS_id int not null auto_increment primary key,
    noS_data varchar(10) not null,
    noS_valorTotal decimal (10,2),
    noS_notaFiscal varchar(20) unique not null,
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

select day(sysdate()) dia, month(sysdate()) mes, year(sysdate()) ano;

insert into categoria (cat_nome,	cat_descricao) values
("Cereais", "Sementes no geral"),
("Carne", "Carnes no geral"),
("Frutas", "Frutas no geral"),
("Paata de dentes","Pasta de dentes no geral");

insert into produto ( pro_nome, pro_preco, pro_codigoBarras, pro_estoque, cat_id) values
("Uva", 					10.9, "999", 50, 3),
("Maçã", 					 5.5, "888", 70, 3),
("Colgate Triple Dent", 	 2.5, "664", 99, 4),
("Cloese Up", 				1.39, "879", 77, 4),
("Froot Loops", 				15.7, "852", 25, 1),
("Aveia", 					13.9, "363", 50, 1);

insert into fornecedor(for_CNPJ, for_nome, for_nomeFantasia) values
("111", "Kellogg Company", "Kellanova"),
("222", "Frutas $ CIA", "F&C"),
("333", "Colgate Company", "Colgate"),
("444", "Dr. August Oetker KG", "Dr. Oetker");

insert into cliente(cli_CPF, cli_nome, cli_email) values
("555", "Júlio", "julio@gmail.com"),
("556", "João", "joao@gmail.com"),
("557", "Maria", "maria@gmail.com");


select * from cliente;
select * from categoria;
select * from produto;
select * from fornecedor;
select * from notaEntrada;
select * from notaSaida;

