/*Creacion de la tabla ROL con columnas ROL_ID(como llave primaria), ROL_NOMBRE, ROL_ID_PERSONA, ROL_ESTADO*/
CREATE TABLE "DB_SEMILLERO"."ROL" 
(	"ROL_ID" NUMBER(3,0) NOT NULL ENABLE,
"ROL_NOMBRE" VARCHAR2(50 BYTE) NOT NULL  ENABLE,
"ROL_ID_PERS" NUMBER(3,0) NOT NULL ENABLE,
"ROL_ESTADO" VARCHAR2(50 BYTE) NOT NULL  ENABLE, 
CONSTRAINT "ROL_PK" PRIMARY KEY ("ROL_ID"),
CONSTRAINT "ROL_ESTADO_CHECK" CHECK (ROL_ESTADO IN ('ACTIVO', 'INACTIVO')),
CONSTRAINT "ROL_NOMBRE_UNIQUE" UNIQUE("ROL_NOMBRE")
);

/*Se agregan comentarios sobre información de cada columna*/
comment on column ROL.ROL_ID is 'Identificador unico del ROL';
comment on column ROL.ROL_NOMBRE is 'Nombre o titulo del ROL';
comment on column ROL.ROL_ESTADO is 'Estado del ROL, está definido como ACTIVO o INACTIVO';

/*Se crea secuencia para incrementos que se usara en ROL_ID*/
CREATE SEQUENCE "DB_SEMILLERO"."SEC_ROL" MINVALUE 1 START WITH 1  INCREMENT BY 1 NOCACHE;

/*Modificación de tabla, se agrega FOREIGN KEY entre ROL.ROL_ID_PERS y PERSONAJE.PERS_ID*/
ALTER TABLE rol
ADD CONSTRAINT "FK_ROL_ID"
   FOREIGN KEY (ROL_ID_PERS)
   REFERENCES personaje (PERS_ID);
