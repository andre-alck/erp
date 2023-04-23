# ERP

## Diagrama de Classes UML

![](erp.png)

## 5W2H

**1. What?**

ERP (Enterprise Resource Planning - Planejamento de Recursos Empresariais) para uma empresa fictícia.

**2. Why?**

Para praticar as seguintes competências:

-   Java
-   Orientação a Objetos (OOP/POO)
-   APIs Rest
-   Spring Boot
-   Testes unitários
-   JUnit
-   Maven
-   MySQL
-   JDBC
-   Clean Code
-   Git
-   GitHub

**3. Who?**

[🙋‍♂️](https://github.com/andre-alck)

**4. Where?**

API será hospedada no Google App Engine.

**5. When?**

Tempo indefinido, considerando a premissa do projeto: prática de competências.

**6. How?**

Utilizando as competências listadas na seção "2. Why?".

**7. How Much?**

Custo variável, dependendo da tabela de preços atual do Google App Engine para hospedagem da aplicação. Para mais informações, [verificar documentação das cotas](https://cloud.google.com/1ppengine/docs/standard/quotashl=pt-br).

## Modelagem Funcional

### Participante Externo

Ao **trabalhar**, o sistema deve verificar se as tarefas concluídas do participante externo passam pelas validações, sendo:

1.  O status de sua regulamentação é regular;
1.  A quantidade de tarefas concluídas deve ser maior do que zero.

Caso as validações sejam cumpridas, o sistema deve atribuir a lista de tarefas concluídas à lista de tarefas concluídas do participante externo. Caso contrário, deve lançar exceções respectivas à situação em questão. Para mais detalhamentos, analise o fluxograma abaixo.

![](https://raw.githubusercontent.com/andre-alck/erp/main/regras.de.negocio/participante/externo/trabalhar.png)

### Estagiário

Ao **documentar**, o sistema deve verificar se a documentação passa pelas validações, sendo:

1. Id não é nulo;
1. Id não é vazio;
1. Id não está em branco;
1. O número de páginas é maior do que um.

Caso as validações sejam cumpridas, o sistema deve atribuir a documentação à lista de tarefas concluídas do estagiário. Caso contrário, deve lançar exceções respectivas à situação em questão. Para mais detalhamentos, analise o fluxograma abaixo.

![](https://raw.githubusercontent.com/andre-alck/erp/main/regras.de.negocio/participante/interno/funcionario/estagiario/documentar.png)

### Clt

Ao **participar de reunião**, o sistema deve verificar se sua contribuição passa pelas validações, sendo:

1. A quantidade de perguntas é maior do que uma.
1. A quantidade de respostas é maior do que uma.
1. A pontuação é maior ou igual a cinco.

Caso as validações sejam cumpridas, o sistema deve atribuir à promoção à lista de tarefas concluídas do CLT. Caso contrário, deve lançar exceções respectivas à situação em questão. Para mais detalhamentos, analise o fluxograma abaixo.

![](https://raw.githubusercontent.com/andre-alck/erp/main/regras.de.negocio/participante/interno/funcionario/clt/participardereuniao.png)

### Supervisor de TI

Ao **promover**, o sistema deve verificar se o funcionário passa pelas validações, sendo:

1. O funcionário é um Estagiário de TI.

Caso essa validação seja cumprida, o sistema deve atribuir a promoção à lista de tarefas concluídas do Supervisor de TI. Caso contrário, deve lançar exceções respectivas à situação em questão. Para mais detalhamentos, analise o fluxograma abaixo.

![](https://raw.githubusercontent.com/andre-alck/erp/main/regras.de.negocio/participante/interno/funcionario/ti/supervisordeti/promover/promover.png)

Ao **demitir**, o sistema deve verificar se o funcionário passa pelas validações, sendo:

1. O funcionário é um Estagiário de TI ou o funcionário é Desenvolvedor.

Caso essa validação seja cumprida, o sistema deve atribuir a demissão à lista de tarefas concluídas do Supervisor de TI. Caso contrário, deve lançar exceções respectivas à situação em questão. Para mais detalhamentos, analise o fluxograma abaixo.

## Design Pattern

-   Builders
