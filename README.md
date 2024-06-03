# Marvel-API 🌟

## Descrição
Marvel-API é um projeto desenvolvido em Spring Boot, criado para explorar e interagir com a API oficial da Marvel. Ele permite que usuários acessem informações detalhadas sobre quadrinhos, séries e personagens do vasto universo Marvel, oferecendo uma forma simplificada e acessível para fãs e desenvolvedores buscarem detalhes específicos sobre seus personagens e séries favoritos.

## Funcionalidades 🚀
- **Buscar Quadrinhos**: Permite aos usuários obter uma lista de quadrinhos, com opções de filtragem por título, paginação e ordenação.
- **Explorar Séries**: Facilita a busca por séries através de títulos, com funcionalidades de paginação e ordenação para melhor navegação.
- **Descobrir Super-Heróis**: Fornece a capacidade de buscar heróis por nome, facilitando a descoberta de informações detalhadas sobre personagens famosos e outros heróis do universo Marvel.

## Como Configurar 🛠️

### Pré-requisitos
- Java 11 ou superior
- Maven
- Acesso à internet para conexão com a API da Marvel

### Passos para Configuração
1. **Clonar o Repositório**
   ```bash
   git clone https://github.com/flavws/marvel-api.git
   cd marvel-api
2. **Configurar Chaves da API**
- Obtenha suas chaves de API acessando o [Marvel Developer Portal](https://developer.marvel.com/).
- Adicione suas chaves ao arquivo `src/main/resources/application.properties`:
  ```properties
  marvel.api.public.key=sua-chave-publica-aqui
  marvel.api.private.key=sua-chave-privada-aqui
3. **Construir e Executar o Projeto**
- Execute os seguintes comandos no terminal para compilar e iniciar a aplicação:
  ```bash
  mvn clean install
  mvn spring-boot:run
4. **Acessar a API**
Após iniciar a aplicação, você pode acessar o Swagger UI para interagir com a API:
- Abra um navegador e visite `http://localhost:8080/swagger-ui.html`.

## Como Usar 📚
Utilize a interface do Swagger UI para realizar chamadas à API. Exemplos práticos de uso incluem:

### Buscar Quadrinhos
- **Endpoint**: `/marvel/comics`
- **Método**: GET
- **Parâmetros**:
  - `page`: número da página, padrão é 0
  - `size`: número de itens por página, padrão é 10
  - `orderBy`: campo pelo qual os resultados devem ser ordenados, padrão é `title`
- **Exemplo de chamada**:
  ```plaintext
  /marvel/comics?page=0&size=10&orderBy=title
### Explorar Séries
- **Endpoint**: `/marvel/series`
- **Método**: GET
- **Parâmetros**:
  - `title`: parte do título da série para busca
  - `page`: número da página, padrão é 0
  - `size`: número de itens por página, padrão é 10
  - `orderBy`: campo pelo qual os resultados devem ser ordenados, padrão é `title`
- **Exemplo de chamada**:
  ```plaintext
  /marvel/series?title=Avengers&page=0&size=5&orderBy=title
### Descobrir Super-Heróis
- **Endpoint**: `/marvel/superheroes`
- **Método**: GET
- **Parâmetros**:
  - `name`: nome ou parte do nome do super-herói para busca
  - `page`: número da página, padrão é 0
  - `size`: número de itens por página, padrão é 10
- **Exemplo de chamada**:
  ```plaintext
  /marvel/superheroes?name=Iron&page=0&size=10
