create table personaje (
  pers_id number(10) not null,
  pers_nombre varchar2(50) not null,
  pers_id_comic number(3) not null,
  pers_estado varchar2(50 char) not null,
  pers_superpoder varchar2(200 char) not null,
  constraint "pers_nombre_UNIQUE" unique (pers_nombre),
  constraint "personaje_estado_CHK" check (pers_estado IN('ACTIVO','INACTIVO')),
  constraint "PK_personaje" PRIMARY KEY (pers_id)
);

 

create sequence "SEC_PERSONAJE" minvalue 1 start with 1 increment by 2;

 

ALTER TABLE personaje
ADD CONSTRAINT "FK_PERSONAJE_ID"
   FOREIGN KEY (pers_id_comic)
   REFERENCES comic (SCID);

 


insert into personaje (pers_id, pers_nombre, pers_id_comic, pers_estado, pers_superpoder)
    VALUES (SEC_PERSONAJE.nextval, 'BATMAN',4, 'ACTIVO', 'MILLONARIO');
  commit;