/*==============================================================*/
/* Table: inci                                          */
/*==============================================================*/
drop table if exists inci;

create table inci
(
   id               int not null auto_increment,
   name             text,
   primary key (id)
);


/*==============================================================*/
/* Table: tradeName                                      */
/*==============================================================*/
drop table if exists tradeName;

create table tradeName
(
   id               int not null auto_increment,
   name             text,
   primary key (id)
);