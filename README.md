# M-tech To-Do List

API REST desenvolvida com **Java e Spring Boot** como projeto de estudo e consolidação de fundamentos de desenvolvimento Backend.

O projeto foi criado após a implementação de uma API REST mais completa, disponível no repositório [`minha-primeira-spring-api`](https://github.com/Monteirix/minha-primeira-spring-api), com o objetivo de reforçar conceitos de **Spring Boot, arquitetura em camadas, JPA/Hibernate, persistência de dados, injeção de dependências e desenvolvimento de APIs REST**.

A escolha por um domínio simples de tarefas foi intencional: reduzir a complexidade do negócio para concentrar os estudos na qualidade da estrutura e da implementação.

---

## 🎯 Objetivo de aprendizado

Este projeto representa uma etapa de **consolidação no aprendizado de Spring Boot**.

A proposta não é apresentar a aplicação como um sistema definitivo de gerenciamento de tarefas, mas como um exercício prático para reforçar conceitos fundamentais de Backend.

A evolução pode ser resumida da seguinte forma:

```text
API anterior
     ↓
Aprendizado dos fundamentos
     ↓
M-tech To-Do List
     ↓
Consolidação + melhoria das práticas
     ↓
Próximos projetos mais complexos
```

Ao reduzir o domínio para uma única entidade principal, o projeto permite concentrar a atenção em conceitos como:

* Arquitetura em camadas
* Injeção de dependências
* Spring Data JPA
* Persistência com Hibernate
* APIs REST
* Tratamento de respostas HTTP
* Uso de `Optional`
* Organização de packages
* Configuração de ambientes com Profiles
* Separação de responsabilidades

---

## 🚀 Evolução em relação à API anterior

A [`minha-primeira-spring-api`](https://github.com/Monteirix/minha-primeira-spring-api) foi utilizada como uma etapa mais ampla de aprendizado, trabalhando com um domínio composto por usuários, produtos, categorias, pedidos, itens de pedidos e pagamentos, além de relacionamentos JPA, repositories, services, resources/controllers, configuração de dados e tratamento de exceções.

A M-tech To-Do List parte desse conhecimento e reduz propositalmente a complexidade do domínio.

### 1. Arquitetura em camadas

A estrutura principal continua seguindo o fluxo:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA / Hibernate
    ↓
H2 Database
```

Cada camada possui uma responsabilidade específica:

| Camada         | Responsabilidade                                            |
| -------------- | ----------------------------------------------------------- |
| **Controller** | Receber requisições HTTP e disponibilizar os endpoints REST |
| **Service**    | Intermediar as operações e concentrar a lógica da aplicação |
| **Repository** | Acessar os dados através do Spring Data JPA                 |
| **Entity**     | Representar o modelo persistido no banco de dados           |
| **Config**     | Inicializar dados de exemplo durante o profile de teste     |

Essa separação permite que cada parte da aplicação tenha uma responsabilidade clara, evitando concentrar toda a lógica em uma única classe.

### 2. Redução intencional da complexidade

Enquanto o projeto anterior trabalha com diferentes entidades e relacionamentos, a To-Do List possui uma única entidade principal:

```text
Task
```

Ela contém:

* `id`
* `title`
* `description`
* `completed`

A simplificação não representa uma redução do objetivo de aprendizado. Pelo contrário, ela permite concentrar os estudos na estrutura da aplicação e nas práticas utilizadas para construí-la.

### 3. Organização dos packages

O package base da aplicação é:

```text
com.m2tech.to_do_List
```

A partir dele estão organizados os principais componentes:

```text
Config
controller
entities
repositories
services
```

A classe principal `ToDoListApplication` também está localizada nesse package base.

Essa organização é importante porque o `@SpringBootApplication` realiza o component scanning a partir do package onde a aplicação está localizada, permitindo que os componentes da aplicação sejam encontrados automaticamente.

---

## 🏗️ Arquitetura

```text
┌──────────────┐
│    Cliente   │
└──────┬───────┘
       │ HTTP
       ▼
┌──────────────────┐
│  TaskController  │
└────────┬─────────┘
         │
         ▼
┌──────────────────┐
│    TaskService   │
└────────┬─────────┘
         │
         ▼
┌──────────────────┐
│  TaskRepository  │
└────────┬─────────┘
         │
         ▼
┌──────────────────┐
│  JPA / Hibernate │
└────────┬─────────┘
         │
         ▼
┌──────────────────┐
│   H2 Database    │
└──────────────────┘
```

O fluxo básico da aplicação ocorre da seguinte maneira:

1. O cliente realiza uma requisição HTTP.
2. O `TaskController` recebe a requisição.
3. O `TaskController` delega a operação para o `TaskService`.
4. O `TaskService` utiliza o `TaskRepository`.
5. O Spring Data JPA realiza a comunicação com o Hibernate.
6. O Hibernate persiste ou consulta os dados no H2.

---

## 🛠️ Tecnologias

As tecnologias abaixo foram identificadas diretamente no `pom.xml` atual do projeto.

| Tecnologia            | Finalidade                                    |
| --------------------- | --------------------------------------------- |
| **Java 23**           | Linguagem utilizada no desenvolvimento        |
| **Spring Boot 4.1.0** | Base da aplicação                             |
| **Spring Web MVC**    | Construção da API REST e endpoints HTTP       |
| **Spring Data JPA**   | Abstração para acesso e persistência de dados |
| **Hibernate / JPA**   | Mapeamento objeto-relacional                  |
| **H2 Database**       | Banco de dados em memória                     |
| **H2 Console**        | Interface para visualizar e consultar o banco |
| **Lombok**            | Redução de código repetitivo na entidade      |
| **Maven**             | Gerenciamento de dependências e build         |

O projeto também possui **Maven Wrapper**, através dos arquivos `mvnw` e `mvnw.cmd`, permitindo executar o Maven sem depender de uma instalação global específica.

---

## 📦 Estrutura do projeto

A estrutura atual do código é:

```text
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── m2tech/
│   │           └── to_do_List/
│   │               ├── Config/
│   │               │   └── TesteConfig.java
│   │               │
│   │               ├── controller/
│   │               │   └── TaskController.java
│   │               │
│   │               ├── entities/
│   │               │   └── Task.java
│   │               │
│   │               ├── repositories/
│   │               │   └── TaskRepository.java
│   │               │
│   │               ├── services/
│   │               │   └── TaskService.java
│   │               │
│   │               └── ToDoListApplication.java
│   │
│   └── resources/
│       ├── application.properties
│       └── application-test.properties
│
└── test/
    └── java/
        └── com/
            └── m2tech/
                └── to_do_List/
                    └── ToDoListApplicationTests.java
```

Essa estrutura corresponde aos arquivos atualmente presentes no repositório.

---

## 📋 Modelo `Task`

A entidade principal da aplicação é `Task`.

```java
@Entity
@Data
@Table(name = "tb_task")
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
}
```

A entidade é mapeada para a tabela:

```text
tb_task
```

O ID é gerado automaticamente pelo banco através da estratégia `IDENTITY`. O Lombok é utilizado para gerar métodos e construtores necessários à classe.

---

## 🔌 Endpoints

A API disponibiliza os seguintes endpoints:

| Método   | Endpoint         | Descrição                     | Resposta esperada                  |
| -------- | ---------------- | ----------------------------- | ---------------------------------- |
| `GET`    | `/api/task`      | Retorna todas as tarefas      | `200 OK`                           |
| `GET`    | `/api/task/{id}` | Retorna uma tarefa pelo ID    | `200 OK` / `404 NOT FOUND`         |
| `POST`   | `/api/task`      | Cria uma nova tarefa          | `201 CREATED`                      |
| `PUT`    | `/api/task/{id}` | Atualiza uma tarefa existente | `200 OK` / `404 NOT FOUND`         |
| `DELETE` | `/api/task/{id}` | Remove uma tarefa             | `204 NO CONTENT` / `404 NOT FOUND` |

Os endpoints estão concentrados no `TaskController`, utilizando `/api/task` como rota base.

---

## 🧠 Boas práticas e melhorias de implementação

### Injeção de dependências por construtor

O projeto utiliza **injeção de dependências por construtor**.

No `TaskService`:

```java
private final TaskRepository taskRepository;

public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
}
```

E no `TaskController`:

```java
private final TaskService service;

