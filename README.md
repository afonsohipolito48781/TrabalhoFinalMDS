# Trabalho Final de Metodologias e Desenvolvimento de Software

Pretende-se criar um sistema de backend para a gestão de hoteis, nomeadamente no que diz respeito à gestão dos quartos disponíveis, da manutenção dos quartos e das estadias dos hóspedes.

O sistema disponibiliza operações que permitem ao gestor criar, editar e remover quartos, especificar todas as características do quarto, incluindo a capacidade
máxima de hóspedes, o número de camas, o tipo de vista (por exemplo serra ou mar), se tem cozinha ou não, o número de casas de banho e se tem ou não varanda. Qualquer uma das propriedades pode ser alterada a qualquer momento pelo gestor do sistema. Este tipo de gestão apenas pode ser efetuado pelo gestor do sistema.

Existem também operações que permitem aos funcionários do hotel verificar quais os quartos que precisam de manutenção, que tipo de manutenção (limpeza, trocar lâmpadas, etc…), bem como registar todas as manutenções que são realizadas aos quartos. Os gestores do hotel também devem conseguir realizar estas operações.

Este sistema é também usado para fazer a gestão das reservas do hotel, disponibilizando operações que permitem registar a ocupação de cada quarto. Associado a
cada estadia, existe um registo de ocorrências, como por exemplo queixas dos hóspedes ou comportamentos menos apropriados por parte dos hóspedes, ficando associado ao histórico de cada hóspede. Estas operações estão disponíveis para qualquer utilizador do sistema.

O sistema disponibiliza operações que permitem sugerir que quartos devem ficar associados a uma reserva, de acordo com as restrições da reserva e considerando a ocupação de cada um dos quartos. Para isso, é considerado o número total de hóspedes, o número de hóspedes por quarto e o número total de quartos, a tipologia de cada quarto e as datas de entrada e de saída. Caso a sugestão do sistema seja aceite, é possível fazer a reserva de imediato. Para que uma reserva possa ser feita, os hóspedes têm que estar registados no sistema, incluindo os seus dados pessoais. As reservas podem ser realizadas pelo gestor do sistema, pelos funcionários ou pelos hóspedes, sendo que as reservas feitas pelos hóspedes devem ser confirmadas pelo gestor ou pelos funcionários.

Depois de cada estadia, é possível registar a avaliação dos hóspedes. Esta avaliação apenas pode ser feita até 1 mês depois do final da estadia.


# PARTE 2: Implementação do Trabalho em Java

## Descrição do Projeto

O projeto **The Hotel (V2)** é uma aplicação desenvolvida em Java para gerir as operações de um hotel, incluindo funcionalidades como gestão, reserva e manutenção de quartos. O projeto utiliza o **Maven** como ferramenta de construção e gestão de dependências.

## Estrutura do Projeto

O nosso projeto está organizado da seguinte maneira:

```
TrabalhoFinalMDS/
|-- pom.xml (Gestão de dependências e configuração do projeto)
|-- src/
    |-- main/
        |-- java/
            |-- thehotelv2/
                |-- Main.java (Main da aplicação)
                |-- Quarto.java (Gestão de quartos)
                |-- Gestor.java (Utilizador: gerente)
                |-- Funcionario.java (Utilizador: funcionário)
                |-- Manutencao.java (Gestão de manutenção)
                |-- Reserva.java (Controle de reservas)
    |-- test/
        |-- java/
            |-- thehotelv2/
                |-- CriarQuartoTest.java
                |-- EditarQuartoTest.java
                |-- QuartoTest.java
                |-- ReservaTest.java
                |-- ManutencaoQuartosTest.java
                |-- RemoverQuartoTest.java
                |-- GestorTest.java
                |-- ManutencaoTest.java
```

## Tecnologias Utilizadas

- **Java** (linguagem principal)
- **JUnit** (para testes automatizados)
- **Maven** (para gestão de dependências)


## Como Executar o Projeto

```sh
mvn clean install
mvn exec:java -Dexec.mainClass="thehotelv2.Main"
```

## Como Executar os Testes

Para executar os testes unitários, utilizamos:

```sh
mvn test
```


## Decisões de Desenvolvimento

Durante o desenvolvimento do projeto, seguimos as seguintes decisões:

1. **Organização por responsabilidades:** Cada classe representa uma entidade específica do sistema (ex.: `Quarto`, `Funcionario`, `Reserva`).
2. **Testes Automatizados:** Foram criados testes unitários para garantir a estabilidade e o funcionamento correto das funcionalidades principais.
3. **Tratamento de erros:** Implementação de mecanismos para lidar com exceções e falhas no gerenciamento de quartos e reservas.
4. **Separacão por branches:** Implementamos as funcionalidades por grupos, cada um para um branch, de forma a separar cada grupo de funcionalidades.


## Testes Unitários

Os testes unitários são uma parte essencial do projeto para garantir que cada componente funcione conforme esperado. Eles foram implementados usando o framework **JUnit5**, que permite verificar o comportamento das classes e métodos de forma isolada.

### Objetivos dos testes

- Validar se as funcionalidades principais do sistema (criação, edição e remoção de quartos, gestão de reservas e manutenção) foram implementadas corretamente.
- Garantir que eventuais mudanças no código não causem bugs às funcionalidades existentes.
- Automatizar a verificação de regras específicas.

### Linha de raciocínio adotada

Cada conjunto de testes foi estruturado para:

1. Configuração do ambiente de teste, criando as instâncias dos objetos necessários.
2. Chamada dos métodos que serão testados.
3. Comparar os resultados obtidos com os esperados, com o assert.

### Testes implementados

- **GestorTest.java:** Garante que a gestão dos quartos está correta.
- **CriarQuartoTest.java:** Testa a criação de novos quartos.
- **EditarQuartoTest.java:** Valida a edição de informações dos quartos.
- **RemoverQuartoTest.java:** Testa a funcionalidade de remoção de quartos.
- **QuartoTest.java:** Testes gerais para as operações relacionadas a quartos.
- **ManutencaoQuartosTest.java:** Avalia os procedimentos de manutenção.
- **ManutencaoTest.java:** Testa a gestão de manutenção de forma isolada.
- **ReservaTest.java:** Verifica a criação e gestão de reservas.


### Projeto realizado no âmbito da UC Metodologias e Desenvolvimento de Software
- Docente: **Pedro Salgueiro** [GitHub](https://github.com/pedrosalgueiro)
- **Afonso Hipólito** - [GitHub](https://github.com/afonsohipolito48781)
- **Rafaela Abade** - [GitHub](https://github.com/rafaela52246)
