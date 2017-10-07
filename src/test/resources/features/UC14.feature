#language: pt
Funcionalidade: : UC-14-Calcular-Frete-E-Tempo-De-Entrega

  Cenario: Fluxo Básico
    Dado Lista de Produtos:
    | Peso      | Altura    | Largura     | Comprimento |
    | 100       | 120       | 14          | 10          |
    | 10        | 10        | 7           | 3           |
    | 10        | 10        | 1           | 2           |
    E um tipo de entrega:
    | PAC |
    E um CEP válido:
    | cep | 13083-970 |
    Quando eu informo o CEP na busca de endereço
    Então o resultado deve ser o endereço:
      | Logradouro       | Cidade   |
      | Rua Carlos Gomes | Campinas |
    Quando eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega
    Então o resultado deve ser
    | Preço | Prazo |
    | 100   | x     |
    E armazena essa informação no banco de dados


  Cenario: Fluxo Alternativo A
    Dado Lista de Produtos:
      | Peso      | Altura    | Largura     | Comprimento |
      | 100       | 120       | 14          | 10          |
      | 10        | 10        | 7           | 3           |
      | 10        | 10        | 1           | 2           |
    E um tipo de entrega:
      | SEDEX |
    E um CEP válido:
      | cep | 13083-970 |
    Quando eu informo o CEP na busca de endereço
    Então o resultado deve ser o endereço:
      | Logradouro       | Cidade   |
      | Rua Carlos Gomes | Campinas |
    Quando eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega
    Então o resultado deve ser
      | Preço | Prazo |
      | 100   | x     |
    E armazena essa informação no banco de dados



  Cenario: Fluxo Alternativo B1
    Dado Lista de Produtos:
      | Peso      | Altura    | Largura     | Comprimento |
      | 100       | 120       | 14          | 10          |
      | 10        | 10        | 7           | 3           |
      | 10        | 10        | 1           | 2           |
    E um tipo de entrega:
      | PAC |
    E um CEP válido:
      | cep | 13083-970 |
    Quando eu informo o CEP na busca de endereço
    Então o resultado deve ser o endereço:
      | Logradouro       | Cidade   |
      | Rua Carlos Gomes | Campinas |
    Quando eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega
    Então a mensagem de erro dos correios é do código "400"
    E armazena essa informação no banco de dados

  Cenario: Fluxo Alternativo B2
    Dado Lista de Produtos:
      | Peso      | Altura    | Largura     | Comprimento |
      | 100       | 120       | 14          | 10          |
      | 10        | 10        | 7           | 3           |
      | 10        | 10        | 1           | 2           |
    E um tipo de entrega:
      | PAC |
    E um CEP válido:
      | cep | 13083-970 |
    Quando eu informo o CEP na busca de endereço
    Então o resultado deve ser o endereço:
      | Logradouro       | Cidade   |
      | Rua Carlos Gomes | Campinas |
    Quando eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega
    Então a mensagem de erro dos correios é do código "500"
    E armazena essa informação no banco de dados