public TaskController(TaskService service) {
    this.service = service;
}
```

Essa abordagem é preferível à injeção diretamente no atributo, como:

```java
@Autowired
private TaskRepository taskRepository;
```

ou:

```java
@Autowired
private TaskService service;
```

A injeção por construtor apresenta algumas vantagens:

* torna as dependências explícitas;
* permite utilizar `final` nas dependências;
* facilita a criação de testes;
* reduz o acoplamento direto da classe com o mecanismo de injeção;
* deixa a estrutura da classe mais clara e previsível.

Além disso, uma classe que depende de determinados componentes deixa essas dependências visíveis através do próprio construtor.

A implementação atual utiliza essa abordagem tanto no `TaskService` quanto no `TaskController`.

### Separação de responsabilidades

A aplicação mantém responsabilidades bem definidas:

**Controller**

Responsável pela camada HTTP e pelos endpoints REST.

**Service**

Responsável por intermediar as operações entre o Controller e o Repository.

**Repository**

Responsável pelo acesso aos dados através do Spring Data JPA.

**Entity**

Representa o objeto persistido no banco.

**Config**

Responsável pela inicialização dos dados de exemplo quando o profile `test` está ativo.

### Uso de `Optional`

O projeto utiliza `Optional<Task>` nas operações que podem não encontrar uma tarefa.

Por exemplo:

```java
public Optional<Task> findById(Long id)
```

Isso permite representar explicitamente a possibilidade de uma busca não retornar resultado.

No Controller, o `Optional` é utilizado para transformar a existência da tarefa em uma resposta HTTP adequada:

```text
Task encontrada
    ↓
