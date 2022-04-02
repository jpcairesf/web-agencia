# Web Agência API

API REST em Java com Spring.

Realiza cadastro e consulta de passageiros e voos, além da compra de passagens. Os passageiros são validados por CPF e as passagens são compradas apenas para voos válidos e cadastrados no sistema também.

# Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [ ] Testes na camada de serviço
- [ ] Testes de integração
- [ ] Autenticação e login

# ☕ Utilização

O deploy da aplicação foi feito no Heroku. Acesse https://web-agencia-api-rest.herokuapp.com/ para utilizar.

## /home

**Request Methods**
```
GET /
return list of voo where data is today
```
**Response** - Exemplo de voos em JSON
```
{
}
```

## /passagem

**Request Methods**
```
GET /
return list of passagem

GET /{id}
return passagem

GET /passageiro/{cpf}
return list of passagem

POST{RequestBody} /
return passagem

PUT{RequestBody} /{id}
return passagem

DELETE /{id}
return void
```
**Request Body** - Exemplo em JSON
```
{
  'cpfPassageiro': '100.000.000-00',
  'vooId': 1,
  'assento': 10,
  'valor': 100.00
}
```
**Response** - Exemplo de passagem em JSON
```
{
  'id': 1,
  'cpfPassageiro': '100.000.000-00',
  'vooId': 1,
  'assento': 10,
  'valor': 100.00
}
```

## /passageiro

**Request Methods**
```
GET /
return list of passageiro

GET /{cpf}
return passageiro

POST{RequestBody} /
return passageiro

PUT{RequestBody} /{cpf}
return passageiro

DELETE /{cpf}
return void
```
**Request Body** - Exemplo de passageiro em JSON
```
{
  'nome': 'exemplo',
  'cpf': '100.000.000-00',
  'telefone': '71 99999-9999',
  'endereco': 'rua exemplo, 1',
  'dataNascimento: '1990-01-01'
}
```
**Response** - Exemplo em JSON
```
{
  'nome': 'exemplo',
  'cpf': '100.000.000-00',
  'telefone': '71 99999-9999',
  'endereco': 'rua exemplo, 1',
  'dataNascimento: '1990-01-01'
}
```

## /voo

**Request Methods**
```
GET /
return list of voo

GET /{id}
return voo

GET /data/{yyyy-MM-dd}
return list of voo

POST{RequestBody} /
return voo

PUT{RequestBody} /{id}
return voo

DELETE /{id}
return void
```
**Request Body** - Exemplo de voo em JSON
```
{
  'localPartida': 'string',
	'localChegada': 'string',
	'horaPartida': '12:00:00',
	'horaChegada': '16:00:00',
	'data': '2022-03-13'
}
```
**Response** - Exemplo em JSON
```
{
  'id': 1,
  'localPartida': 'string',
	'localChegada': 'string',
	'horaPartida': '12:00:00',
	'horaChegada': '16:00:00',
	'data': '2022-03-13'
}
```
