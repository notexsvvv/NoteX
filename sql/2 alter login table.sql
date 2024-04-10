use notex;
Select * from login_info ;
DELETE FROM login_info WHERE userid=2 ;
ALTER TABLE login_info
ADD usertype text (10)  not null;
ALTER TABLE login_info AUTO_INCREMENT = 1;
insert into login_info ( username , email ,password,usertype ) values  
( "admin" , "admin@123.gmail.com", "admin" , "admin") ,
( "teacher","teacher@123.gmail.com","teacher","teacher"),
( "student", "student@123.gamil.com" ,"student" ,"student");