#language: pt
Funcionalidade: : UC-14-Calcular-Frete-E-Tempo-De-Entrega

  Cenario: Fluxo Básico
    Dado Lista de Produtos:
    | Peso      | Altura    | Largura     | Comprimento |
    | 100       | 120       | 14          | 10          |
    | 10        | 10        | 7           | 3           |
    | 10        | 10        | 1           | 2           |
    E um tipo de entrega "PACVAREJO"
    E um endereço com CEP "13083-970"
    Quando eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega
    Então o resultado deve ser o preco e prazo
    | Preço | 100 |
    | Prazo | 100 |
    E armazena essa informação no banco de dados


  Cenario: Fluxo Alternativo A - CEP inválido
    Dado Lista de Produtos:
      | Peso      | Altura    | Largura     | Comprimento |
      | 100       | 120       | 14          | 10          |
      | 10        | 10        | 7           | 3           |
      | 10        | 10        | 1           | 2           |
    E um tipo de entrega "SEDEXVAREJO"
    E um endereço com CEP "1-970"
    Quando eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega
    Então o resultado deve ser erro

  Cenario: Fluxo Alternativo A - Erro na API do correio
    Dado Lista de Produtos:
      | Peso      | Altura    | Largura     | Comprimento |
      | 100       | 120       | 14          | 10          |
      | 10        | 10        | 7           | 3           |
      | 10        | 10        | 1           | 2           |
    E um tipo de entrega "PACVAREJO"
    E um endereço com CEP "13087-970"
    Quando eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega
    Então o resultado deve ser erro

