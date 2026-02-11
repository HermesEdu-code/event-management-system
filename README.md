# 🎯 Sistema de Gestão de Eventos

Sistema completo de cadastro e gerenciamento de **Eventos** e **Instituições** desenvolvido em **Java 8**, utilizando **JSP/Servlets**, **H2 Database** e **Maven**.

**Desenvolvido como um desafio de Fullstack Java/React.**

---

## 📋 Índice

1. [Funcionalidades](#-funcionalidades)
2. [Tecnologias Utilizadas](#-tecnologias-utilizadas)
3. [Pré-requisitos e Downloads](#-pré-requisitos-e-downloads)
4. [Como Rodar o Projeto](#-como-rodar-o-projeto)
5. [Configuração do Banco de Dados](#-configuração-do-banco-de-dados)
6. [Testando o Sistema](#-testando-o-sistema)
7. [Destaques Técnicos](#-destaques-técnicos)

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
bash
java -version

Saída esperada:
openjdk version "1.8.0_xxx"

Apache Maven
https://maven.apache.org/download.cgi
