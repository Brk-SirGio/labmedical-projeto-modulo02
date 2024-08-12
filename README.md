LabMedical API

Este é um projeto de API RESTful para o sistema de gerenciamento de prontuários médicos chamado LabMedical. A API foi desenvolvida utilizando Java Spring Boot e PostgreSQL.

Na pasta do projeto há um arquivo chamado '(Sergio Vieira - projeto avaliativo módulo 2)Insomnia_2024-08-11.json';
Este arquivo contém a exportação dos testes de request e response realizados através do Insomnia. 

Funcionalidades

A API LabMedical oferece os seguintes recursos:

1. Cadastro de Usuários - Endpoint para criar usuários.
2. Gerenciamento de Pacientes - Endpoints para criar, atualizar, excluir e listar pacientes.
3. Gerenciamento de Consultas - Endpoints para criar, atualizar, excluir e listar consultas.
4. Gerenciamento de Exames - Endpoints para criar, atualizar, excluir e listar exames.
5. Prontuário do Paciente - Endpoints para listar prontuários de pacientes.
6. Dashboard - Endpoint para listar estatísticas do sistema.

 Estrutura dos Endpoints

 1. Cadastro de Usuários

- POST /usuarios
  - Cria um novo usuário no sistema.
  - Exemplo de JSON:
    ```json
    {
        "nome": "João Silva",
        "email": "joao.silva@example.com",
        "cpf": "123.456.789-00",
        "password": "senhaSegura123",
        "dataNascimento": "1980-05-15",
        "username": "joaosilva",
        "perfil": "ADMIN"
    }
    ```

 2. Gerenciamento de Pacientes

- POST /pacientes
  - Cria um novo paciente.
  - Exemplo de JSON:
    ```json
    {
        "nomeCompleto": "Maria Oliveira",
        "genero": "Feminino",
        "dataNascimento": "1990-08-20",
        "cpf": "987.654.321-00",
        "rg": "123456789",
        "orgaoExpedidor": "SSP",
        "estadoCivil": "Solteira",
        "telefone": "(21) 98765-4321",
        "email": "maria.oliveira@example.com",
        "naturalidade": "Rio de Janeiro",
        "contatoEmergencia": "(21) 91234-5678",
        "alergias": ["Nenhuma"],
        "cuidadosEspecificos": ["Nenhum"],
        "convenio": "HealthCare",
        "numeroConvenio": "123456",
        "validadeConvenio": "2025-12-31",
        "idUsuario": 1,
        "endereco": {
            "cep": "22041-010",
            "cidade": "Rio de Janeiro",
            "estado": "RJ",
            "logradouro": "Av. Atlântica",
            "numero": "1000",
            "complemento": "Apt 501",
            "bairro": "Copacabana",
            "pontoDeReferencia": "Próximo ao posto 6"
        }
    }
    ```

- GET /pacientes/{id}
  - Retorna os detalhes de um paciente específico.
  
- PUT /pacientes/{id}
  - Atualiza as informações de um paciente específico.

- DELETE /pacientes/{id}
  - Exclui um paciente do sistema.

- GET /pacientes
  - Lista todos os pacientes cadastrados.

 3. Gerenciamento de Consultas

- POST /consultas
  - Cria uma nova consulta.
  - Exemplo de JSON:
    ```json
    {
        "motivoConsulta": "Dor nas costas",
        "dataConsulta": "2024-09-15",
        "horarioConsulta": "10:30",
        "descricaoProblema": "Dor aguda na região lombar.",
        "medicacaoReceitada": "Paracetamol",
        "dosagemPrecaucoes": "Tomar 1 comprimido a cada 8 horas",
        "idPaciente": 1
    }
    ```

- GET /consultas/{id}
  - Retorna os detalhes de uma consulta específica.

- PUT /consultas/{id}
  - Atualiza as informações de uma consulta específica.

- DELETE /consultas/{id}
  - Exclui uma consulta do sistema.

 4. Gerenciamento de Exames

- POST /exames
  - Cria um novo exame.
  - Exemplo de JSON:
    ```json
    {
        "nomeExame": "Hemograma Completo",
        "dataExame": "2024-09-20",
        "horarioExame": "09:00",
        "tipoExame": "Laboratorial",
        "laboratorio": "LabCenter",
        "urlDocumento": "https://exemplo.com/resultado-hemograma.pdf",
        "resultados": "Resultados dentro da normalidade",
        "idPaciente": 1
    }
    ```

- GET /exames/{id}
  - Retorna os detalhes de um exame específico.

- PUT /exames/{id}
  - Atualiza as informações de um exame específico.

- DELETE /exames/{id}
  - Exclui um exame do sistema.

 5. Prontuário do Paciente

- GET /pacientes/prontuarios
  - Lista todos os prontuários de pacientes cadastrados.
  
- GET /pacientes/{id}/prontuarios
  - Retorna o prontuário detalhado de um paciente específico, incluindo lista de consultas e exames.

 6. Dashboard

- GET /dashboard
  - Retorna estatísticas do sistema, como quantidade de pacientes, consultas e exames cadastrados.

 Como usar no Insomnia

Para testar os endpoints, utilize o Insomnia ou outra ferramenta similar para realizar requisições HTTP. Aqui estão os exemplos de uso:

1. Cadastrar um novo usuário:
   - Método: POST
   - URL: `http://localhost:8080/usuarios`
   - Body: JSON conforme exemplo no cadastro de usuários.

2. Criar um novo paciente:
   - Método: POST
   - URL: `http://localhost:8080/pacientes`
   - Body: JSON conforme exemplo no gerenciamento de pacientes.

3. Criar uma nova consulta:
   - Método: POST
   - URL: `http://localhost:8080/consultas`
   - Body: JSON conforme exemplo no gerenciamento de consultas.

4. Criar um novo exame:
   - Método: POST
   - URL: `http://localhost:8080/exames`
   - Body: JSON conforme exemplo no gerenciamento de exames.

5. Consultar um prontuário:
   - Método: GET
   - URL: `http://localhost:8080/pacientes/{id}/prontuarios`
   - Substitua `{id}` pelo ID do paciente.

6. Visualizar o dashboard:
   - Método: GET
   - URL: `http://localhost:8080/dashboard`

---

Não foram implantadas as regras de acesso por perfil aos endpoints, o endpoint de login e o controle de segurança com spring security;

Os citados acima ficarão para melhorias futuras.
