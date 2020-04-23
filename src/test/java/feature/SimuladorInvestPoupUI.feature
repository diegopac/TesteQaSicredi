#Author: diegopac@gmail.com
@tag
Feature: Simular Investimento Poupança

  @tag1
  Scenario Outline: Consultar simulação de investimento com sucesso
    Given associado acessa tela Simulador de investimento Poupança Sicredi
    When informa campo Qual o valor que você quer aplicar? <valorAplicar>
    And informa campo Quanto você quer poupar todo mês? <valorInvestir>
    And informa campo Por quanto tempo você quer poupar? <tempo>
    And clica no botao Simular
    Then visualiza na tela os resultados da simulacao

    Examples: 
      | valorAplicar | valorInvestir | tempo |
      |     "300.00" |      "300.00" |   "6" |
      
  @tag1
  Scenario Outline: Consultar simulação de investimento com erro de valor minimo no campo Qual o valor que você quer aplicar?
    Given associado acessa tela Simulador de investimento Poupança Sicredi
    When informa campo Qual o valor que você quer aplicar? <valorAplicar>
    Then visualiza na tela a mensagem de erro de valor minimo no campo Qual o valor que você quer aplicar?

    Examples: 
      | valorAplicar |
      |      "15.00" |
      
  @tag1
  Scenario Outline: Consultar simulação de investimento com erro de valor minimo no campo Quanto você quer poupar todo mês?
    Given associado acessa tela Simulador de investimento Poupança Sicredi
    When informa campo Quanto você quer poupar todo mês? <valorInvestir>
    Then visualiza na tela a mensagem de erro de valor minimo no campo Quanto você quer poupar todo mês?

    Examples: 
      | valorInvestir |
      |       "15.00" |

