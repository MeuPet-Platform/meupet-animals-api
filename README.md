# Microsserviço: API de Animais (meupet-animals-api)

![Java](https://img.shields.io/badge/Java-21-blue)
![Quarkus](https://img.shields.io/badge/Quarkus-3.14-blueviolet)
![Maven](https://img.shields.io/badge/Maven-3.9-red)

Microsserviço central da plataforma MeuPet, responsável pelo gerenciamento completo de animais (Cachorros, Gatos, Aves) e seus respectivos históricos de vacinação.

---

## 🚀 Sobre o Serviço

Este serviço é o coração do domínio de negócio da aplicação. Suas responsabilidades incluem:
-   Operações de CRUD (Criar, Ler, Atualizar, Deletar) para os diferentes tipos de animais.
-   Gerenciamento do histórico de vacinas de cada animal.
-   Cálculo automático do status de vacinação de um animal com base em seu histórico.
-   Validação da existência de um tutor através de comunicação com o `meupet-users-api`.

### Arquitetura e Comunicação

Este serviço é um exemplo de um microsserviço consumidor. Para garantir que um animal só possa ser cadastrado para um tutor válido, ele utiliza um **Quarkus REST Client** para fazer uma chamada de API para o `meupet-users-api` e verificar a existência do tutor antes de persistir um novo animal.

---

## 🛠️ Tecnologias Utilizadas

-   **Framework:** Quarkus
-   **Linguagem:** Java 21
-   **Persistência:** Hibernate ORM com Panache
-   **Banco de Dados:** MySQL (Conexão compartilhada)
-   **Comunicação:** Quarkus REST Client
-   **Segurança:** Validação de Tokens JWT (via `quarkus-smallrye-jwt`)
-   **Build:** Maven

---

## 📋 Pré-requisitos

-   [Java (GraalVM) 21+](https://www.graalvm.org/downloads/)
-   [Apache Maven 3.9+](https://maven.apache.org/download.cgi)
-   [Docker](https://www.docker.com/products/docker-desktop/) e Docker Compose

---

## ▶️ Como Executar (Desenvolvimento)

Para rodar este serviço em modo de desenvolvimento, a infraestrutura e o serviço de usuários **precisam estar rodando primeiro**.

1.  **Inicie a Infraestrutura:**
    Navegue até o repositório `meupet-infra` e execute:
    ```bash
    docker-compose up -d
    ```

2.  **Inicie o Serviço de Usuários:**
    Em um novo terminal, navegue até o repositório `meupet-users-api` e execute:
    ```bash
    mvn quarkus:dev
    ```

3.  **Clone e Execute este Serviço:**
    Em um terceiro terminal, clone e inicie o serviço de animais.
    ```bash
    git clone [https://github.com/MeuPet-Platform/meupet-animals-api.git](https://github.com/MeuPet-Platform/meupet-animals-api.git)
    cd meupet-animals-api
    mvn quarkus:dev
    ```
    O serviço estará disponível em `http://localhost:8083`.

---

## 🐳 Como Executar (Plataforma Completa com Docker)

Para executar este serviço como parte da plataforma completa, vá para a raiz do repositório `meupet-infra` e execute o comando que orquestra todos os serviços definidos no `docker-compose.yml` da infraestrutura.
```bash
docker-compose up --build
```

---

## 📖 Endpoints da API

A documentação completa e interativa da API está disponível via Swagger UI enquanto o serviço estiver rodando.

* **URL da Documentação:** [http://localhost:8083/q/swagger-ui/](http://localhost:8083/q/swagger-ui/)

#### Principais Endpoints:
-   `POST /animais/{tipo}`: Cadastra um novo animal (ex: `/animais/cachorro`).
-   `GET /animais`: Lista todos os animais. Pode ser filtrado com `?tutorId={id}`.
-   `GET /animais/{id}`: Busca um animal pelo seu ID.
-   `PUT /animais/{tipo}/{id}`: Atualiza um animal existente.
-   `DELETE /animais/{id}`: Deleta um animal.
-   `POST /animais/{idAnimal}/vacinas`: Adiciona uma vacina a um animal.
-   `GET /animais/{idAnimal}/vacinas`: Lista as vacinas de um animal.
-   `PUT /animais/{idAnimal}/vacinas/{idVacina}`: Atualiza uma vacina.
-   `DELETE /animais/{idAnimal}/vacinas/{idVacina}`: Deleta uma vacina.

*Todos os endpoints deste serviço são protegidos e exigem um token JWT válido no cabeçalho `Authorization`.*

---

## ⚙️ Variáveis de Ambiente

Para rodar a imagem Docker em produção, as seguintes variáveis de ambiente podem ser configuradas no `docker-compose.yml`:

-   `QUARKUS_DATASOURCE_JDBC_URL`: A URL de conexão com o banco de dados.
    -   *Exemplo:* `jdbc:mysql://mysql:3306/meupet`
-   `QUARKUS_REST_CLIENT_COM_MEUPET_API_CLIENT_USUARIORESTCLIENT_URL`: A URL do serviço de usuários.
    -   *Exemplo:* `http://users-api:8082`


## 📄 Documentação

Toda a documentação pode ser acessada na pasta [docs/](./docs).  
Documentos principais:
- [Diagrama de classes](./docs/ClassDiagram-TPPE.png)
- [Backlog](./docs/backlog_meupet.md)


