### API para gerenciamento de Filmes

## Instruções para colocar em operação

# Requisitos
- Java 17
- PostgreSQL
  - Database: filmes
  - Username: postgres
  - Password: postgres

# Instalação
- Clone este projeto
- Importe para o Eclipse
- Atualize as bibliotecas com o Maven
- Inicialize

# Acesso
- Abra o um gerenciador de API, como o Postman

# Utilização

Para incluir um filme
	
	- URI: http://localhost:8080/filmes
	
	- Método: POST
	
	- Formulário JSON: titulo, ano, duracao, genero
	
Para listar todos os filmes
	
	- URI: http://localhost:8080/filmes
	
	- Método: GET
	
Para mostrar apenas um filme
	
	- URI: http://localhost:8080/filmes/{id}
	
	- Método: GET
	
Para excluir um filme
	
	- URI: http://localhost:8080/filmes/{id}
	
	- Método: DELETE

Para alterar um filme
	
	- URI: http://localhost:8080/filmes/{id}
	
	- Método: PUT
	
	- Formulário JSON: titulo, ano, duracao, genero