use notex;
Select * from login_info ;
ALTER TABLE login_info add COLUMN token VARCHAR(255);
ALTER TABLE login_info MODIFY userid INT;
ALTER TABLE login_info DROP PRIMARY KEY;
ALTER TABLE login_info ADD PRIMARY KEY (username);
ALTER TABLE login_info DROP userid;
UPDATE login_info SET token = "kdmdmd,dmdd " WHERE username ="admin";