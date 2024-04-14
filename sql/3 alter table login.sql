use notex;
Select * from login_info ;
ALTER TABLE login_info add COLUMN token VARCHAR(255);
ALTER TABLE login_info MODIFY userid INT;
ALTER TABLE login_info DROP PRIMARY KEY;
ALTER TABLE login_info ADD PRIMARY KEY (username);
ALTER TABLE login_info DROP userid;
UPDATE login_info SET token = "kdmdmd,dmdd " WHERE username ="admin";

## new Query 14 - april run it  data 
use notex;
select * from userunderreview;
-- delete from userunderreview where userid =4; 

ALTER TABLE userunderreview
ADD CONSTRAINT unique_username UNIQUE (username);
ALTER TABLE userunderreview AUTO_INCREMENT = 1;
aLTER TABLE userunderreview MODIFY userid INT;
ALTER TABLE userunderreview DROP PRIMARY KEY;
ALTER TABLE userunderreview ADD PRIMARY KEY (username);



