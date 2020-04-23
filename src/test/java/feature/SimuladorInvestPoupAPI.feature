#Author: diegopac@gmail.com
@tag
Feature: Simular Investimento Poupança (API de Serviço)

  @tag1
  Scenario: Obter simulação de investimento com sucesso pela API
    Given cliente faz GET da URL "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador"
    Then o codigo de status da resposta deve ser 200
    And a resposta deve conter no body o JSON
      """
      {"id":1,"meses":["112","124","136","148"],"valor":["2.802","3.174","3.564","3.971"]}
      """
