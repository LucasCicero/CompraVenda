# Compra&Venda

<div align="center">
    <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white">  <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white">  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">  <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot">  <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white">  <img src="https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white">  <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white">  <img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white">  <img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white">
</div>

## 🔖 Sobre 

Compra&Venda é uma aplicação SpringBoot onde foi solicitado um CRUD para uma loja fisica. Na aplicação o acesso foi dividido em 4 partes, são elas:

- Administrador: Funcionários previamente autorizados a acessar área privada através de um login, responsavél pelo cadastro de compradores, vendedores e outros administradores. 👨‍💼👩‍💼

- Vendedor: : Funcionários responsáveis pelas vendas de produtos para os clientes. São funcionários previamente cadastrados pelo administrador e que acessam a área privada da aplicação. Cadastram os clientes que estão comprando e cadastram as vendas dos 
produtos para os clientes. 🙍‍♂️🙍

- Comprador: Funcionários responsáveis pelas compras de produtos juntos aos fornecedores. São funcionários previamente cadastrados pelo administrador e que acessam a área privada da aplicação. Cadastram os fornecedores que estão vendendo os produtos e cadastram as compras dos produtos dos fornecedores. 🙍‍♂️🙍

- Clientes: Acessam a aplicação e visualiza os produtos colocados para venda. 🧑👩

### O que é CRUD? 🤔

CRUD é a composição da primeira letra de 4 funções básicas de um sistema que trabalha com banco de dados:

✅ C: Create (criar) - criar um novo registro.

👁 R: Read (ler) - ler (exibir) as informações de um registro.

♻️ U: Update (atualizar) - atualiza os dados do registro.

❌ D: Delete (apagar) - apaga um registro.

Por exemplo, se você precisa desenvolver desde uma simples agenda telefônica até um sistema complexo de gestão de faturamento de pedidos, você precisará realizar essas 4 ações para manipular as tabelas do banco de dados de seu sistema.

Do ponto de vista do desenvolvedor, ele precisará criar as tabelas (modelos) do banco de dados, funções (controles) que atualizarão o banco de dados e as interfaces (visões), como página web ou aplicativo mobile, em que os usuários irão interagir com os dados.

Em sistemas mais sofisticados, os dados do CRUD podem ser manipulados por outros sistemas via API - Application Programming Interface (em tradução livre, “Interface de Programação de Aplicativos”).

#

[Saiba mais](https://angelopublio.com.br/blog/crud).

## Imagens da aplicação em tela:

Tela inicial com os produtos disponíveis para compra:

![index](https://user-images.githubusercontent.com/71888055/168309351-9d1fbb3b-2c68-42ae-9867-3306b05dcd20.jpg)

Tela de login:

![login](https://user-images.githubusercontent.com/71888055/168308491-fb78f82f-9382-4319-a60d-016a805e9e78.PNG)

Lista de produtos na visão do comprador:

![produtos-comprador](https://user-images.githubusercontent.com/71888055/168314952-3f96d3e0-ce71-4f79-b909-d150c1ca4699.jpg)

Lista de funcionarios na visão do administrador:

![lista-funcionarios](https://user-images.githubusercontent.com/71888055/168309738-34bbc265-b194-4cc6-8430-4b0ed22d0c7b.JPG)

Lista de clientes na visão de vendedor:

![lista-clientes](https://user-images.githubusercontent.com/71888055/168311482-7b649abf-83ec-4162-88ef-2656b1672d74.JPG)

#

## Ferramentas utilizadas 🖥️🛠️👨‍💻📚

- [NetBeans](https://netbeans.apache.org/download/index.html)
- [Java](https://www.java.com/pt-BR/)
- [Spring-Boot](https://start.spring.io/)
- [Spring-Security](https://spring.io/projects/spring-security)
- [MySql](https://www.mysql.com/)
- [Hibernate](https://www.devmedia.com.br/guia/hibernate/38312)
- [Bootstrap](https://getbootstrap.com/)

#

## Modo de usar 🧐

Abra o terminal e digite o seguinte comando para baixar o repositório:

- `` git clone https://github.com/LucasCicero/CompraVenda ``

Na sua IDE, importe o projeto para instalar todas as dependências. Caso seu banco de dados tenha senha, vá em `` DataConfiguration.java `` para adicionar ou remover sua senha em `` dataSource.setPassword(""); ``.

![Capturar](https://user-images.githubusercontent.com/71888055/168320335-19e6ebfd-088b-4e4d-a9cc-7ea1fa2a22c7.PNG)

Depois no arquivo `` CvApplication.java ``, clique no botão de <strong>Run</strong> para iniciar o projeto.
