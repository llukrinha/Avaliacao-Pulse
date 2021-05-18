--Marcas--
INSERT INTO pa02_marca (pa02_cod_marca, pa02_descricao)
VALUES (1, 'Kimimo'),
       (2, 'Qualy'),
       (3, 'Coca-Cola'),
       (4, 'Bosch'),
       (5, 'Itambé'),
       (6, 'Rosa Branca'),
       (7, 'Sutter Home'),
       (8, 'Doriana'),
       (9, 'União');
ALTER SEQUENCE public.PA02_MARCA_SEQ RESTART WITH 10;

--Produtos --
INSERT INTO pa01_produto (pa01_cod_produto, pa01_descricao, pa01_valor_unitario,
                          pa01pa02_cod_marca)
VALUES (1, 'Leite', 4.90, 1),
       (2, 'Refrigerante', 6.95, 3),
       (3, 'Açucar', 3.50, 9),
       (4, 'Trigo', 2.80, 6),
       (5, 'Vinho', 70.00, 7),
       (6, 'Manteiga', 2.50, 8),
       (7, 'Café', 4.99, 1);
ALTER SEQUENCE public.PA01_PRODUTO_SEQ RESTART WITH 8;

--Endeereços--
INSERT INTO pa04_endereco (pa04_cod_endereco, pa04_cep, pa04_bairro, pa04_rua,
                           pa04_numero, pa04_complemento)
VALUES (1, '65086070', 'Anjo da Guarda', 'Rua da Juçara', 320, ''),
       (2, '65064220', 'Aurora', 'Rua Três', 239, 'Casa'),
       (3, '65600600', 'São Francisco', 'Travessa Paulo Afonso', 164, 'Casa'),
       (4, '65042888', 'Bom Jesus', 'Rua Maximiliano Nogueira', 221, ''),
       (5, '65917163', 'Boca da Mata', 'Rua dos Trabalhadores', 995, '');
ALTER SEQUENCE public.PA04_ENDERECO_SEQ RESTART WITH 6;

--Clientes --
INSERT INTO pa03_cliente (pa03_cod_cliente, pa03_nome, pa03_cpf, pa03_numero,
                          pa03_email, pa03pa04_cod_endereco)
VALUES (1, 'Luis Costa', '06198990001', '71987339079', 'luiscosta@email.com', 4),
       (2, 'Jairo Cardoso', '43193013072', '92988658966', 'jairocardoso@email.com', 1),
       (3, 'Juliana Borges', '36022723035', '63991850178', 'julianaborges@email.com', 2),
       (4, 'Victor Pereira', '47454327044', '61996497363', 'victorpereira@email.com', 5);
ALTER SEQUENCE public.PA02_MARCA_SEQ RESTART WITH 5;

--Transpostadoras--
INSERT INTO pa05_transportadora (pa05_cod_transportadora, pa05_nome, pa05_cnpj, pa05_frete_valor)
VALUES (1, 'TNT', '27890898000177', 25.00),
       (2, 'Correios', '41501890050', 10.00),
       (3, 'COMETAS', '74326290056', 35.00),
       (4, 'TRANSDEL LOG', '59028972030', 20.00),
       (5, 'RAPIDOBR', '87825243005', 15.00);
ALTER SEQUENCE public.PA05_TRANSPORTADORA_SEQ RESTART WITH 6;

--Tipo de Pagamentos--
INSERT INTO pa06_tipoPagamento (pa06_cod_tipoPagamento, pa06_descricao)
VALUES (1, 'Cartao'),
       (2, 'A vista'),
       (3, 'Boleto');
ALTER SEQUENCE public.PA06_TIPOPAGAMENTO_SEQ RESTART WITH 4;

--Carrinhos ' --
INSERT INTO pa08_carrinho (pa08_cod_carrinho, pa08pa03_cod_cliente, pa08_quantidadeItens, pa08_total)
VALUES (1, 3, 4, 250.00),
       (2, 2, 4, 85.50),
       (3, 4, 3, 69.99),
       (4, 2, 5, 425.90);
ALTER SEQUENCE public.PA08_CARRINHO_SEQ RESTART WITH 5;

--Compra Status' --
INSERT INTO pa11_compraStatus (pa11_cod_compraStatus, pa11_descricao)
VALUES (1, 'Finalizado'),
       (2, 'Em andamento'),
       (3, 'Aberto');
ALTER SEQUENCE public.PA11_COMPRASTATUS_SEQ RESTART WITH 4;

--Compras' --
INSERT INTO pa10_compra (pa10_cod_compra, pa10pa11_cod_compraStatus, pa10_codRastreio, pa10_numeroPedido)
VALUES (1, 3, 'CO254152758NR', '15645156616185'),
       (2, 2, 'CO645185214NR', '4665416554651654'),
       (3, 2, 'BR65245128NR', '8745164874985'),
       (4, 1, 'BR156341764BR', '561650321561');
ALTER SEQUENCE public.PA10_COMPRA_SEQ RESTART WITH 5;

--Pedidos' --
INSERT INTO pa09_pedido (pa09_cod_pedido, pa09pa01_cod_produto, pa09pa08_cod_carrinho, pa09_quantidadeItens,
                         pa09_total)
VALUES (1, 4, 4, 5, 46.00),
       (2, 6, 1, 2, 86.45),
       (3, 3, 4, 4, 54.25),
       (4, 2, 3, 2, 24.00);

ALTER SEQUENCE public.PA09_PEDIDO_SEQ RESTART WITH 5;
--Pagamentos--
INSERT INTO pa07_pagamento (pa07_cod_pagamento, pa07pa04_cod_endereco, pa07pa05_cod_transportadora,
                            pa07pa06_cod_tipoPagamento, pa07pa08_cod_carrinho, pa07pa10_cod_compra, pa07_total)
VALUES (1, 2, 1, 3, 1, 3, 250.00),
       (2, 5, 4, 1, 4, 4, 85.50),
       (3, 1, 3, 2, 3, 2, 69.99),
       (4, 5, 5, 2, 2, 3, 425.90),
       (5, 3, 2, 1, 3, 1, 300.50);
ALTER SEQUENCE public.PA07_PAGAMENTO_SEQ RESTART WITH 6;