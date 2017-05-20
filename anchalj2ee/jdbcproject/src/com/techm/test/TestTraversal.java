package com.techm.test;

import com.techm.daos.UserDAO;
import com.techm.daos.impl.UserDAOImpl;

public class TestTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
UserDAO userDao=new UserDAOImpl();
userDao.getallUsersforDBTraverse();
	}

}
