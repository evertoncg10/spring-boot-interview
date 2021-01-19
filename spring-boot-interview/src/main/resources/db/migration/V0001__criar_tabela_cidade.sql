CREATE TABLE public.cidade
(
    id SERIAL,
    nome character varying(100) COLLATE pg_catalog."default",
    estado character varying(2) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT endereco_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.cidade
    OWNER to postgres;
  
INSERT INTO public.cidade(nome, estado) VALUES('Blumenau','SC');
INSERT INTO public.cidade(nome, estado) VALUES('Passo Fundo','RS');
INSERT INTO public.cidade(nome, estado) VALUES('Curitiba','PR');