# LaboratorioI-Prova2017
Um exemplo de solução para a questão da prova

# A prova
__O Problema__: Mussum deseja controlar a entrada de “mé” (bebida) no estoque do seu boteco. O produto (mé), possuirá uma marca, nome, volume (em ml), valor de compra, valor de venda, e o valor por litro do produto (que deve ser calculado pelo sistema, e não inserido pelo usuário). A aplicação deve tornar possível que o usuário execute algumas ações: adicionar um produto produto ao estoque (comprar), pesquisar a disponibilidade de um produto, vender um produto. O boteco além de possuir várias bebidas, possui um valor em caixa, que será utilizado para realizar a compra dos produtos e será incrementado após a venda.

__Regras e dicas:__
* O ideal é que a aplicação possua um array de produtos. Como segunda opção, considere que exista apenas 1 produto e será manipulado apenas os atributos do mesmo.
* O valor em caixa na inicialização do programa deverá ser R$ 1.000,00 para fluxo
* O estoque (quantidade) de um produto não pode ficar negativo
* Quando um produto é vendido o valor da vende deverá ir para o “valor em caixa”
* Um produto somente poderá ser comprado caso haja dinheiro em caixa para realizar a compra
Novas funcionalidades podem ser adicionadas na aplicação
* A aplicação deverá ser dividida em camadas (entidade-view-principal) e respeitando rigorosamente as atribuições de cada uma delas
* A entidade deve possuir 2 construtores: Um que exige a inicialização do nome, marca e volume e um construtor sem argumentos
* O toString da entidade deve retornar o valor de todos os atributos da classe
* Os dados devem se manter consistentes e validados em qualquer situação
* As regras de encapsulamento devem ser seguidas rigorosamente
* Atente para entregar uma aplicação funcional, mesmo que não esteja completa
* Não existe um funcionamento esperado para a aplicação. Seja criativo mas sem fugir do tema e seguindo os padrões vistos em aula
