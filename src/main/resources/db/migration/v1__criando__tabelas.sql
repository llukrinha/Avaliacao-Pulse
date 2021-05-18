CREATE SEQUENCE PA01_PRODUTO_SEQ cycle;
create table pa01_produto
(
    pa01_cod_produto    bigint       not null default nextval('public.PA01_PRODUTO_SEQ'::regclass),
    pa01pa02_cod_marca  bigint       not null,
    pa01_descricao      varchar(255) not null,
    pa01_valor_unitario numeric      not null,
    constraint pa01_produto_pk primary key (pa01_cod_produto)
);

CREATE SEQUENCE PA02_MARCA_SEQ cycle;
create table pa02_marca
(
    pa02_cod_marca bigint       not null default nextval('public.PA02_MARCA_SEQ'::regclass),
    pa02_descricao varchar(255) not null,
    constraint pa02_marca_pk primary key (pa02_cod_marca)
);

alter table pa01_produto
    add constraint fkpa01_produto_marca foreign key (pa01pa02_cod_marca)
        references pa02_marca (pa02_cod_marca)
        on delete restrict on update restrict;

CREATE SEQUENCE PA03_CLIENTE_SEQ cycle;
create table pa03_cliente
(
    pa03_cod_cliente      bigint       not null default nextval('public.PA03_CLIENTE_SEQ'::regclass),
    pa03pa04_cod_endereco bigint       not null,
    pa03_nome             varchar(255) not null,
    pa03_cpf              varchar(15)  not null,
    pa03_numero           varchar(15)  null,
    pa03_email            varchar(70)  null,
    constraint pa03_cliente_pk primary key (pa03_cod_cliente)
);

CREATE SEQUENCE PA04_ENDERECO_SEQ cycle;
create table pa04_endereco
(
    pa04_cod_endereco bigint       not null default nextval('public.PA04_ENDERECO_SEQ'::regclass),
    pa04_cep          varchar(10)  not null,
    pa04_bairro       varchar(255) not null,
    pa04_rua          varchar(255) not null,
    pa04_numero       integer      not null,
    pa04_complemento  varchar(35),
    constraint pa04_endereco_pk primary key (pa04_cod_endereco)
);

alter table pa03_cliente
    add constraint fkpa03_cliente_endereco foreign key (pa03pa04_cod_endereco)
        references pa04_endereco (pa04_cod_endereco)
        on delete restrict on update restrict;

CREATE SEQUENCE PA05_TRANSPORTADORA_SEQ cycle;
create table pa05_transportadora
(
    pa05_cod_transportadora bigint       not null default nextval('public.PA05_TRANSPORTADORA_SEQ'::regclass),
    pa05_nome               varchar(255) not null,
    pa05_cnpj               varchar(15)  not null,
    pa05_frete_valor        numeric      not null,
    constraint pa05_transportadora_pk primary key (pa05_cod_transportadora)
);

CREATE SEQUENCE PA06_TIPOPAGAMENTO_SEQ cycle;
create table pa06_tipoPagamento
(
    pa06_cod_tipoPagamento bigint       not null default nextval('public.PA06_TIPOPAGAMENTO_SEQ'::regclass),
    pa06_descricao         varchar(50) not null,
    constraint pa06_tipoPagamento_pk primary key (pa06_cod_tipoPagamento)
);

CREATE SEQUENCE PA07_PAGAMENTO_SEQ cycle;
create table pa07_pagamento
(
    pa07_cod_pagamento bigint       not null default nextval('public.PA07_PAGAMENTO_SEQ'::regclass),
    pa07pa04_cod_endereco bigint not null ,
    pa07pa05_cod_transportadora bigint not null ,
    pa07pa06_cod_tipoPagamento bigint not null ,
    pa07pa08_cod_carrinho bigint not null ,
    pa07pa10_cod_compra bigint not null ,
    pa07_total        numeric not null,
    constraint pa07_pagamento_pk primary key (pa07_cod_pagamento)
);

CREATE SEQUENCE PA08_CARRINHO_SEQ cycle;
create table pa08_carrinho
(
    pa08_cod_carrinho bigint       not null default nextval('public.PA08_CARRINHO_SEQ'::regclass),
    pa08pa03_cod_cliente bigint not null ,
    pa08_quantidadeItens        integer not null,
    pa08_total numeric not null ,
    constraint pa08_carrinho_pk primary key (pa08_cod_carrinho)
);
alter table pa08_carrinho
    add constraint fkpa08_carrinho_cliente foreign key (pa08pa03_cod_cliente)
        references pa03_cliente(pa03_cod_cliente)
        on delete restrict on update restrict;


CREATE SEQUENCE PA09_PEDIDO_SEQ cycle;
create table pa09_pedido
(
    pa09_cod_pedido bigint       not null default nextval('public.PA09_PEDIDO_SEQ'::regclass),
    pa09pa01_cod_produto bigint not null ,
    pa09pa08_cod_carrinho bigint not null ,
    pa09_quantidadeItens        integer not null,
    pa09_total numeric not null ,
    constraint pa09_pedido_pk primary key (pa09_cod_pedido)
);

alter table pa09_pedido
    add constraint fkpa09_pedido_produto foreign key (pa09pa01_cod_produto)
        references pa01_produto(pa01_cod_produto),
    add constraint fkpa09_pedido_carrinho foreign key (pa09pa08_cod_carrinho)
        references pa08_carrinho(pa08_cod_carrinho)
        on delete restrict on update restrict;


CREATE SEQUENCE PA10_COMPRA_SEQ cycle;
create table pa10_compra
(
    pa10_cod_compra bigint       not null default nextval('public.PA10_COMPRA_SEQ'::regclass),
    pa10pa11_cod_compraStatus bigint not null ,
    pa10_codRastreio       varchar(20) not null,
    pa10_numeroPedido varchar(20)  not null,
    constraint pa10_compra_pk primary key (pa10_cod_compra)
);

CREATE SEQUENCE PA11_COMPRASTATUS_SEQ cycle;
create table pa11_compraStatus
(
    pa11_cod_compraStatus bigint       not null default nextval('public.PA11_COMPRASTATUS_SEQ'::regclass),
    pa11_descricao         varchar(30) not null,
    constraint pa11_compraStatus_pk primary key (pa11_cod_compraStatus)
);

alter table pa10_compra
add constraint fkpa10_compra_compraStatus foreign key (pa10pa11_cod_compraStatus)
        references pa11_compraStatus (pa11_cod_compraStatus)
        on delete restrict on update restrict;

alter table pa07_pagamento
    add constraint fkpa07_pagamento_endereco foreign key (pa07pa04_cod_endereco)
        references pa04_endereco(pa04_cod_endereco),
    add constraint fkpa07_pagamento_transportadora foreign key (pa07pa05_cod_transportadora)
        references pa05_transportadora(pa05_cod_transportadora),
    add constraint fkpa07_pagamento_tipoPagamento foreign key (pa07pa06_cod_tipoPagamento)
        references pa06_tipoPagamento(pa06_cod_tipoPagamento),
    add constraint fkpa07_pagamento_carrinho foreign key (pa07pa08_cod_carrinho)
        references pa08_carrinho(pa08_cod_carrinho),
    add constraint fkpa07_pagamento_compra foreign key (pa07pa10_cod_compra)
        references pa10_compra(pa10_cod_compra)
        on delete restrict on update restrict;