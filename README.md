# Sistema de Matrículas Universitárias API

Esta é uma **API REST** desenvolvida como projeto para a disciplina de **Linguagem de Programação II**, simulando o processo de matrícula de alunos em disciplinas universitárias.

---

## Funcionalidades Principais

O sistema foi desenhado para gerenciar de forma eficiente o processo de inscrição em turmas:

* **Cadastro** de alunos e turmas.
* **Matrícula** de alunos em turmas.
* **Organização de Fila de Espera**: A prioridade é definida pelo **IRA** (Índice de Rendimento Acadêmico) do aluno.
* **Controle de Status**: Gerencia o estado da matrícula (`Confirmado` ou `Espera`).
* **Testes Completos**: Todos os endpoints são documentados e testáveis via **Swagger UI**.

---

## Desenvolvedoras

| Nome | Matrícula |
| :--- | :--- |
| Bruna Lucena da Costa Souto | 20240034898 |
| Natálya Gabriele Nunes de Azevedo | 20240023849 |

---

## Tecnologias Utilizadas

O projeto utiliza o ecossistema moderno do Java com o framework Spring Boot:

* **Java 17**
* **Spring Boot**
* **Spring Web**
* **Springdoc OpenAPI** (Swagger)
* **Maven** (Gerenciamento de dependências)
* **Eclipse IDE** (Ambiente de Desenvolvimento)

---

## Entidades do Projeto (Modelos)

Abaixo, uma explicação sobre as principais entidades e seus atributos dentro do sistema:

### 1. Aluno

Representa um estudante da universidade.

| Atributo | Tipo | Descrição |
| :--- | :--- | :--- |
| `nome` | `String` | Nome completo do aluno. |
| `matricula` | `String` | Código único de matrícula (identificador). |
| `curso` | `String` | Curso ao qual o aluno pertence. |
| `ira` | `Double` | Índice de Rendimento Acadêmico (Usado para ordenação da fila de espera). |

**Funcionalidades:** Cadastro e listagem de novos alunos.

### 2. Turma

Representa uma disciplina ofertada pela instituição.

| Atributo | Tipo | Descrição |
| :--- | :--- | :--- |
| `nomeDisciplina` | `String` | Ex.: "Linguagem de Programação II". |
| `professor` | `String` | Nome do professor responsável. |
| `horario` | `String` | Horário da turma. |
| `vagasTotais` | `Integer` | Número de vagas disponíveis. |
| `codigo` | `String` | Código identificador único da turma. |

**Funcionalidades:** Cadastro e listagem de turmas.

### 3. StatusMatricula (Enum)

Define o estado da matrícula de um aluno.

| Valor | Descrição |
| :--- | :--- |
| `CONFIRMADO` | Aluno matriculado com sucesso na turma. |
| `ESPERA` | Aluno inserido na fila de espera por falta de vagas. |

### 4. Matricula

Relaciona um **Aluno** a uma **Turma** e controla o `StatusMatricula`.

| Atributo | Tipo | Descrição |
| :--- | :--- | :--- |
| `aluno` | `Aluno` | Referência ao aluno. |
| `turma` | `Turma` | Referência à turma. |
| `status` | `StatusMatricula` | Indica se o aluno está confirmado ou em espera. |
| `posicao` | `Integer` | Posição do aluno no ranking da fila (ordenado por IRA). |

**Funcionalidades:** Realização de matrícula, controle de vagas, inserção automática em fila e listagem de matrículas.

---

## Estrutura Geral do Projeto

A aplicação segue a organização padrão do Spring Boot com a divisão de responsabilidades:

* `model`: Classes das entidades.
* `controller`: Endpoints da API (camada de apresentação).
* `service`: Regras de negócio e lógica de aplicação.
* `repository`: Simulação de banco de dados (armazenamento **em memória**).

---

## Acesso ao Swagger UI

Com a aplicação em execução, acesse o endereço abaixo para visualizar a documentação interativa e testar todos os endpoints da API (**/alunos**, **/turmas**, **/matriculas**):

http://localhost:8080/swagger-ui/index.html
