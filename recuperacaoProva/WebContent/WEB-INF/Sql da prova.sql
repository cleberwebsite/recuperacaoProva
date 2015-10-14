create database medicacao;

use medicacao;

create table user(
    id int(11)unsigned not null auto_increment,
    nome varchar(80) not null,
	dosagem float(6.2) not null,
	intervalo varchar(80) not null,
	duracao varchar(80) not null,
    primary key(id)
);