200 OK

Task não encontrada
    ↓
404 NOT FOUND
```

A mesma abordagem é utilizada na atualização de tarefas.

---

## 💾 Persistência

A aplicação utiliza:

* **Spring Data JPA**
* **JPA/Hibernate**
* **H2 Database**

O H2 é utilizado como banco de dados **em memória**, adequado para desenvolvimento e experimentação.

A configuração atual utiliza:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
```

e:

```properties
spring.jpa.hibernate.ddl-auto=create
```

Com isso, o Hibernate cria a estrutura do banco a partir das entidades JPA durante a inicialização da aplicação.

A entidade `Task` define explicitamente a tabela:

```text
tb_task
```

através de:

```java
@Table(name = "tb_task")
```

Como o banco utilizado é `jdbc:h2:mem:testdb`, os dados ficam armazenados em memória e **não são persistidos após o encerramento da aplicação**.

---

## 🖥️ H2 Console

O H2 Console está habilitado no profile `test`.

A configuração atual define:

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Após iniciar a aplicação, o console pode ser acessado em:

```text
http://localhost:8080/h2-console
```

Utilize a seguinte configuração:

```text
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```

---

## 🧪 Dados de teste

A classe `TesteConfig` é responsável pela inicialização dos dados de exemplo.

Ela utiliza:

```java
@Configuration
@Profile("test")
```

e implementa:

```java
CommandLineRunner
```

Dessa forma, o método `run()` é executado durante a inicialização da aplicação quando o profile `test` está ativo.

A classe recebe `TaskRepository` através de injeção por construtor e utiliza `saveAll()` para persistir as tarefas iniciais.

Atualmente são criadas duas tarefas de exemplo durante a inicialização.

O profile `test` já está definido como ativo no `application.properties`:

```properties
spring.profiles.active=test
```

