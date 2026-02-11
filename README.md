# 🎯 Sistema de Gestão de Eventos

Sistema completo de cadastro e gerenciamento de **Eventos** e **Instituições** desenvolvido em **Java 8**, utilizando **JSP/Servlets**, **H2 Database** e **Maven**.

**Desenvolvido como um desafio de Fullstack Java/React.**

---

## 📋 Índice

1. [Funcionalidades](#-funcionalidades)
2. [Tecnologias Utilizadas](#-tecnologias-utilizadas)
3. [Pré-requisitos e Downloads](#-pré-requisitos-e-downloads)

---

## ✨ Funcionalidades

### Instituições
- ✅ CRUD completo (Criar, Listar, Editar, Excluir)
- ✅ Tipos pré-definidos (Confederação, Singular, Central, Cooperativa)
- ✅ Interface responsiva com Bootstrap 5

### Eventos
- ✅ CRUD completo com relacionamento N:1 com Instituições
- ✅ Campos: Nome, Data Inicial, Data Final, Instituição
- ✅ **Status automático** (Ativo/Inativo) baseado no período de vigência
- ✅ Validações de data (data final não pode ser anterior à inicial)
- ✅ Exibição do nome da instituição na listagem

### Ativação Automática
- ✅ **Scheduler em background** que atualiza status dos eventos a cada 1 minuto
- ✅ Cálculo automático: evento fica **Ativo** quando a data atual está dentro do período de vigência
- ✅ **Atualização da tela em tempo real** via AJAX (sem necessidade de F5)

---

## 🛠 Tecnologias Utilizadas

- **Java 8** (OpenJDK)
- **Maven** 3.x
- **Apache Tomcat 9**
- **H2 Database** (embedded)
- **JSP + Servlets** (Java EE)
- **JSTL** (Java Standard Tag Library)
- **Bootstrap 5** (frontend)
- **JavaScript** (AJAX para atualização automática)

---

## 📦 Pré-requisitos e Downloads

### 1️⃣ Java 8 JDK

**Download:**  
👉 [Eclipse Temurin 8 (Adoptium)](https://adoptium.net/temurin/releases/?version=8)

- Escolha a versão para seu sistema operacional
- Instale e configure a variável de ambiente `JAVA_HOME`

**Verificar instalação:**

java -version

**Saída esperada:**

openjdk version "1.8.0_xxx"

**Apache Maven**

https://maven.apache.org/download.cgi

**Verificar instalação:**

mvn -version

Apache Tomcat 9

https://tomcat.apache.org/download-90.cgi

Baixe o arquivo zip (Core: 64-bit Windows zip ou equivalente para seu SO)

Extraia em uma pasta de sua preferência (ex: C:\apache-tomcat-9.0.x)

**Como Rodar o Projeto:**

git clone https://github.com/HermesEdu-code/event-management-system.git

cd event-management-system

Compilar o projeto com Maven

**Na raiz do projeto, execute:**

mvn clean package

**Resultado esperado:**

Arquivo gerado em target/event-management-system.war

Criar as tabelas no banco H2

O projeto usa H2 Database em modo arquivo. Você precisa criar as tabelas antes de usar o sistema.

Iniciar o H2 Console

**No terminal, dentro da pasta do projeto:**

mvn dependency:copy-dependencies

java -cp "target/dependency/h2-1.4.200.jar" org.h2.tools.Console

Isso abrirá o H2 Console no navegador: http://localhost:8082

Na tela do H2 Console, preencha:

JDBC URL: jdbc:h2:~/eventdb

User Name: sa

Password: (deixe em branco)

Executar o script SQL

Cole e execute o seguinte script:

CREATE TABLE IF NOT EXISTS instituicao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS evento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_inicial DATE NOT NULL,
    data_final DATE NOT NULL,
    ativo BOOLEAN NOT NULL,
    instituicao_id INT NOT NULL,
    CONSTRAINT fk_evento_instituicao
      FOREIGN KEY (instituicao_id) REFERENCES instituicao(id)
);

Deploy no Tomcat

Copiar o arquivo WAR

Copie o arquivo gerado para a pasta webapps do Tomcat:

target/event-management-system.war

C:\apache-tomcat-9.0.x\webapps\event-management-system.war

Iniciar o Tomcat

**Windows:**

cd C:\apache-tomcat-9.0.x\bin

startup.bat

**Acessar o sistema**

Abra o navegador e acesse: http://localhost:8080/event-management-system/
