# TESTE PRÁTICO PROGRAMAÇÃO
Utilizei todo meu conhecimento e criatividade para resolver o teste prático de programação. Construi uma pequena API para resolver o que foi pedido.
Tecnologias utilizadas:

-Java 17
-Spring Boot
-Lombok
-Banco de Dados H2

# API FUNCIONARIOS
http://localhost:8080/ - API Funcionários que disponibiliza todas as funcionalidades solicitadas no desafio.
Há um arquivo import.sql que inclui no banco de dados que insere todos os funcionários na ordem da tabela dada no desafio. (Há também um endpoint para salvar os funcionários).

# DOCUMENTAÇÃO
- http://localhost:8080/swagger-ui/index.html
- EndPoints
    - Get http://localhost:8080/funcionario - Lista todos os funcionários, com datas e valores de salários formatados.
    - Get http://localhost:8080/funcionario/salario-reajustado - Lista os funcionários após receberem aumento de 10% no salário
    - Get http://localhost:8080/funcionario/por-funcao - Lista os funcionários, agrupados por função.
    - Get http://localhost:8080/funcionario/mes-nascimento - Lista os funcionários que fazem aniversário no mês 10 e 12.
    - Get http://localhost:8080/funcionario/mais-velho - Lista o funcionário com a maior idade, exibindo os atributos: nome e idade.
    - Get http://localhost:8080/funcionario/ordenado-alfabeticamente - Lista os funcionários por ordem alfabética
    - Get http://localhost:8080/funcionario/total-salario - Lista o total dos salários dos funcionários.
    - Get http://localhost:8080/funcionario/funcionario-salmin - Lista quantos salários mínimos ganha cada funcionário

