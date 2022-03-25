INSERT INTO tb_departamento(nome) VALUES ('Compra');
INSERT INTO tb_departamento(nome) VALUES ('Campo');

INSERT INTO tb_funcionario(departamento_id, nome) VALUES (1, 'Pedro');
INSERT INTO tb_funcionario(departamento_id, nome) VALUES (1, 'Nonino');
INSERT INTO tb_funcionario(departamento_id, nome) VALUES (2, 'Ana');
INSERT INTO tb_funcionario(departamento_id, nome) VALUES (2, 'Derick');

INSERT INTO tb_produtor(nome, funcionario_id) VALUES ('Carlos', 3);
INSERT INTO tb_produtor(nome, funcionario_id) VALUES ('Cicero', 3);

INSERT INTO tb_localidade(estado, cidade, area, produtor_id) VALUES ('Paraná', 'Ponta Grossa', 10.500, 1);

INSERT INTO tb_localidade(estado, cidade, area, produtor_id) VALUES ('Paraná', 'Ipiranga', 8.500, 1);

INSERT INTO tb_localidade(estado, cidade, area, produtor_id) VALUES ('Paraná', 'Ponta Grossa', 12.500, 2);

INSERT INTO tb_pedido(produtor_id, funcionario_id, pago) VALUES (1, 1, false);

INSERT INTO tb_produto(descricao, valorunitario, qtddisponivel) VALUES ('Adubo', 190.50, 1000);
INSERT INTO tb_produto(descricao, valorunitario, qtddisponivel) VALUES ('Veneno', 1000.50, 0);

INSERT INTO tb_produtopedido(pedido_id, produto_id, qtd) VALUES (1, 1, 100);
INSERT INTO tb_produtopedido(pedido_id, produto_id, qtd) VALUES (1, 1, 200);

INSERT INTO tb_safra(produtor_id, funcionario_id, estimativa, ano) VALUES (1, 3, 20000, '2020');
INSERT INTO tb_safra(produtor_id, funcionario_id, estimativa, ano) VALUES (1, 3, 20000, '2021');
INSERT INTO tb_safra(produtor_id, funcionario_id, estimativa, ano) VALUES (2, 3, 30000, '2020');

INSERT INTO tb_classe(valor, nome, ano) VALUES (9.50, 'CO2', '2021');

INSERT INTO tb_classe(valor, nome, ano) VALUES (6.50, 'CL2', '2021');

INSERT INTO tb_fardo(classe_id, safra_id, funcionario_id, pago, peso) VALUES (1, 1, 1, TRUE, 60);

INSERT INTO tb_fardo(classe_id, safra_id, funcionario_id, pago, peso) VALUES (2, 2, 1, TRUE, 60);

INSERT INTO tb_fardo(classe_id, safra_id, funcionario_id, pago, peso) VALUES (2, 3, 2, TRUE, 60);
INSERT INTO tb_fardo(classe_id, safra_id, funcionario_id, pago, peso) VALUES (2, 3, 2, TRUE, 60);
