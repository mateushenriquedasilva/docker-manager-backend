# Docker Manager Backend

![Java](https://img.shields.io/badge/Java-100%25-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Build](https://img.shields.io/github/actions/workflow/status/mateushenriquedasilva/docker-manager-backend/build.yml)

API that lists docker containers running on your machine 🐋

## Descrição

Este projeto é uma API desenvolvida em Java que lista os contêineres Docker em execução na sua máquina, facilitando a gestão e monitoramento dos mesmos.

## Tecnologias Utilizadas
- **Spring Boot:** Framework para construção de aplicações Java.
- **Docker Java API:** Biblioteca para interação com o Docker.
- **Maven:** Ferramenta de automação de compilação e gerenciamento de dependências.
- **JUnit:** Framework para testes unitários.
- **Mockito:** Framework para criação de mocks em testes.
- **Lombok:** Biblioteca para reduzir a verbosidade do código Java.

## Funcionalidades

- **Listar Contêineres:** Lista todos os contêineres Docker em execução.
- **Detalhes do Contêiner:** Obtém detalhes específicos de um contêiner.

## Pré-requisitos

- Docker instalado e em execução na máquina
- Java 11 ou superior
- Maven

## Como Executar

1. **Clone o repositório:**

    ```sh
    git clone https://github.com/mateushenriquedasilva/docker-manager-backend.git
    ```

2. **Entre no diretório do projeto:**

    ```sh
    cd docker-manager-backend
    ```

3. **Compile e execute a aplicação:**

    ```sh
    ./mvnw spring-boot:run
    ```

4. **Acesse a API:**

    A API estará disponível em `http://localhost:8080`.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b minha-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Faça um push para a branch (`git push origin minha-feature`).
5. Crie um novo Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

- **Autor:** Mateus Henrique da Silva