CREATE TABLE public.cliente
(
    id SERIAL,
    data_nascimento date NOT NULL,
    idade integer,
    nome character varying(120) COLLATE pg_catalog."default",
    sexo character varying(10) COLLATE pg_catalog."default" NOT NULL,
    cidade_id bigint NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (id),
    CONSTRAINT fkc2150e1t4hbr2owxjx1smbcwc FOREIGN KEY (cidade_id)
        REFERENCES public.cidade (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.cliente
    OWNER to postgres;
  
INSERT INTO public.cliente(nome, data_nascimento, sexo, idade, cidade_id) VALUES('José da Silva','1982-08-20', 'M', 38, 1);
INSERT INTO public.cliente(nome, data_nascimento, sexo, idade, cidade_id) VALUES('Maria Shuchindter','1985-02-15', 'F', 35, 2);