# 🛒 Projeto E-commerce com Spring Boot e Java

Projeto desenvolvido como atividade final que engloba todo o módulo de Java com Spring Boot.
O objetivo é consolidar os principais conceitos aprendidos ao longo do curso, aplicando-os no desenvolvimento de um projeto completo back-end
passando e aprofundando nos tópios das principais camadas para a construção robusta, segura e completa de um sistema de e-commerce.

## 📚 Conteúdos e Tecnologias Aplicadas

Durante o desenvolvimento deste projeto, foram abordados os seguintes tópicos fundamentais para uma aplicação backend robusta com Java:

### 🔧 Injeção de Dependência
- Utilização do Spring para gerenciar beans e promover baixo acoplamento entre componentes.
- Uso de anotações como `@Autowired`, `@Service`, `@Component`, entre outras.

### 🧱 Modelo de Domínio
- Criação de entidades JPA para representar o domínio do e-commerce (ex: Produto, Categoria, Usuário, Pedido).
- Utilização de Data Transfer Object no projeto DTO
- Organização clara e coesa da camada de modelo.

### ✏️ CRUDs (Create, Read, Update, Delete)
- Implementação de operações básicas para todas as entidades.
- Utilização do padrão de projeto Repository para abstração de acesso a dados.

### 🌐 APIs REST
- Exposição de endpoints RESTful para interação com os recursos.
- Uso de anotações como `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, `Pageables` etc.

### 🗃️ JPA e Banco de Dados
- Integração com banco de dados relacional utilizando Spring Data JPA.
- Utilização de H2 (em memória).
- Montagem de `@Query` no Repository.
- Mapeamento entre entidades e tabelas com `@Entity`, `@Table`, `@ManyToOne`, `@OneToMany`, `@JoinTable`.

### ✅ Validações
- Validações de entrada com Bean Validation (JSR-380).
- Utilização de anotações como `@NotNull`, `@Email`, `@Size`, etc.
- Tratamento de erros com `@ControllerAdvice`.

### 🔐 Autenticação e Autorização
- Implementação de autenticação com Spring Security e os modelos AuthorizationService e ResourceService.
- Proteção de rotas com base em perfis de usuário (admin, cliente).
- Uso de JWT (JSON Web Token) para autenticação stateless.

## 🛠️ Tecnologias Utilizadas

- Java 21+
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- H2 Database (dev)
- Maven
- Bean Validation
- JWT (jjwt)

Projeto ainda em construção...