---

## 📡 Exemplos de utilização

### Criar uma tarefa

```http
POST /api/task
Content-Type: application/json
```

```json
{
    "title": "Aprender Spring Boot",
    "description": "Estudar Spring Boot e JPA",
    "completed": false
}
```

Resposta esperada:

```http
201 CREATED
```

### Listar tarefas

```http
GET /api/task
```

Resposta:

```json
[
    {
        "id": 1,
        "title": "Aprender Spring Boot",
        "description": "Estudar Spring Boot e JPA",
        "completed": false
    }
]
```

### Buscar uma tarefa

```http
GET /api/task/1
```

Caso a tarefa exista:

```http
200 OK
```

Caso não exista:

```http
404 NOT FOUND
```

### Atualizar uma tarefa

```http
PUT /api/task/1
Content-Type: application/json
```

```json
{
    "title": "Aprender Spring Boot",
    "description": "Estudar Spring Boot, JPA e arquitetura em camadas",
    "completed": true
}
```

Resposta esperada:

```http
200 OK
```

### Excluir uma tarefa

```http
DELETE /api/task/1
```

Caso a tarefa exista:

```http
204 NO CONTENT
```

Caso não exista:

```http
404 NOT FOUND
```

---

## ▶️ Como executar

### Pré-requisitos

Para executar o projeto, tenha instalado:

* **Java 23**
* Git

O projeto utiliza Java 23 definido no `pom.xml`.

O Maven não precisa necessariamente estar instalado globalmente, pois o repositório possui Maven Wrapper.

### 1. Clone o repositório

```bash
git clone https://github.com/Monteirix/M-tech-todoList.git
```

### 2. Acesse o projeto

```bash
cd M-tech-todoList
```

### 3. Execute a aplicação

No Windows:

```bash
mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

Também é possível utilizar:

```bash
mvnw.cmd clean package
```

e executar o `.jar` gerado pelo Maven.

### 4. Acesse a API

A aplicação utiliza a porta padrão do Spring Boot:

```text
http://localhost:8080
```

A API está disponível em:

```text
http://localhost:8080/api/task
```

O H2 Console está disponível em:

```text
http://localhost:8080/h2-console
```

---

## 🧪 Testes

O projeto possui a estrutura padrão de testes do Spring Boot e atualmente contém um teste de carregamento do contexto:

```java
@SpringBootTest
class ToDoListApplicationTests {

    @Test
    void contextLoads() {
    }
}
```

Esse teste verifica se o contexto da aplicação consegue ser inicializado corretamente.

Isso não significa que a aplicação possua atualmente uma suíte completa de testes unitários ou de integração para os endpoints.

---

## 🔮 Próximos passos

A aplicação atual mantém um escopo propositalmente simples. Algumas possíveis evoluções para etapas futuras seriam:

* [ ] Adicionar testes unitários para a camada de Service
* [ ] Adicionar testes de integração para os endpoints
* [ ] Implementar validação dos dados recebidos
* [ ] Introduzir DTOs para separar o modelo da API da entidade JPA
* [ ] Implementar tratamento global de exceções
* [ ] Adicionar documentação OpenAPI/Swagger
* [ ] Substituir o H2 por um banco de dados externo
* [ ] Implementar autenticação e autorização

Esses itens representam **possíveis evoluções futuras** e não fazem parte da implementação atual.

---

## 📚 Conclusão

A M-tech To-Do List foi desenvolvida como uma etapa prática de evolução no aprendizado de Backend com Java e Spring Boot.

Em comparação com a API anterior, o domínio foi reduzido de forma proposital para que o foco pudesse sair da complexidade do negócio e se concentrar na construção de uma aplicação Spring organizada, com separação de responsabilidades, persistência JPA, injeção de dependências e comunicação através de uma API REST.

O objetivo principal deste projeto não é a complexidade funcional, mas a **consolidação dos fundamentos que servirão de base para aplicações maiores e mais completas no futuro**.
