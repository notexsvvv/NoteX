create database NoteX;
show databases;
use  NoteX;
create table login_info
(
	userid int not null auto_increment,
    username varchar (225) not null,
    email varchar (225) not null,
    password varchar (50) not null,
    primary key (userid)
    );
    insert into login_info (username , email, password ) values ("test","test@123","test@123");
    select * from login_info;
    use Notex;
    create table UserUnderReview
(	userid int not null auto_increment,
	fullname varchar (225) not null ,
		username varchar (225) not null ,
		email varchar (225) not null,
		linkedin varchar (225),
		mobile varchar (10) ,
		usertype text (25) not null ,
		collegeid mediumblob not null,
		password varchar (225) not null,
		terms text (10) not null,
    primary key (userid)
    );
    select * from UserUnderReview;
    -- delete  from UserUnderReview where userid = 2;
   -- alter user root@localhost identified by 'root';
    
