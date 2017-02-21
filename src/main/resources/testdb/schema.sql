drop table T_ACCOUNT if exists;

create table T_ACCOUNT (ID bigint identity primary key, NUMBER varchar(9),
                        NAME varchar(50) not null, BALANCE decimal(8,2), unique(NUMBER));
                        
ALTER TABLE T_ACCOUNT ALTER COLUMN BALANCE SET DEFAULT 0.0;

drop table T_USER_PROFILE if exists;
               
CREATE TABLE T_USER_PROFILE (
   ID INTEGER NOT NULL,
   NAME VARCHAR(50) NOT NULL,
   AGE VARCHAR(50) NOT NULL,
   SEX VARCHAR(50) NOT NULL,
   ADDRESS VARCHAR(100) NOT NULL,
   PRIMARY KEY (ID)
);
        
