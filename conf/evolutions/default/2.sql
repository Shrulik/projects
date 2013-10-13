# --- Sample dataset

# --- !Ups

insert into project (id,name, description, votes) values (  9,'Ninja turtles tribute site','What it sounds like', 0 );
insert into project (id,name, description, votes) values (  10,'Coffee bags startup','Why should those tea bastards  enjoy progress alone ? ', 0 );
insert into project (id,name, description, votes) values (  11,'Haskell support event','More people should know about Haskell', 2 );
insert into project (id,name, description, votes) values (  12,'הפסקת התמיכה בעברית בצה"ל',
'זאת ממש טרחה לבנות אתרים בשפה המציקה הזאת, אפשר לעבור לכל שפה שהיא בכיוון סטנדרטי. אם לא זה אז לפחות לשפר תמיכה בשפה ב Intellij', 3 );


# --- !Downs

delete from project;
