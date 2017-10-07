Feature: UC-14-Calcular-Frete-E-Tempo-De-Entrega

  Scenario: Calcular Frete Sucesso
    Given Lista de Produtos:
    | Peso      | Altura    | Largura     | Comprimento |
    | 100       | 120       | 14          | 10          |
    | 10        | 10        | 7           | 3           |
    | 10        | 10        | 1           | 2           |
    And um CEP válido:

