# ToDo List 
Criando um ToDo List com Java 17 e Spring.

## Dia 1
Configurado dependências do projeto.
Criando tabela no H2 Database.
Encontrado erro ao tentar acessar H2 console.
> http://localhost:8080/h2/ Whitelabel Error Page This application has no explicit mapping for /error, so you are seeing this as a fallback.

## Dia 2
Solucionado o "Whitelabel Error" ao tentar acessar o H2 console. O problema foi na linha "spring.h2.console.enabled=true" na applications.properties, funcionou quando troquei o "=" por ":".
Criado método na TaskService para criar as tasks e também método para listá-las. 
Feito o create e read do CRUD.

### Tarefas para o próximo dia
[ ] Fazer o update.
[ ] Fazer o delete.
