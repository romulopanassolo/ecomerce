# ecomerce
servicos de e-comerce 

O projeto consiste em microserviços que permite o gerenciamento de um e-commerce

Cadatro de itens

Para realizar o cadastro de Itens use link abaixo
http://localhost:8080/api/item/cadastra

Sendo um POST, no body pode se usar o exemplo abaixo

{
"nome": "arroz",
"descricao": "tio joao",
"valor": 10
}

Criar um pedido

Para se criar um pedido use o link 

http://localhost:8080/api/pedido/criarPedido

Sendo um POST, no body pode se usar o exemplo abaixo

{
   "nomeCliente": "fulano",
   "dataPedido": null,
   "valorTotalPedido": 0,
   "formaPagamentoPedido": "CARTAO",
   "itemPedido": null,
   "statusPedido": "ABERTO"
}

Obs: na criação valores defaults são persistido na base como a data atual por exemplo


Adicionando itens a um pedido

para adicionar itens use o link abaixo

http://localhost:8080/api/itemPedido/cadastra

Sendo um POST, no body pode se usar o exemplo abaixo

{
 
   "item": {
      "id": 1,
      "nome": "arroz",
      "descricao": "tio joao",
      "valor": 10
   },
   "pedido": {
      "id": 1,
      "nomeCliente": "romulo",
      "dataPedido": 1492707315613,
      "valorTotalPedido": null,
      "formaPagamentoPedido": "CARTAO",
      "itemPedido": null,
      "statusPedido": "ABERTO"
   },
   "quantidade": 2
}


Encerrar um pedido

Para encerrar um pedido use o link abaixo

http://localhost:8080/api/pedido/fechamento/1

onde 1 é o id do pedido
Sendo um PUT, nenhuma informação no body é necessaria

após o fechamento o status do pedido passa a ser fechado e o valorTotalPedido é atualizado




Alterar o valor de um Item

para alterar o valor use o link abaixo

http://localhost:8080/api/item/altera/{id}/{valor}

O valor do item é atualizado com o valor para o id informado.



Busca o Item pelo id

Para buscar o item use o link abaixo

http://localhost:8080/api/item/search/{id}




Faz a consulta pelo autocomplete

Para buscar os nomes de itens use o link abaixo

http://localhost:8080/api/autoComplete/{nome}

onde nome é o nome do item a ser encontrado









