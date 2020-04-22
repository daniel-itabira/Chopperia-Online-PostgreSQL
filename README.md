# Simulador de Chopperia Online
---
**Projeto realizado na UFOP: Universidade Federal de Ouro Preto**

Realizado na disciplina **Banco de Dados 1**

O projeto visa a implementação de uma chopperia online, existindo uma interface para o __*Cliente*__ acessar a maquina de bebidas/faturas e também compõe uma inteface para os __*Funcionários*__ realizarem seu login para iniciar os trabalhos.

---


Existem 2 tipos de __*Funcionários*__ sendo eles:

1. Gerente
1. Vendedor

**Gerente** é responsável por manipular (Cadastrar/Deletar/Editar) funcíonarios do tipo *Vendedor*, também tem acesso total a máquina de bebidas o que torna possível realizar edições como: cadastrar/remover/editar bebidas; analisar índice de vendas; analisar estoque dentre outros.

**Vendedor** é responsável por cadastrar/remover/editar acesso dos clientes (ID CARD), também realiza atribuição de saldo para os clientes. 

---

**Cliente** possuí um numero identificador (ID CARD) para acessar a maquina de bebidas e realizar compras ou acessar sua tabela de gastos. 

A **Máquina** possuí um filtro que avalia se o cliente que está solicitando acesso é maior de 18 anos, caso não for ele não podera comprar bebidas alcoólicas. 


### Observações

1. O Projeto possuí um manual de utilização em formato pdf. 
2. É necessário realizar algumas configurações para acessar o BD poís está hospedado em um servidor privado.
3. Por motívos de segurança, o login de **Vendedor e Gerente**, só será repassado com a solicitação através de e-mail.
4. E-mail para solicitar acesso ao painel de **Vendedor e Gerente**: daniel.sr@aluno.ufop.edu.br
5. Número de cartões (ID CARD) que dá acesso ao cliente para testar funcionalidades da Maquina: **55 | 57 | 59** 
6. Usuaríos da IDE Eclipse precisam configurar o patch jar do Postgree dísponivel em: https://jdbc.postgresql.org/download.html versão recomendada: postgresql-42.2.8.jre6


Tecnologias utilizadas:
- Java
   - JavaSwing
- PostgreSQL
- Heroku: Cloud Application Platform
