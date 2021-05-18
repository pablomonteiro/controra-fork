# Origem

> Comentário informando a origem do problema ou necessidade da alteração.

# Problemática

> Descrição do problema informando o que está ocorrendo ou o que está em falta no sistema (dor do cliente). Nesse ponto pode ser bem mais específico, informando detalhes mais técnicos sobre o que ocasionou a falha.

# Solução

> Descrever o que foi feito, que solução foi dada, etc. Nesse ponto pode ser bem mais específico, informando detalhes mais técnicos sobre o que ocasionou a falha ou detalhes da implementação.

# Teste

> Informar quais os fluxos a equipe de teste deve fazer para simular o problema. Tentar expor o máximo possível, rico em detalhes, para o testes tentar ser o mais preciso.

# Issue

> https://tracker.casamagalhaes.com.br/youtrack/issue/

# Revisão

Durante a revisão do código sempre observar os seguintes pontos:

- Esse código faz sentido?
- Funciona em todos os cenários em que deveria?
- Está no lugar certo?
- Existe um jeito melhor (mais fácil, mais correto, mais legível) de fazer isso?
- Segue as convenções de código do time?
- Existe import ou variável ou warnings não utilizados?
- Está utilizando componentes depreciados?

## Checklist

**Preenchimento deve ser realizado pelo desenvolvedor responsável pela tarefa:**

### Java

- **Nomeclatura**
>  - [ ] Variáveis com nomes legíveis e coerentes
>  - [ ] Métodos com nomes legíveis e coerentes
>  - [ ] Classes com nomes legíveis e coerentes
- **Pacotes**
>  - [ ] Pacote utilizado foi o `br.com.casamagalhaes.controra`
>  - [ ] Estrutura de _Service_ e _Repository_ foi utilizada
- **Mapeamento e regras de negócio**
>  - [ ] Regras de negócios nos serviços
>  - [ ] Consultas de acesso ao banco no _Repository_
>  - [ ] Fazer validação principalmente no _backend_
>  - [ ] Uso de classes utilitárias (Objects, NumericUtils, etc)
>  - [ ] Código *nullsafe*
- **Testes**
>  - [ ] Implementação de novos testes para cenários não cobertos (cenários da tarefa)
>  - [ ] Ajuste de testes devido alteração na regra de negócio
>  - [ ] Verificar se a(s) classe(s) de teste estão com o pacote coerente com o pacote da classe origem
>  - [ ] Implementar testes de função de banco

### Banco de dados

- **Nomenclatura**
>  - [ ] Nome das tabelas/colunas fiéis à entidade que mapeia
>  - [ ] Nomes amigáveis e legíveis
>  - [ ] Padrão para a coluna PK da tabela deverá ser `prefixo_da_tabela_ID`. Usar prefixo com 3 dígitos (EX: *USU_ID* pra tabela Usuário). 
- **Estrutura dos Dados**
>  - [ ] Existência de PK
>  - [ ] Existência da _constraint_ FK para os relacionamentos
>  - [ ] Existência de indíces para consultas
>  - [ ] Campos nulos e não-nulos na criação das colunas, informando os parâmetros `NULL` e `NOT NULL`
>  - [ ] Entidades com as anotações condizentes com a tabela no banco
>  - [ ] Coluna com valor padrão, utilizando parâmetro `DEFAULT`
>  - [ ] Para campos que guardam valores estáticos (_enuns_, por exemplo), verificar a existência de `CHECK` para só aceitar os valores válidos
>  - [ ] Verificar se a tabela precisa de `UNIQUE`
>  - [ ] Buscar usar tipos específicos para o tipo de dado que se deseja armazenar. EX: apenas data, usar `DATE`; data e hora, usar `TIMESTAMP`; boleano, usar o `BOOLEAN`

- **Consultas**
>  - [ ] Existe `INDEX` para o filtro utilizado na consulta
>  - [ ] Utilizado a PK ou `INDEX` para buscar os dados
>  - [ ] Comando `LIKE` apenas quando necessário

### Relatório

> - [ ] Verificar se alteração tem impacto em relatórios
> - [ ] Verifcar agrupamentos (_Expressions_, _Print When Expression_)

### API

> - [ ] Checar impacto de alteração de `ENUM` na API
> - [ ] Atualizar _swagger_
> - [ ] Avaliar se novas regras de negócio não impactam na API considerando que campos novos obrigatórios devem ser implementados em uma nova versão da API, e não na V1
> - [ ] Verificar implementação do *API First*