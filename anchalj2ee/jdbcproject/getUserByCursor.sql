CREATE OR REPLACE procedure getUserByCursor(p_username IN user_tbl.username%TYPE,o_user OUT SYS_REFCURSOR )
IS
BEGIN
	OPEN o_user FOR
	SELECT * from user_tbl where username like p_username || '%';
END;
/
