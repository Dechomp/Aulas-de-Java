create database bdMercado;
use bdMercado;


create table categoria(
	cat_id int not null auto_increment,
	cat_nome varchar(25) not null unique,
	car_descricao varchar(100) 
);

create table produto(
	pro_id int not null auto_increment,
    pro_nome varchar(30) not null,
    pro_preco decimal(6,2) not null,
    pro_codigoBarras varchar(20) not null,
    cat_id int,
    FOREIGN KEY (cat_id) REFERENCES categoria(cat_id)
);

