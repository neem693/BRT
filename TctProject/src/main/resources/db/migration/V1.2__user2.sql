DROP TABLE IF EXISTS USERS2;
CREATE TABLE USERS2(
	user_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	first_name VARCHAR(20),
	last_name VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;
