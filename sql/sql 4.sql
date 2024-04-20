 use notex;
 
 create table studentUser
(
	fullname varchar (225) not null ,
		username varchar (225) not null ,
		email varchar (225) not null,
		linkedin varchar (225),
		mobile varchar (10) ,
		usertype text (25) not null ,
		collegeid mediumblob not null,
		password varchar (225) not null,
		terms text (10) not null,
    primary key (username)
    );
    ALTER TABLE studentUser
ADD CONSTRAINT unique_username UNIQUE (username);
   
   select * from studentUser;
--  delete from studentUser where username = "ram";

    create table teacherUser
(
	fullname varchar (225) not null ,
		username varchar (225) not null ,
		email varchar (225) not null,
		linkedin varchar (225),
		mobile varchar (10) ,
		usertype text (25) not null ,
		collegeid mediumblob not null,
		password varchar (225) not null,
		terms text (10) not null,
    primary key (username)
    );
    ALTER TABLE teacherUser
ADD CONSTRAINT unique_username UNIQUE (username);
       select * from teacherUser;
       -- delete from teacherUser where username = "assss";
       
       
       select* from login_info;