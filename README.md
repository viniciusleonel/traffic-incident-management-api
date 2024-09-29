# API Gerenciamento de Incidentes de Tráfego

A API de Gerenciamento de Incidentes de Tráfego foi desenvolvida com Java e Spring, oferecendo soluções para o gerenciamento de acidentes de trânsito, usuários e autenticação. Com endpoints públicos e privados, permite o registro detalhado de acidentes, incluindo veículos, localização, data, hora, gravidade e feridos, armazenando os dados validados em um banco MongoDB. Foi implementado um workflow de Integração Contínua (CI) utilizando GitHub Actions para testes e builds em pull requests, e um processo de Entrega Contínua (CD) que realiza o deploy automático da aplicação em produção. A aplicação é containerizada com Docker e implantada na Azure, garantindo atualizações rápidas e escalabilidade.

### Primeiro passo - Configurar Banco de dados MongoDB

Insira o link de seu banco de dados MongoDB Atlas em uma variável de ambiente chamada `MONGODB`.

`application.properties`

`spring.data.mongodb.uri=${MONGODB}`

---

### Segundo passo - Iniciar a aplicação com Docker

Para iniciar a aplicação sem o uso do docker apenas pressione `run` no arquivo **JAR** ou na classe `GerenciamentoTrafegoApplication`

Se deseja usar o docker para rodar um container da aplicação, abra o terminal na pasta raiz que contém os arquivos docker e digite os seguintes comandos:

Construir a imagem:
`docker-compose build`

Iniciar os contêineres:
`docker-compose up`

Feito isso, a aplicação irá iniciar.

---

## Utilização da API

- Cadastre-se como um usuário fazendo uma requisição POST para `/usuarios/cadastrar`.
- Para autenticar-se na API e obter um token JWT, faça uma requisição POST para `/autenticacao/login` enviando as credenciais de usuário.
- Utilize o token JWT recebido nas requisições aos endpoints privados da API, enviando-o no cabeçalho `Authorization`.

### Endpoints Públicos

- **POST /usuarios/cadastrar**: Endpoint para cadastro de novos usuários. Recebe os dados do usuário a ser cadastrado. (Padrão JSON abaixo)
    - **login**<span style="color: red;">*</span>: <span style="color: green;">string </span>( email )
    - **senha**<span style="color: red;">*</span>: <span style="color: green;">string</span>
    - **role**<span style="color: red;">*</span>: <span style="color: green;">ADMIN/USER</span>
  

- **POST /autenticacao/login**: Endpoint para autenticação de usuários. Recebe as credenciais do usuário e retorna um token JWT válido. (Padrão JSON abaixo)
    - **login**<span style="color: red;">*</span>: <span style="color: green;">string </span>( email )
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
- Spring Framework
- Spring Boot
- Spring Security (JWT)
- Spring Doc
- Auth0
- Hibernate (JPA)
- Banco de Dados Relacional: MongoDB
