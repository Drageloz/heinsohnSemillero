/*Creacion de la tabla ROL con columnas ROL_ID(como llave primaria), ROL_NOMBRE, ROL_ID_PERSONA, ROL_ESTADO*/
CREATE TABLE "DB_SEMILLERO"."PERSONA" 
(	"PERSONA_ID" NUMBER(3,0) NOT NULL ENABLE,
"PERSONA_NOMBRE" VARCHAR2(50 BYTE) NOT NULL  ENABLE,
"PERSONA_TIPO_DOCUMENTO" VARCHAR2(50 BYTE) NOT NULL  ENABLE,
/*Se permite ingresa hasta una longitud de 20 numeros, debido a posibles disposiciones en otros paises*/
"PERSONA_NUMERO_DOCUMENTO" NUMBER(20,0) NOT NULL ENABLE, 
"PERSONA_FECHA_NACIMIENTO" DATE NOT NULL  ENABLE,
CONSTRAINT "PERSONA_PK" PRIMARY KEY ("PERSONA_ID"),
CONSTRAINT "PERSONA_TIPO_DOCUMENTO_CHECK" CHECK (PERSONA_TIPO_DOCUMENTO IN ('CC', 'TI','EXT'))
);

/*Se agregan comentarios sobre información de cada columna*/
comment on column PERSONA.PERSONA_ID is 'Identificador unico de la persona que realiza la compra';
comment on column PERSONA.PERSONA_NOMBRE is 'Nombre de la persona que compra';
comment on column PERSONA.PERSONA_TIPO_DOCUMENTO is 'tipo del documento de identificacion de la persona, está definido como CC, TI, EXT';
comment on column PERSONA.PERSONA_NUMERO_DOCUMENTO is 'Numero del documento de identidad de la persona que compra';
comment on column PERSONA.PERSONA_FECHA_NACIMIENTO is 'fecha de nacimiento de la persona que compra';

/*Se crea secuencia para incrementos que se usara en PERSONA_ID*/
CREATE SEQUENCE "DB_SEMILLERO"."SEC_PERSONA" MINVALUE 1 START WITH 1  INCREMENT BY 1 NOCACHE;
