##Limpeza de Banco de Dados para implementação
delete from item_venda;
delete from venda;
delete from item_lancamento;
delete from lancamento;
delete from item_locacao;
delete from locacao;
delete from item_pacote_promocional;
delete from pacote_promocional;
delete from promocao_locacao;
delete from promocao_devolucao;
delete from lancamento_conta;
delete from copia;
delete from objeto;
delete from diaria;
delete from genero;
delete from telefone;
delete from dependente;
delete from cliente;
delete from produto;
delete from fornecedor;





##Resetar o inicio do AUTO_INCREMENT das tabelas deletadas
ALTER TABLE `locadora`.`item_venda` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`lancamento_conta` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`venda` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`item_lancamento` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`lancamento` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`item_locacao` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`locacao` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`item_pacote_promocional` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`pacote_promocional` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`promocao_locacao` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`promocao_devolucao` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`diaria` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`telefone` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`dependente` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`cliente` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`produto` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`fornecedor` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`copia` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`objeto` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`venda` AUTO_INCREMENT = 1 ;
ALTER TABLE `locadora`.`genero` AUTO_INCREMENT = 1 ;

