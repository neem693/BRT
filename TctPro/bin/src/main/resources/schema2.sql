
drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);
 
drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);
 
drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication  VARBINARY,
  refresh_token VARCHAR(255)
);
 
drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication  VARBINARY
);
 
drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(255), authentication  VARBINARY
);
 
drop table if exists oauth_approvals;
create table oauth_approvals (
    userId VARCHAR(255),
    clientId VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);
 
drop table if exists ClientDetails;
create table ClientDetails (
  appId VARCHAR(255) PRIMARY KEY,
  resourceIds VARCHAR(255),
  appSecret VARCHAR(255),
  scope VARCHAR(255),
  grantTypes VARCHAR(255),
  redirectUrl VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(255)
);


drop table if exists TYPE1;
create table TYPE1( 
	TYPE1_ID BIGINT primary key,
	TYPE1_NAME VARCHAR(255)
);

INSERT INTO type1(type1_id,type1_name) VALUES(1,'보는 것');
INSERT INTO type1(type1_id,type1_name) VALUES(2,'듣는 것');
INSERT INTO type1(type1_id,type1_name) VALUES(3,'하는 것');

drop table if exists TYPE2;
create table TYPE2( 
	TYPE2_ID BIGINT primary key,
	TYPE2_NAME VARCHAR(255),
	TYPE1_ID BIGINT,
    FOREIGN KEY (TYPE1_ID ) REFERENCES TYPE1(TYPE1_ID)
);

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


