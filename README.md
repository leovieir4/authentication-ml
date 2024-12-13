# 🔐 API REST de Geração de Tokens 🗝️

Este projeto consiste em uma API REST desenvolvida em Java com Gradle para gerar e validar tokens de autenticação. A API possui dois endpoints principais, detalhados abaixo.

## Endpoints:

  - `/gerarToken`: Gera um token com tempo de expiração de 3 minutos.
  - `/validarToken`: Valida se um token gerado é válido.
      - Token válido: Retorna status 200 OK e a mensagem "Token válido".
      - Token inválido: Retorna status 401 Unauthorized e a mensagem "Token inválido".

## 💻 Uso:

Os tokens gerados por esta API serão utilizados para autenticar na API de CDS que será desenvolvida posteriormente.

## 📝 Requisitos:

Para executar a aplicação, você precisará ter os seguintes softwares instalados em sua máquina:

  - Java Development Kit (JDK) 21: [Download do JDK 21](https://www.oracle.com/java/technologies/downloads/#java8)
  - Gradle (8.5): [Download do Gradle](https://gradle.org/releases/)
  - Docker: [Download do Docker](https://www.docker.com/products/docker-desktop/)
  - Docker Compose: (Geralmente já incluso na instalação do Docker)

## Executar Localmente (sem Docker):

Para executar a aplicação localmente sem Docker:

1. ▶️ Clone o repositório:

    ```bash
    git clone https://github.com/leovieir4/authentication-ml
    ```

2. 📂 Navegue até o diretório:

    ```bash
    cd <nome do diretório>
    ```

3. 🔨 Build a aplicação:

    ```bash
    ./gradlew build
    ```

4. 🚀 Execute a aplicação:

    ```bash
    ./gradlew bootRun
    ```

## 🐳 Executar com Docker Compose:

Para executar a aplicação via Docker Compose:

1.  Clone o repositório do projeto.
2.  Navegue até o diretório raiz do projeto no terminal.
3.  Execute o comando `docker-compose up -d --build `. Isso construirá a imagem Docker, caso ainda não exista, e iniciará o contêiner em segundo plano.

## 🔎 Visualizar os logs:

Para visualizar os logs da aplicação em tempo real, execute o seguinte comando:

```bash
docker-compose logs -f api-tokens
```

## 🛑 Parar a aplicação (Docker):

Para parar a aplicação e remover os contêineres, execute o seguinte comando:

```bash
docker-compose down
```

## 🔄 Reconstruir a imagem (Docker):

Se você fizer alterações no código-fonte ou no Dockerfile, execute o seguinte comando para reconstruir a imagem e reiniciar o contêiner:

```bash
docker-compose up -d --build
```

## ℹ️ Observações:

- A porta da API é 8081.
- O arquivo docker-compose.yml contém a configuração para executar a aplicação em um contêiner Docker.

## ☁️ Credenciais da AWS:

- Certifique-se de ter as credenciais da AWS configuradas corretamente, caso sua aplicação as utilize.

## ⚠️ Caso não possua as credenciais da AWS:

- Altere o Dockerfile para usar o profile local no argumento `-Dspring.profiles.active=local`.
- Remova a linha - `~/.aws/credentials:/root/.aws/credentials do arquivo docker-compose.yml`.
- Reconstrua a imagem com `docker-compose up -d --build`.

## 📖 Documentação da API (Swagger):
[Documentação](http://13.59.156.55:8081/swagger-ui/index.html#/auth-controller)

## 🚀 Deploy na AWS:
[Link da API](http://13.59.156.55/)

## 🧑‍💻 Autor:
Leonardo Vieira da Silva

## 📞 Contato:

Email: vieraleonardosilva@gmail.com

Telefone: (11) 994419472
