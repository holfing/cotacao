# operation project

Contexto
Ao se passar uma data para nosso sistema, queremos saber as cotações do dólar na data passada e do dia útil anterior.
Caso se passe uma data inválida ou uma data de um dia não útil, mensagens de erro deverão ser retornadas usando os corretos status do protocolo HTTP.


Atividades do desenvolvimento
- Desenvolver em Java/REST (obrigatório).
- Docker/Docker compose nos back-ends (obrigatório).
- API deverá ser documentada no Swagger (obrigatório).
- Desejável utilizar o framework Quarkus.
- Os dados trafegados dentro dos back-ends deverão utilizar o formato JSON (obrigatório).
- O código deve ser commitado no github ou gitlab de modo público.
- Testes automatizados efetivos
- Não é obrigatório a criação do front-end. Pode ser utilizado o Swagger para os testes.


Estruturação da aplicação
A aplicação deve ser dividida em dois sub-aplicativos/microsserviços:
a) Microservice de consumo da API pública do Banco Central.
Retorno: Data e cotação.
b) Microservice de consumo da API provida pelo outro microservice.
Retorno:
- Deverá consumir a API do [Microservice A] e retornar a cotação da data informada e do dia útil anterior.
- O retorno deve ter os campos:
Valor da cotação da data informada, data da cotação informada, valor da cotação do dia útil anterior, data da cotação do dia útil anterior.

