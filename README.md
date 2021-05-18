# Controra
Sistema para controle de horas extras.

## Ambiente de desenvolvimento


Tecnologias usadas no projeto:

- Java 11
- Gradle
- Spring Boot
- Spring Security
- Spring Data (Hibernate/JPA)
- PostgreSQL
- FlyWay

### Executar comandos com FlyWay
Para executar os campos usando o FlyWay deve-se usar o Gradle. 
- Executando Migrations:
> ./gradlew flywayMigrate
- Verificando Migrations Aplicadas:
> ./gradlew flywayInfo


### Padrões de Desenvolvimento


O padrão utilizado no desenvolvimento do projeto deverá seguir os seguintes passos:
- Branch utilizadas
>  - feature-xyz: branch que deve ser usada para desenvolvimento
>  - release-xyz: branch usada pra teste
>  - develop: branch base para desenvolvimento das tarefas

- Criação das branchs
>  - Tanto a branch feature quanto a release devem ser criadas com base na develop
>  - A nomenclatura utilizada deve ser a seguinte:
    - Tarefa: CTA-1
    - Branch desenvolvimento: feature-0001
    - Branch teste: release-0001
    - Em caso de tarefa com subtasks, a branch deve considerar a tarefa pai:
>     * EX:
>       - Tarefa Pai: CTA-1
>       - Subtasks: CTA-2, CTA-3, CTA-4
 
- Criação do PR
>  - A criação do PR deve ser realizado a pós a finalização da tarefa pai
>  - Deve ser revisto e alterado quaisquer ajuste não condizente com o checklist antes de ser passado pra revisão
