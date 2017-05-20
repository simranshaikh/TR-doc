CREATE OR REPLACE procedure getUserByUserName(p_username IN user_tbl.username%TYPE,o_firstname OUT user_tbl.firstname%TYPE,
o_lastname OUT user_tbl.lastname%TYPE )
IS
BEGIN
	SELECT firstname,lastname INTO o_firstname ,o_lastname 
	from user_tbl where username = p_username;
END;
