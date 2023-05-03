# Compilador

Este é um projecto da faculdade que é para fazer um compilador do 0. A linguagem usada é `Java` e estou a fazer um compilador para a linguagem `Java`.

<br>

## Estutura

Tem duas pastas principais, que são:
1. [SRC](./src)
    - [Executar](./src/Executar.java)
    <br> 
    Ficheiro onde deve correr o programa, ou seja, é o `main` do projecto ;

    - [analysis](./src/analysis/) 
    <br> 
    Pasta onde vai se tratar de tudo que seja analises. Que serão: `Lexica` , `Sintatica` , `Semantica` ;

    - [constants](./src/constants/)
    <br>
    Pasta onde terão as listas de várias constantes tais como palavras reservadas do `Java` ;

    - [functions](./src/functions/)
    <br>
    Pasta onde terão as funções que serão usadas pelo o projecto, tal como ler de um ficheiro de texto e muito mais ;

    - [models](./src/models/)
    <br>
    Aqui terá tudo haver com os modelos do projecto, ou seja, objectos e enums ;

    - [views](./src/views/)
    <br>
    Aqui terão as varias formas de visualizar informações. Pode ser por meio de tabelas, etc.

2. [DOCS](./docs/)
    - [classificacao](./docs/classificacao/)
    <br>
    Aqui tem todas as `palavras` e `simbolos` que existem por defeito do `Java` dentro das as suas respectivas classificações em texto ;
    - [programs](./docs/programs/)
    <br>
    Aqui tem exemplares de programas para poder ser compilado pelo o programa.

<br>

## Tecnologias

![Vs Code](https://img.shields.io/badge/Visual_Studio_Code-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)