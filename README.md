# 🚀 Desafio Nubank (Estudo Pessoal)

Este repositório contém a resolução de um desafio técnico do **Nubank**, originalmente voltado para um processo seletivo.  

Não participei do processo seletivo. Este projeto foi desenvolvido **exclusivamente para estudo e prática** de boas práticas com **Java + Spring Boot**.  

---

## 📌 Objetivo do Projeto
Criar uma aplicação backend que gerencie **clientes** e seus **contatos**, utilizando uma arquitetura limpa, boas práticas de código e padrões recomendados no ecossistema Spring.

---

## 🛠 Tecnologias Utilizadas
- **Java 24**  
- **Spring Boot 3** (Web, Validation, JPA)  
- **PostgreSQL**  
- **Lombok**  
- **Hibernate / JPA**  
- **Maven**  

---

## 📂 Estrutura do Projeto

```
src/main/java/spring/boot/desafio/nubank
│
├── controller/        # Controllers (exposição dos endpoints REST)
├── dto/               # Data Transfer Objects (entrada e saída da API)
├── model/             # Entidades JPA (mapeadas para o banco de dados)
├── repository/        # Repositórios JPA
├── service/           # Serviços (regras de negócio)
├── mapper/            # Conversão entre entidades e DTOs
└── config/            # Configurações globais (ex: exception handler)
```

---

## 📌 Endpoints Principais

### 👤 Clientes
- `POST /clientes` → Cadastrar um novo cliente  
- `GET /clientes` → Listar todos os clientes  
- `GET /clientes/{id}/contatos` → Listar contatos de um cliente específico  

### 📞 Contatos
- `POST /contatos` → Cadastrar um novo contato vinculado a um cliente  

---

## 🧪 Validações
- Campos obrigatórios validados com **Jakarta Validation** (`@NotBlank`, etc).  
- Tratamento global de erros com `@RestControllerAdvice`.  
- Retorno de mensagens de erro padronizadas em formato JSON.  

Exemplo de erro:
```json
{
  "telefone": "Telefone é obrigatório",
  "email": "Email é obrigatório"
}
```

---

## 🏗 Arquitetura
Este projeto segue o padrão **camada em 3 níveis**:

1. **Controller** → recebe a requisição e expõe endpoints REST.  
2. **Service** → concentra a regra de negócio.  
3. **Repository** → comunicação com o banco via JPA.  

Além disso:
- **Mapper** → garante a conversão clara entre DTOs e entidades.  
- **DTOs** → evitam expor diretamente entidades do banco.  

---

## 📖 Documentação
- Todo o código possui **Javadoc em português**, explicando propósito de classes, métodos e atributos.  
- Esse cuidado facilita a **manutenção, entendimento e evolução** do sistema.  

---

## 🚀 Como Executar
1. Clone este repositório:  
   ```bash
   git clone https://github.com/gdcaue/desafio-nubank-java.git
   ```
2. Configure o banco **PostgreSQL** local:  
   ```sql
   CREATE DATABASE desafio_nubank;
   ```
3. Ajuste o arquivo `application.properties` com suas credenciais.  
4. Execute o projeto:  
   ```bash
   mvn spring-boot:run
   ```
5. Acesse a API em:  
   ```
   http://localhost:8080
   ```

---
