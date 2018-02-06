# Maisvida Java

Api REST Java + Spring boot + Spring Data JPA + Oauth2 + MongoDB

Obs: Spring Data JPA está sendo usado apenas para a autenticação de usuário juntamente com o Oauth2.

Métodos:
  - GET - /allMedicos
  - GET - /getMedico/{id}
  - PUT - /saveMedico
  - DELETE - /deleteMedico/{id}

### MongoDB

Utilizo o MongoDB para pessistir os dados dos médicos.

Configurações:
  - Host - 127.0.0.1
  - Port - 27017
  - Database - test

Obs: As configurações já estão aplicadas no arquivo application.properties da api, necessitando apenas da instalação do MongoDB na máquina local.