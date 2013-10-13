# --- First database schema

# --- !Ups

create table project (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(500),
  votes                     bigint,
  constraint pk_project primary key (id))
;

create sequence project_seq start with 1000;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists project;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists project_seq;