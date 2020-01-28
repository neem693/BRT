
drop table if exists TYPE1;
create table TYPE1( 
	TYPE1_ID BIGINT primary key,
	TYPE1_NAME VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;;

INSERT INTO type1(type1_id,type1_name) VALUES(1,'보는 것');
INSERT INTO type1(type1_id,type1_name) VALUES(2,'듣는 것');
INSERT INTO type1(type1_id,type1_name) VALUES(3,'하는 것');

drop table if exists TYPE2;
create table TYPE2( 
	TYPE2_ID BIGINT primary key,
	TYPE2_NAME VARCHAR(255),
	TYPE1_ID BIGINT,
    FOREIGN KEY (TYPE1_ID ) REFERENCES TYPE1(TYPE1_ID)
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;

INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(1,'EPISODE',1);
INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(2,'MOVIE',1);
INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(3,'BOOK',1);
INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(4,'CARTOON',1);
INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(5,'ANIMATION',1);
INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(6,'SHOW',1);


INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(7,'MUSIC',2);
INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(8,'RADIO',2);


INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(9,'GAME',3);
INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(10,'UTILITY',3);
INSERT INTO type2(type2_id,type2_name,type1_id) VALUES(11,'EXAMINE',3);
