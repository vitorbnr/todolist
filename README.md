<h1 align="center">
  ✅ TODO List API
</h1>

<p align="center">
  Uma API RESTful completa para gerenciamento de tarefas, construída com as melhores práticas do ecossistema Spring.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-3.3.1-6DB33F?style=for-the-badge&logo=springboot" alt="Spring Boot Version" />
  <img src="https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk" alt="Java Version" />
  <img src="https://img.shields.io/badge/Database-MySQL-blue?style=for-the-badge&logo=mysql" alt="Database" />
</p>

---

## 📜 Sobre o Projeto

Esta é uma API para gerenciar uma lista de tarefas (TODO list), permitindo criar, listar, atualizar e deletar tarefas. O projeto foi desenvolvido seguindo as melhores práticas de desenvolvimento backend com Java e Spring.

## ✨ Features

-   **CRUD Completo:** Funcionalidades para Criar, Ler, Atualizar e Deletar tarefas.
-   **Validação de Dados:** Garante que os dados de entrada (ex: nome da tarefa) sejam válidos.
-   **Ordenação Inteligente:** A listagem de tarefas é ordenada por prioridade.
-   **API Documentada:** Documentação interativa e automática com **Swagger (OpenAPI 3)**.
-   **Testes de Integração:** Suíte de testes robusta para garantir a qualidade e o funcionamento da API.

## 🚀 Tecnologias Utilizadas

Este projeto foi construído com um conjunto de tecnologias modernas e amplamente utilizadas no mercado:

-   **Backend:**
    -   [**Spring Boot**](https://spring.io/projects/spring-boot): Framework principal para criação da aplicação.
    -   [**Spring Web (MVC)**](https://docs.spring.io/spring-framework/reference/web/webmvc.html): Para a construção dos endpoints REST.
    -   [**Spring Data JPA**](https://spring.io/projects/spring-data-jpa): Para a persistência de dados de forma simplificada.
    -   [**Project Lombok**](https://projectlombok.org/): Para reduzir o código boilerplate (getters, setters, construtores).
-   **Banco de Dados:**
    -   [**MySQL**](https://dev.mysql.com/downloads/): Banco de dados relacional utilizado no projeto.
-   **Testes:**
    -   [**Spring Boot Test**](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing): Ferramentas de teste integradas.
    -   [**JUnit 5**](https://junit.org/junit5/): Framework para a escrita dos testes.
    -   [**WebTestClient**](https://docs.spring.io/spring-framework/reference/testing/webtestclient.html): Para realizar testes de integração nos endpoints da API.
-   **Documentação:**
    -   [**SpringDoc OpenAPI**](https://springdoc.org/): Geração automática da documentação Swagger UI.
-   **Build:**
    -   [**Maven**](https://maven.apache.org/): Gerenciador de dependências e build do projeto.

---

## 🏁 Começando

Siga os passos abaixo para executar o projeto na sua máquina local.

### Pré-requisitos

-   [**Java (JDK)**](https://www.oracle.com/java/technologies/downloads/) - Versão 17.
-   [**Maven**](https://maven.apache.org/download.cgi) - Versão 3.8 ou superior.
-   [**Git**](https://git-scm.com/downloads) para clonar o repositório.
-   [**MySQL Server**](https://dev.mysql.com/downloads/) instalado e rodando.
-   Um cliente de banco de dados como [DBeaver](https://dbeaver.io/) ou [MySQL Workbench](https://www.mysql.com/products/workbench/).

### Instalação e Execução

1.  **Clone o repositório:**
    ```sh
    git clone https://github.com/vitorbnr/todolist.git
    cd todolist
    ```

2.  **Configure o Banco de Dados:**
    * **Crie um banco de dados vazio** no seu MySQL.
        ```sql
        CREATE DATABASE todolist;
        ```
    * **Configure as credenciais** no arquivo `src/main/resources/application.properties`. Preencha com os dados do seu banco MySQL.

        ```properties
        # Configuração para MySQL
        spring.datasource.url=jdbc:mysql://localhost:3306/todolist
        spring.datasource.username=seu_usuario_mysql
        spring.datasource.password=sua_senha_mysql
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

        # Propriedades úteis para desenvolvimento
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        ```

3.  **Execute a Aplicação:**
    * **Opção 1: Pela sua IDE (Recomendado)**
        * Abra o projeto na sua IDE (IntelliJ, Eclipse, etc.).
        * Encontre a classe `TodolistApplication.java` e execute o método `main`.

    * **Opção 2: Pela linha de comando com Maven**
        ```sh
        mvn spring-boot:run
        ```
    * **Opção 3: Empacotando e executando o .jar**
        ```sh
        # Empacota o projeto
        mvn clean package

        # Executa o arquivo .jar gerado
        java -jar target/todolist-0.0.1-SNAPSHOT.jar
        ```

A aplicação estará rodando em `http://localhost:8080`.

---

## 🧪 Testando o Projeto

O projeto possui uma suíte de testes de integração para garantir a qualidade do código. Para executá-los, utilize o seguinte comando Maven:

```sh
mvn test

Os testes utilizam uma abordagem programática com @BeforeEach para preparar um ambiente limpo para cada teste, garantindo que sejam independentes e previsíveis.

📖 Documentação da API (Swagger)
A documentação completa e interativa da API está disponível via Swagger UI. Após iniciar a aplicação, acesse o seguinte endereço no seu navegador:

http://localhost:8080/swagger-ui.html

Lá, você poderá visualizar todos os endpoints, seus parâmetros, e até mesmo testá-los diretamente pelo navegador.

🕹️ Exemplos de Uso (Postman)
Aqui estão exemplos de como interagir com a API usando uma ferramenta como o Postman.

POST /todos - Criar uma nova tarefa

Método: POST
URL: http://localhost:8080/todos
Headers: Content-Type: application/json
Body (raw/JSON):

{
    "nome": "Comprar pão",
    "descricao": "Ir à padaria da esquina",
    "realizado": false,
    "prioridade": 1
}

Resposta de Sucesso (Status 201 Created): Uma lista atualizada de todas as tarefas.

GET /todos - Listar todas as tarefas

Método: GET
URL: http://localhost:8080/todos
Resposta de Sucesso (Status 200 OK):

[
    {
        "id": 1,
        "nome": "Comprar pão",
        "descricao": "Ir à padaria da esquina",
        "realizado": false,
        "prioridade": 1
    },
    {
        "id": 2,
        "nome": "Estudar Spring",
        "descricao": "Ver o vídeo sobre testes",
        "realizado": true,
        "prioridade": 2
    }
]


PUT /todos/{id} - Atualizar uma tarefa existente

Método: PUT
URL: http://localhost:8080/todos/1 (para atualizar a tarefa com id 1)
Headers: Content-Type: application/json
Body (raw/JSON):

{
    "nome": "Comprar pão e leite",
    "descricao": "Ir à padaria da esquina antes das 18h",
    "realizado": true,
    "prioridade": 1
}

Resposta de Sucesso (Status 200 OK): Uma lista atualizada de todas as tarefas.

DELETE /todos/{id} - Deletar uma tarefa

Método: DELETE
URL: http://localhost:8080/todos/1
Resposta de Sucesso (Status 200 OK): Uma lista com as tarefas restantes.

