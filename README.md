# API de Tarefas

## Descrição

Esta API foi desenvolvida como parte de um projeto para praticar os conceitos de arquitetura limpa. Trata-se de uma simples API de tarefas. Não é um CRUD completo, apenas é possível inserir novas tarefas e resgatá-las do banco de dados. Esta aplicação não possui também todas as boas práticas de uma API REST, sendo seu foco principal, então, a aplicação dos conceitos do modelo de Arquitetura Limpa.

## Tecnologias Usadas

- Java 17
- Spring Boot
- H2 Database

## Requisições

### Criar uma nova tarefa

- **Método HTTP**: POST
- **Endpoint**: /tasks
- **Descrição**: Cria uma nova tarefa com os dados fornecidos no corpo da requisição.

Corpo da requisição (JSON):

```json
{
  "title": "Tarefa importante",
  "description": "Esta é uma tarefa muito importante que precisa ser concluída hoje.",
  "creationDate": "2024-02-10",
  "dueDate": "2024-02-10",
  "taskCategory": "WORK"
}
```

### Listar todas as tarefas

- **Método HTTP**: GET
- **Endpoint**: /tasks
- **Descrição**: Retorna uma lista de todas as tarefas cadastradas.

### Buscar uma tarefa pelo nome

- **Método HTTP**: GET
- **Endpoint**: /tasks/{title}
- **Descrição**: Retorna uma tarefa com o titulo fornecido, caso haja.