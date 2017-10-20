# language: pt
Funcionalidade: Consultar Entrega
  Como um usuario do sistema Bookstore
  Desejo consultar um endereco a partir do CEP
  Para que eu possa usar o endereco para fazer um pedido

  Cenário: Consultar uma entrega valida [codigo do pedido existente]
    Dado Eu tenho um Codigo de rastreio valido:
      | codigorastreio | AA123456789BR |
    Quando eu informo o Codigo de rastreio na busca de status de entrega
    Então o resultado deve ser o:
      | CodigoDeRastreamento | AA123456789BR |
      | Status      | Sucesso  |
      | DadosFrete  | R$ 22,00   |
      | Tempo       | 3 dias     |
    E armazena essa informação no banco de dados

  Cenário: Consultar uma entrega com Codigo de rastreamento invalido.
    Dado Eu tenho um Codigo de rastreio invalido:
      | codigorastreio | 123 |
    Quando eu informo o Codigo de rastreio na busca de status de entrega  
    Então uma excecao deve ser lancada com erro "Codigo de rastreio invalido"

  Cenário: Servico Consulta Status Entrega nao responde
      Dado Eu tenho um Codigo de rastreio valido:
      | codigorastreio | AA123456789BR |
    Quando eu informo o Codigo de rastreio na busca de status de entrega
    E o servidor demora a responder
    Então uma excecao deve ser lancada com erro "Servico indisponivel"
