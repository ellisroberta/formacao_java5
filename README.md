# Sistema de Gestão de Funcionários com JDBC

Este é um sistema simples de gestão de funcionários desenvolvido em Java, utilizando JDBC para conectar-se a um banco de dados MySQL.
O sistema implementa operações CRUD (Criar, Ler, Atualizar e Deletar) para gerenciar informações de funcionários.

## Estrutura do Projeto

O projeto é organizado da seguinte forma:

```
├── src/
│   ├── application/
│   │   └── Program.java                    # Classe principal da aplicação
│   ├── db/
│   │   ├── DatabaseConnection.java         # Classe para conexão com o banco de dados
│   │   └── DbException.java                # Classe de exceção personalizada para o banco de dados
│   └── model/
│       ├── dao/
│       │   ├── impl/
│       │   │   └── FuncionarioDaoJDBC.java # Implementação das operações de funcionário
│       │   └── FuncionarioDAO.java         # Interface para operações de funcionário
│       └── entities/
│           └── Funcionario.java            # Classe de entidade Funcionario
├── database.sql                            # Script SQL para criação do banco de dados
├── db.properties                           # Arquivo de propriedades para configuração do banco de dados
├── LICENSE                                 # Licença do projeto
└── README.md                               # Documentação do projeto
```

## Funcionalidades

- Adicionar novos funcionários
- Listar todos os funcionários
- Buscar informações de um funcionário específico
- Atualizar dados de um funcionário
- Deletar um funcionário

## Tecnologias Utilizadas

- Java 17
- JDBC (Java Database Connectivity)
- MySQL (ou outro banco de dados relacional)

## Pré-requisitos

Antes de executar o projeto, você precisará ter o seguinte instalado:

- JDK 17
- MySQL Server (ou o banco de dados de sua escolha)
- Um IDE para Java (como IntelliJ IDEA, Eclipse, etc.)

## Configurações

1. **Banco de Dados**: Certifique-se de que o servidor MySQL esteja em execução e que o banco de dados `coursejdbc` exista.
Você pode criar o banco de dados usando o seguinte comando SQL:

    ```sql
    CREATE DATABASE coursejdbc;
    ```

2. **Tabela de Funcionários**: Execute o script `database.sql`, que se encontra na raiz do seu diretório do projeto.
Este script cria a tabela `funcionarios` necessária para o funcionamento do exemplo.

3. **Arquivo de Propriedades**: Crie um arquivo chamado `db.properties` na raiz do seu diretório do projeto com o seguinte conteúdo:

    ```properties
    user=root
    password=123456
    dburl=jdbc:mysql://localhost:3306/coursejdbc
    useSSL=false
    ```

   **Obs.**: Substitua os valores de `user` e `password` pelas credenciais do seu banco de dados, se necessário.

4. **Dependências**: Se você estiver usando Maven, adicione a seguinte dependência ao seu arquivo `pom.xml`:

    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.23</version> <!-- Verifique se há uma versão mais recente -->
    </dependency>
    ```

## Como Executar

1. Compile o projeto. Se estiver usando um IDE como IntelliJ IDEA ou Eclipse, você pode usar o recurso de compilação integrado.

2. Execute a classe `Program.java`:

    ```bash
    java application.Program
    ```

3. O programa tentará estabelecer uma conexão com o banco de dados.

## Exemplo de Uso

No arquivo `Program.java`, você encontrará exemplos de como usar as funcionalidades do sistema.
Você pode adicionar, listar, buscar, atualizar e deletar funcionários através das chamadas correspondentes.