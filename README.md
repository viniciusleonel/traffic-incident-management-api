# API Gerenciamento de Incidentes de Tráfego

A API de Gerenciamento de Incidentes de Tráfego foi desenvolvida com Java e Spring, 
oferecendo soluções para o gerenciamento de acidentes de trânsito, usuários e autenticação. 
Com endpoints públicos e privados, permite o registro detalhado de acidentes, incluindo 
veículos, localização, data, hora, gravidade e feridos, armazenando os dados validados 
em um banco MongoDB. 

Foi implementado um workflow de Integração Contínua (CI) utilizando GitHub Actions para testes e builds em pull requests, e um processo de Entrega Contínua (CD) que realiza o deploy automático da aplicação em produção. A aplicação é containerizada com Docker e implantada na Azure, garantindo atualizações rápidas e escalabilidade.

### Atualização no workflow de Integração Contínua (CI) e Entrega Contínua (CD)

***Mudança motivada pela descontinuação dos benefícios do plano gratuito da conta Azure.***

O workflow `CI` é acionado automaticamente em cada `pull_request` ou `push` na `branch main`. 
Ele realiza o `build` da imagem Docker da API principal e sobe um container 
conectado a uma rede personalizada chamada **trafego-net**. Em seguida, aguarda 
a inicialização da API utilizando um endpoint de health check (`/actuator/health`). 
Após a confirmação de que a API está ativa, o workflow faz o download da 
imagem da API de testes `testes-bdd-ger_de_traf`, que contém os testes de 
integração automatizados. Essa imagem é executada em um container que se 
comunica com a API principal por meio da rede Docker criada. O teste é 
executado com a variável `API_HOST` apontando para o nome do container da 
API, garantindo um ambiente isolado e replicável para validação de 
funcionalidades. Essa abordagem garante que alterações no código sejam 
testadas de forma automatizada antes de serem entregues, reforçando a 
qualidade contínua da aplicação.

Após os testes de integração serem concluídos com sucesso, o workflow 
`CD` é acionado automaticamente. Ele realiza o checkout do código, configura o 
Docker Buildx, faz login no Docker Hub e executa o `build` e `push` da imagem 
Docker da API principal. Isso garante que apenas versões testadas da aplicação sejam 
publicadas no repositório, automatizando e confiabilizando o processo de 
entrega contínua.

<!--
[Traffic Incident Management API Azure](https://traffic-incident-api-dev-dtbtfvg2e7e7a8eq.eastus2-01.azurewebsites.net/swagger-ui/index.html)-->

--- 

## Requisitos:
- Ter o Docker instalado.
- Ter o Java (21) instalado. (Opcional)
- Ter um banco de dados MongoDB Atlas.
- Clonar este repositório: `git clone https://github.com/viniciusleonel/traffic-incident-management-api`

## Executando a aplicação com Java (21)

1. Configure as seguintes variáveis de ambiente no seu ambiente de desenvolvimento (ex: IntelliJ):
   - `PROFILE`
   - `MONGODB`
   - `JWT_SECRET`

   > **Dica (IntelliJ):** Vá em ***Run > Edit Configurations...*** e adicione essas variáveis no campo ***Environment variables***.

2. Execute a classe `GerenciamentoTrafegoApplication`.

Feito isso, a API estará disponível em `http://localhost:8080`.

## Executando a aplicação com Docker

1. Configure as mesmas variáveis de ambiente em `docker-compose`>`environment`

2. Abra o terminal na pasta raiz que contém os arquivos docker e digite os seguintes comandos:

    - Construir a imagem:
      `docker-compose build`

    - Iniciar os contêineres:
      `docker-compose up -d`

   Isso irá iniciar o contêiner em segundo plano.

Feito isso, a API estará disponível em `http://localhost:8080`.

---

## Utilização da API

- Cadastre-se como um usuário fazendo uma requisição POST para `/usuarios/cadastrar`.
- Para autenticar-se na API e obter um token JWT, faça uma requisição POST para `/autenticacao/login` enviando as credenciais de usuário.
- Utilize o token JWT recebido nas requisições aos endpoints privados da API, enviando-o no cabeçalho `Authorization`.

### Endpoints Públicos

- **POST /usuarios/cadastrar**: Endpoint para cadastro de novos usuários. Recebe os dados do usuário a ser cadastrado. (Padrão JSON abaixo)
    - **email**<span style="color: red;">*</span>: <span style="color: green;">string </span>( email )
    - **senha**<span style="color: red;">*</span>: <span style="color: green;">string</span>
    - **role**<span style="color: red;">*</span>: <span style="color: green;">ADMIN/USER</span>
  

- **POST /autenticacao/login**: Endpoint para autenticação de usuários. Recebe as credenciais do usuário e retorna um token JWT válido. (Padrão JSON abaixo)
    - **email**<span style="color: red;">*</span>: <span style="color: green;">string </span>( email )
    - **senha**<span style="color: red;">*</span>: <span style="color: green;">string</span>


### Endpoints Privados - ( NECESSÁRIO TOKEN JWT )

- **PUT /acidentes/atualizar/{id}**: Endpoint para atualizar informações sobre um acidente. (Padrão JSON abaixo)
- **POST /acidentes/cadastrar**: Endpoint para registrar informações sobre um acidente. (Padrão JSON abaixo)
    - **veiculo**<span style="color: red;">*</span>: <span style="color: green;">object</span>
        - **placa**<span style="color: red;">*</span>: <span style="color: green;">String</span> 
        - **modelo**<span style="color: red;">*</span>: <span style="color: green;">String</span> 
        - **ano**<span style="color: red;">*</span>: <span style="color: green;">Integer</span> 
        - **cor**<span style="color: red;">*</span>: <span style="color: green;">String</span>
    - **rua**<span style="color: red;">*</span>: <span style="color: green;">object</span>
        - **logradouro**<span style="color: red;">*</span>: <span style="color: green;">String</span>
        - **numero**<span style="color: red;">*</span>: <span style="color: green;">Integer</span>
        - **cep**<span style="color: red;">*</span>: <span style="color: green;">String</span>
        - **cidade**<span style="color: red;">*</span>: <span style="color: green;">String</span>
        - **estado**<span style="color: red;">*</span>: <span style="color: green;">String</span>
    - **dataHora**<span style="color: red;">*</span>: <span style="color: green;">LocalDate</span>
    - **gravidade**<span style="color: red;">*</span>: <span style="color: green;">String</span>
    - **localizacao**<span style="color: red;">*</span>: <span style="color: green;">String</span>

- **GET /acidentes/buscar/{id}**: Endpoint para buscar informações sobre um acidente específico.
- **DELETE /acidentes/deletar/{id}**: Endpoint para deletar um acidente específico.
- **GET /acidentes/listar**: Endpoint para listar todos os acidente.

Parâmetros de Paginação e Ordenação

- **GET** /acidentes/listar?page=0&size=1&sort=idAcidente,desc
- **page**: <span style="color: green;">integer</span>  
  minimum: 0
- **size**: <span style="color: green;">integer</span>  
  minimum: 1
- **sort**: <span style="color: green;">[string]</span> 


## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Doc
- Spring Security
- Json Web Token (JWT)
- Auth0
- Spring Data MongoDB
- Swagger
- Docker & DockerHub
- GitHub Actions
- Microsoft Azure

## Swagger [Doc](http://localhost:8080/swagger-ui/index.html)

## Criado por:

### Vinicius Leonel

### Linkedin: https://www.linkedin.com/in/viniciuslps
