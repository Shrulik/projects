# --- First database schema

# --- !Ups

create table quote (
  id                 bigint not null,
  source             varchar(255),
  text               varchar(1000),
  constraint pk_quote primary key (id))
;

create sequence quote_seq start with 1000;

insert into quote (id, source, text) values (  9, 'Chris Heilmann', 'Java is to JavaScript what Car is to Carpet.' );
insert into quote (id, source, text) values (  10,'Edsger W. Dijkstra','If debugging is the process of removing software bugs, then programming must be the process of putting them in.' );
insert into quote (id, source, text) values (  11,'Stan Kelly-Bootle',' Should array indices start at 0 or 1? My compromise of 0.5 was rejected without, I thought, proper consideration.');
insert into quote (id, source, text) values (  12,'Brian Kernighan', 'Debugging is twice as hard as writing the code in the first place. Therefore, if you write the code as cleverly as possible, you are, by definition, not smart enough to debug it.');
insert into quote (id, source, text) values (  13,'Eagleson''s law', 'Any code of your own that you haven''t looked at for six or more months might as well have been written by someone else.');
insert into quote (id, source, text) values (  14,'Edsger W. Dijkstra', 'Simplicity is prerequisite for reliability.');
insert into quote (id, source, text) values (  15,'C.A.R. Hoare', 'At first I hoped that such a technically unsound project would collapse but I soon realized it was doomed to success. Almost anything in software can be implemented, sold, and even used given enough determination. There is nothing a mere scientist can say that will stand against the flood of a hundred million dollars. But there is one quality that cannot be purchased in this way -and that is reliability. The price of reliability is the pursuit of the utmost simplicity. It is a price which the very rich find most hard to pay.');
insert into quote (id, source, text) values (  16,'Paul Graham', 'The object-oriented model makes it easy to build up programs by accretion. What this often means, in practice, is that it provides a structured way to write spaghetti code.');
insert into quote (id, source, text) values (  17,'Autrijus Tang', 'Haskell is faster than C++, more concise than Perl, more regular than Python, more flexible than Ruby, more typeful than C#, more robust than Java, and has absolutely nothing in common with PHP.');
insert into quote (id, source, text) values (  18,'חיים נחמן ביאליק', '[על הסיגריה:] בצד אחד אש, בצד שני טיפש ובאמצע - עשב יבש');


# --- !Downs

--delete from quote;

drop table if exists quote;

drop sequence if exists quote_seq;