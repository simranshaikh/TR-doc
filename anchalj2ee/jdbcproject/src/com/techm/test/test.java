package com.techm.test;

import java.util.List;

import com.techm.daos.UserDAO;
import com.techm.daos.impl.UserDAOImpl;
import com.techm.models.User;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
UserDAO userDao=new UserDAOImpl();
userDao.getUsersUsingCursor("a");
//User user=new User();
//user.setUserName("ameya@abc");
//user.setPassword("ameya1111");
/*
boolean isValid=userDao.validateUser(user);
if(isValid){
	System.out.println("user is valid");
	
}
else{
	System.out.println("-----------------------INVALID USERNAME OR PASSWORD ---------------------");
}*/
/*List<User>userList=userDao.getallUsers();
if(userList.size()==0){
	System.out.println("no users found");
}
else{
	for(User user : userList){
		System.out.println(user);
	}
}*/
/*
User user=userDAO.getUser("ameya@abc.com");
if(user!=null){
System.out.println(user);
}else{
	System.out.println("user with username"+userName+"not Found...");
}
*/

//User user1=new User("anchal","smita","anchal@abc.com","anchal1234","8765432123","anchal@abc",27);
//User user2=new User("kalpesh","saha","saha@abc.com","saha1234","9876534321","sah@abc",27);
//User user3=new User("avani","joshi","avani@abc.com","avani1234","9136534321","ava@abc",25);
//User newUser=new User("ameya","joshi","ameya@abc.com","ameya1111","92222222222","ameya.j@abc",38);
//userDao.addUser(user1);
//userDao.addUser(user2);
//userDao.addUser(user3);
//userDao.removeUser("anchal@abc.com");
//userDao.updateUser(newUser);




    }

}
