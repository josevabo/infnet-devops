# Projeto infnet-devops
Projeto de conclusão da disciplina Integração contínua e Devops

## Aplicação
A aplicação é um CRUD simples construído com Spring Boot para cadastro de médicos, junto com extensões que permitem monitoramento, log centralizado e deploy automatizado.

### Início rápido
Para baixar e executar a aplicação basta executar o comando abaixo na pasta raiz do projeto:
```
mvn spring-boot:run
```

## Objetivos atingidos no projeto

* Exportação de logs para Papeertrail
* Métricas e sua exportação para srvidor externo de tracing para zipkin
* Informações sobre estado e health da aplicação com spring-actuator
* Criação de infraestrutura automatizada com Terraform
* Build e Deploy automatizados utilizando github actions
* Execução de testes automatizados com junit

### Evidências dos objetivos atingidos
AS evidências dos objetivos atingidos no projeto se encontram na pasta images/, separados por diretórios de cada tema.