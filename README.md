# Sistema de Gestão de Eventos

Implementação de um sistema de cadastro e gestão de **Eventos** e **Instituições** em Java, utilizando **JSP / Servlets**, **H2 Database** e **Maven**.

## Tecnologias e Stack

- **Java 8 (OpenJDK Temurin 1.8)**  
- **Servlets + JSP (Java EE)**  
- **Apache Tomcat 9** para execução do `.war`  
- **Maven** para build e dependências  
- **H2 Database** (modo arquivo, com `AUTO_SERVER=TRUE`)  
- **JSTL** nas views  
- **Bootstrap 5** no frontend  
- **Scheduler** em Java para atualização automática de status dos eventos

---

## Funcionalidades Implementadas

### Instituições

- CRUD completo de Instituições (`nome`, `tipo`)
- Tipos pré-definidos (ex.: Confederação, Singular, Central, Cooperativa)
- Listagem com ações de Editar / Excluir
- Tela amigável com Bootstrap

### Eventos

- CRUD completo de Eventos:
  - `nome`
  - `data_inicial`
  - `data_final`
  - `instituicao_id` (relacionamento com Instituição)
  - `ativo` (status calculado automaticamente)
- Relação **N:1** com Instituição
- Listagem de eventos exibindo:
  - Nome do evento
  - Nome da instituição
  - Datas de início e fim
  - Status (Ativo / Inativo) com badge visual
- Validações:
  - Data final não pode ser anterior à data inicial
  - Associação obrigatória a uma instituição

### Ativação Automática de Eventos

O status do evento (`ativo`) é determinado automaticamente com base na data atual (`CURRENT_DATE`) e no período de vigência do evento:

- **Ativo** quando `CURRENT_DATE` está entre `data_inicial` e `data_final` (inclusive)
- **Inativo** caso contrário

Existem duas camadas de atualização:

1. **No momento do cadastro/edição**  
   O `EventoServlet` calcula o status ao salvar:

   ```java
   LocalDate hoje = LocalDate.now();
   boolean ativo = !hoje.isBefore(dataInicial) && !hoje.isAfter(dataFinal);
