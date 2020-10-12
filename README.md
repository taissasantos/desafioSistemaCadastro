
API RESTful para Sistema de Usuários de Carros

* Java 
* Spring-boot
* Spring-data
* H2 Database
* Angular

Utilização de melhores práticas e frameworks disponíveis para implementação de api.

## Repositorio

https://github.com/dmarsili/pitang-api

## Install

**Build Api**

mvn clean install

mvn package spring-boot:repackage


**Build Front (Angular)**

npm install

ng build --prod

**Execution Front**

ng serve

LocalHost
http://localhost:4200/


## Story Users
UserStory_001 - definição de arquitetura e back end
UserStory_002 - criação de camadas estruturais java - back end
UserStory_003 - definição de arquitetura front end
UserStory_004 - criação do front - end 
UserStory_005 - preparação de deploy 

SOLUÇÃO:

Para o back end, conforme descrição do desafio, foram utilizadas as seguintes tecnologias:

Back-end:
Maven project
Spring boot - para o desenvolvimento das camadas REST.
	implementado as camadas de model, repository e rest controller
H2- para a persistêcia com JPA/Hibernate

Front-end:
Utilização do framework angular 8
Utilização do Bootstrap
Foram criados 2 modulos (carros e usuario), com arquivo de services, routing module e app module a parte.
Dentro do modulos de carros e usuarios, encontram-se dois componentes: listas e formulários, o primeiro exibe em tela duas funções: List e Delete, na mesma tela há um botão que redireciona o usuário para a tela de cadastro ou edição, onde foram utilizadas as funções post e put.
Não foram implementadas autenticações.





## EndPoints

createUser -> [POST] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users

login -> [POST] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/signin

createCar -> [POST] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/cars

getUsers -> [GET] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users

getUserById -> [GET] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users/1

getCars -> [GET] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/cars

getCar -> [GET] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users/1

updateUser -> [PUT] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users/1

deleteUser -> [DELETE] http://ec2-3-16-43-135.us-east-2.compute.amazonaws.com:8080/api/users/1


