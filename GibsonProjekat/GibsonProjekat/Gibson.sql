/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     1/26/2021 5:13:28 PM                         */
/*==============================================================*/


drop table if exists CIVIJA;

drop table if exists DELOVI;

drop table if exists GITARA;

drop table if exists KOBILICA;

drop table if exists MANDOLINA;

drop table if exists PRODAJA;

drop table if exists PROIZVOD;

drop table if exists RELATIONSHIP_1;

drop table if exists RELATIONSHIP_2;

drop table if exists RELATIONSHIP_3;

drop table if exists TELO;

drop table if exists ZICA;

/*==============================================================*/
/* Table: CIVIJA                                                */
/*==============================================================*/
create table CIVIJA
(
   DELOVI_ID            int not null,
   CIVIJA_ID            int not null,
   DELOVI_DATUMIZRADE   date,
   DELOVI_CENA          int,
   CIVIJA_TIP           int,
   CIVIJA_MARKA         text,
   CIVIJA_VELICINA      int,
   primary key (DELOVI_ID, CIVIJA_ID)
);

/*==============================================================*/
/* Table: DELOVI                                                */
/*==============================================================*/
create table DELOVI
(
   DELOVI_ID            int not null,
   DELOVI_DATUMIZRADE   date,
   DELOVI_CENA          int,
   primary key (DELOVI_ID)
);

/*==============================================================*/
/* Table: GITARA                                                */
/*==============================================================*/
create table GITARA
(
   PROIZVOD_ID          int not null,
   GITARA_ID            int not null,
   PROIZOVD_CENA        int,
   primary key (PROIZVOD_ID, GITARA_ID)
);

/*==============================================================*/
/* Table: KOBILICA                                              */
/*==============================================================*/
create table KOBILICA
(
   DELOVI_ID            int not null,
   KOBILICA_ID          int not null,
   DELOVI_DATUMIZRADE   date,
   DELOVI_CENA          int,
   KOBILICA_MARKA       text,
   primary key (DELOVI_ID, KOBILICA_ID)
);

/*==============================================================*/
/* Table: MANDOLINA                                             */
/*==============================================================*/
create table MANDOLINA
(
   PROIZVOD_ID          int not null,
   MANDOLINA_ID         char(10) not null,
   PROIZOVD_CENA        int,
   primary key (PROIZVOD_ID, MANDOLINA_ID)
);

/*==============================================================*/
/* Table: PRODAJA                                               */
/*==============================================================*/
create table PRODAJA
(
   PRODAJA_ID           int not null,
   PRODAJA_LOKACIJA     text,
   PROAJA_DATUM         date,
   primary key (PRODAJA_ID)
);

/*==============================================================*/
/* Table: PROIZVOD                                              */
/*==============================================================*/
create table PROIZVOD
(
   PROIZVOD_ID          int not null,
   PROIZOVD_CENA        int,
   primary key (PROIZVOD_ID)
);

/*==============================================================*/
/* Table: RELATIONSHIP_1                                        */
/*==============================================================*/
create table RELATIONSHIP_1
(
   PROIZVOD_ID          int not null,
   GITARA_ID            int not null,
   DELOVI_ID            int not null,
   primary key (PROIZVOD_ID, GITARA_ID, DELOVI_ID)
);

/*==============================================================*/
/* Table: RELATIONSHIP_2                                        */
/*==============================================================*/
create table RELATIONSHIP_2
(
   PROIZVOD_ID          int not null,
   MANDOLINA_ID         char(10) not null,
   DELOVI_ID            int not null,
   primary key (PROIZVOD_ID, MANDOLINA_ID, DELOVI_ID)
);

/*==============================================================*/
/* Table: RELATIONSHIP_3                                        */
/*==============================================================*/
create table RELATIONSHIP_3
(
   PRODAJA_ID           int not null,
   PROIZVOD_ID          int not null,
   primary key (PRODAJA_ID, PROIZVOD_ID)
);

/*==============================================================*/
/* Table: TELO                                                  */
/*==============================================================*/
create table TELO
(
   DELOVI_ID            int not null,
   TELO_ID              int not null,
   DELOVI_DATUMIZRADE   date,
   DELOVI_CENA          int,
   TELO_TIP             int,
   TELO_VELICINA        int,
   primary key (DELOVI_ID, TELO_ID)
);

/*==============================================================*/
/* Table: ZICA                                                  */
/*==============================================================*/
create table ZICA
(
   DELOVI_ID            int not null,
   ZICA_ID              int not null,
   DELOVI_DATUMIZRADE   date,
   DELOVI_CENA          int,
   ZICA_TIP             int,
   primary key (DELOVI_ID, ZICA_ID)
);

alter table CIVIJA add constraint FK_INHERITANCE_4 foreign key (DELOVI_ID)
      references DELOVI (DELOVI_ID) on delete restrict on update restrict;

alter table GITARA add constraint FK_INHERITANCE_5 foreign key (PROIZVOD_ID)
      references PROIZVOD (PROIZVOD_ID) on delete restrict on update restrict;

alter table KOBILICA add constraint FK_INHERITANCE_3 foreign key (DELOVI_ID)
      references DELOVI (DELOVI_ID) on delete restrict on update restrict;

alter table MANDOLINA add constraint FK_INHERITANCE_6 foreign key (PROIZVOD_ID)
      references PROIZVOD (PROIZVOD_ID) on delete restrict on update restrict;

alter table RELATIONSHIP_1 add constraint FK_RELATIONSHIP_1 foreign key (PROIZVOD_ID, GITARA_ID)
      references GITARA (PROIZVOD_ID, GITARA_ID) on delete restrict on update restrict;

alter table RELATIONSHIP_1 add constraint FK_RELATIONSHIP_4 foreign key (DELOVI_ID)
      references DELOVI (DELOVI_ID) on delete restrict on update restrict;

alter table RELATIONSHIP_2 add constraint FK_RELATIONSHIP_2 foreign key (PROIZVOD_ID, MANDOLINA_ID)
      references MANDOLINA (PROIZVOD_ID, MANDOLINA_ID) on delete restrict on update restrict;

alter table RELATIONSHIP_2 add constraint FK_RELATIONSHIP_5 foreign key (DELOVI_ID)
      references DELOVI (DELOVI_ID) on delete restrict on update restrict;

alter table RELATIONSHIP_3 add constraint FK_RELATIONSHIP_3 foreign key (PRODAJA_ID)
      references PRODAJA (PRODAJA_ID) on delete restrict on update restrict;

alter table RELATIONSHIP_3 add constraint FK_RELATIONSHIP_6 foreign key (PROIZVOD_ID)
      references PROIZVOD (PROIZVOD_ID) on delete restrict on update restrict;

alter table TELO add constraint FK_INHERITANCE_1 foreign key (DELOVI_ID)
      references DELOVI (DELOVI_ID) on delete restrict on update restrict;

alter table ZICA add constraint FK_INHERITANCE_2 foreign key (DELOVI_ID)
      references DELOVI (DELOVI_ID) on delete restrict on update restrict;

