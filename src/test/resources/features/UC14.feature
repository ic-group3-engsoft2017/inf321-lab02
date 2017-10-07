#language: pt
Funcionalidade: : UC-14-Calcular-Frete-E-Tempo-De-Entrega

  Cenario: : Calcular Frete Sucesso
    Dado Lista de Produtos:
    | Peso      | Altura    | Largura     | Comprimento |
    | 100       | 120       | 14          | 10          |
    | 10        | 10        | 7           | 3           |
    | 10        | 10        | 1           | 2           |
    E um tipo de entrega:
    | PAC |
    E um CEP válido:
    | cep | 13083-970 |

