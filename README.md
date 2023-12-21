![banner](https://github.com/leoarcabold/Sistema_de_Gestao_de_Estoque_EletroTech/blob/main/img/banner.jpeg)

# Sistema de Gestão de Estoque EletroTech
O principal objetivo deste projeto é criar um sistema que permita à EletroTech monitorar e gerenciar seu estoque de forma eficaz, garantindo que haja sempre um equilíbrio adequado entre a oferta e a demanda.

### Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Características](#características)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Banco de Dados](#estrutura-do-banco-de-dados)
- [Configuração do Projeto](#configuração-do-projeto)
- [Uso](#uso)
- [Contribuições](#contribuições)
- [Licença](#licença)
- [Contato](#contato)


### Características

Uma lista das principais funcionalidades do sistema, como gestão de produtos,
controle de estoque, rastreamento de movimentações de estoque, e
administração de fornecedores.
Tecnologias Utilizadas

Uma seção detalhando as tecnologias e ferramentas utilizadas no
desenvolvimento do projeto, como Java, SQLite.
### Estrutura do Banco de Dados

O Sistema de Gestão de Estoque EletroTech foi desenvolvido para gerenciar de forma eficiente o estoque de produtos e a relação com os fornecedores, permitindo às empresas manter um controle preciso sobre o fluxo de produtos, desde o recebimento e a movimentação de saída.

*Componentes:*

* *Cadastro de Fornecedores*: Mantém um registro detalhado de todos os fornecedores, incluindo informações fiscais e comerciais. Isso permite à empresa rastrear e gerenciar suas relações comerciais com informações atualizadas e acessíveis.

* *Registro de Produtos*: Uma base de dados completa dos produtos, categorizando-os e descrevendo-os para facilitar a identificação, seleção e gestão de estoque.

* *Controle de Movimentação de Estoque*: Registra todas as movimentações de entrada e saída do estoque, fornecendo dados em tempo real sobre a disponibilidade de produtos, custos associados e datas de validade, o que é crucial para manter a integridade do inventário e evitar desperdícios.

* *Associação Fornecedor-Produto*: Uma tabela de associação que conecta produtos aos seus respectivos fornecedores, permitindo à empresa identificar rapidamente de onde os produtos estão vindo e para onde estão indo, o que é essencial para a gestão da cadeia de suprimentos e para negociações de compra.


<img src=https://github.com/leoarcabold/Sistema_de_Gestao_de_Estoque_EletroTech/blob/main/img/database.jpg width=100%>

O projeto descrito é um sistema de banco de dados relacional projetado para gerenciar as operações de inventário e as relações com fornecedores de uma empresa. A seguir, detalho a estrutura do banco de dados e a finalidade de cada uma das tabelas propostas:


-- Criação da tabela de Fornecedores
CREATE TABLE FORNECEDOR (
    Id INT PRIMARY KEY,
    CNPJ_CPF VARCHAR(18),
    Razao_Social VARCHAR(50),
    Nome VARCHAR(50)
);

-- Criação da tabela de Produtos
CREATE TABLE PRODUTO (
    Id INT PRIMARY KEY,
    Nome VARCHAR(30),
    Descricao VARCHAR(100),
    Categoria VARCHAR(50)
);

-- Criação da tabela de Movimentação de Estoque
CREATE TABLE MOVIMENTACAO_ESTOQUE (
    Id INT PRIMARY KEY,
    Produto_Id INT,
    Data DATE,
    Quantidade REAL,
    Tipo_Movimentacao VARCHAR(30),
    Custo REAL,
    Lote INT,
    Validade DATE,
    FOREIGN KEY (Produto_Id) REFERENCES PRODUTO(Id)
);

-- Criação da tabela de associação entre Fornecedores e Produtos
CREATE TABLE FORNECEDOR_PRODUTO (
    Id INT PRIMARY KEY,
    Produto_Id INT,
    Fornecedor_Id INT,
    FOREIGN KEY (Produto_Id) REFERENCES PRODUTO(Id),
    FOREIGN KEY (Fornecedor_Id) REFERENCES FORNECEDOR(Id)
);

### Configuração do Projeto

Pré-Requisitos
Antes de iniciar a configuração do projeto, certifique-se de que as seguintes ferramentas e tecnologias estejam instaladas e configuradas em seu ambiente:

* *Java JDK*: O projeto requer Java Development Kit (JDK) versão 17 ou superior. Pode ser baixado e instalado a partir do site oficial do Oracle Java.
* *SQLite*: O projeto utiliza SQLite como sistema de gerenciamento de banco de dados. Baixe e instale o SQLite a partir do site oficial do SQLite.
* *IDE Apropriada*: Recomendamos o uso de uma IDE como IntelliJ IDEA ou Eclipse para facilitar o desenvolvimento e a execução do projeto.

* *Instalação e Execução*

Siga estes passos para configurar e iniciar o projeto:
* *Clonar o Repositório*: Use o seguinte comando para clonar o repositório do projeto:
  

* > git clone https://github.com/leoarcabold/Sistema_de_Gestao_de_Estoque_EletroTech


* *Configurar o Ambiente*: Abra o projeto clonado na sua IDE de escolha e certifique-se de que o JDK está corretamente configurado no projeto.
* *Executar o Projeto*: Execute a classe principal do projeto ou o arquivo JAR gerado para iniciar a aplicação.


*Pré-Requisitos*: Lista de tudo que é necessário antes de começar a
instalação, como Java JDK, SQLitee uma IDE apropriada.

*Instalação e Execução*: Um passo a passo detalhando como clonar o
repositório, configurar o ambiente e executar o projeto.

### Uso

Após iniciar o sistema, você pode realizar as seguintes operações:

* *CRUD (Create, Read, Update, Delete)*: O sistema permite criar, visualizar, atualizar e deletar registros no banco de dados.
* *Outras Funcionalidades*: Descreva aqui outras funcionalidades específicas do sistema, como consultas específicas, relatórios gerados, etc.
### Contribuições

Contribuições são sempre bem-vindas! Para contribuir com o projeto:

* *Fazer Fork*: Crie um fork do projeto no GitHub.
* *Criar Branch*: Crie uma nova branch para suas modificações (git checkout -b feature/NovaFuncionalidade).
* *Fazer Commits*: Faça commits de suas alterações (git commit -am 'Adicionando uma nova funcionalidade').
* *Abrir Pull Requests*: Envie um pull request para o repositório original para revisão e possível integração.
### Licença

Este projeto é distribuído sob a Licença MIT. Veja o arquivo LICENSE no repositório do projeto para mais detalhes.
### Contato

*Autor/Mantenedor*: Leandro Soares

*GitHub*: https://github.com/leoarcabold/Sistema_de_Gestao_de_Estoque_EletroTech
