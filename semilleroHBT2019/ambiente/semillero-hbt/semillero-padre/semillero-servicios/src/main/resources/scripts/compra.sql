/*Creacion de la tabla ROL con columnas ROL_ID(como llave primaria), ROL_NOMBRE, ROL_ID_PERSONA, ROL_ESTADO*/
CREATE TABLE "DB_SEMILLERO"."COMPRA" 
(	"COMPRA_ID" NUMBER(3,0) NOT NULL ENABLE,
"COMPRA_COMIC_COMPRADO" NUMBER(3,0) NOT NULL  ENABLE,
"COMPRA_ID_PERSONA" NUMBER(20,0) NOT NULL ENABLE,
"COMPRA_FECHA_VENTA" DATE NOT NULL  ENABLE, 
CONSTRAINT "COMPRA_PK" PRIMARY KEY ("COMPRA_ID")
);

/*Se agregan comentarios sobre información de cada columna*/
comment on column COMPRA.COMPRA_ID is 'Identificador unico de la compra';
comment on column COMPRA.COMPRA_COMIC_COMPRADO is 'Nombre del comic comprado';
comment on column COMPRA.COMPRA_ID_PERSONA is 'Identificación de la persona que realizó la compra';
comment on column COMPRA.COMPRA_FECHA_VENTA is 'fecha de venta del comic';

/*Se crea secuencia para incrementos que se usara en COMPRA_ID*/
CREATE SEQUENCE "DB_SEMILLERO"."SEC_COMPRA" MINVALUE 1 START WITH 1  INCREMENT BY 1 NOCACHE;

/*Modificación de tabla, se agrega FOREIGN KEY entre ROL.ROL_ID_PERS y PERSONAJE.PERS_ID*/
ALTER TABLE COMPRA
ADD CONSTRAINT "FK_COMPRA_ID_PERSONA"
   FOREIGN KEY (COMPRA_ID_PERSONA)
   REFERENCES PERSONA (PERSONA_ID);
   
/*Modificación de tabla, se agrega FOREIGN KEY entre ROL.ROL_ID_PERS y PERSONAJE.PERS_ID*/
ALTER TABLE COMPRA
ADD CONSTRAINT "FK_COMPRA_COMIC_COMPRADO"
   FOREIGN KEY (COMPRA_COMIC_COMPRADO)
   REFERENCES COMIC (SCID);
