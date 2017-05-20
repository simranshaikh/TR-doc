package com.techm.daos.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import com.techm.daos.UserDAO;
import com.techm.models.User;

public  class UserDAOImpl implements UserDAO {
	private Connection con;
	private static final String conURL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String dbUserName="system";
	private static final String dbPassword="system";
	private static final String driverclass="oracle.jdbc.OracleDriver";
	public UserDAOImpl(){
		try{
			Class.forName(driverclass);
			System.out.println("+++++++Driver loaded+++++++++++++");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
			
		}
	}
	
	@Override
	public Connection getConnection() {
		try {
			con=DriverManager.getConnection(conURL,dbUserName,dbPassword);
			System.out.println("+++connect to DB++++++++++");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return con;
	}

	@Override
	public void closeConnection() {
		if(con!=null){
			try {
				con.close();
				System.out.println("+++++++connection to DB closed++++++++");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
    }
	@Override
	public boolean addUser(User user) {
		String SQL="Insert into user_tbl values(?,?,?,?,?,?,?)";
		boolean isAdded=false;
		getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.setString(1,user.getFirstName());
			ps.setString(2,user.getLastName());
			ps.setString(3,user.getUserName());
			ps.setString(4,user.getPassword());
			ps.setString(5,user.getCellNo());
			ps.setString(6,user.getEmail());
			ps.setInt(7,user.getAge());
			int cnt=ps.executeUpdate();
			if(cnt==1){
				isAdded=true;
				System.out.println("++++user added successfully++++++++++");
			}
				}catch (SQLException e){
					e.printStackTrace();
				}finally{
					closeConnection();
				}
		         return isAdded;
			}
		
	

	@Override
	public boolean updateUser(User user) {
		String SQL="update user_tbl set firstname=?,"
				+ "lastname=?,password=?,cellno=?"
				+ "email=?,age=?,"
				+ "where username=?";
		boolean isUpdated=false;
		getConnection();
		try{
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.clearParameters();
			ps.setString(1, user.getFirstName());
			ps.setString(2,user.getLastName());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getCellNo());
			ps.setString(5,user.getEmail());
			ps.setInt(6, user.getAge());
			ps.setString(7,user.getUserName());
			int cnt=ps.executeUpdate();
			if(cnt==1){
				isUpdated=true;
				System.out.println("++++++++user updated sucessfully+++++++++++");
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			closeConnection();
		
		}
		return isUpdated;
	}

	@Override
	public boolean removeUser(String userName) {
	 String SQL="delete from user_tbl where username=?";
	 boolean isRemoved=false;
	 getConnection();
	 try{
		 PreparedStatement ps=con.prepareStatement(SQL);
		 ps.clearParameters();
		 ps.setString(1,userName);
		 int cnt=ps.executeUpdate();
		 if(cnt==1){
			 isRemoved=true;
			 System.out.println("+++++++++user deleted sucessfully++++++++++++++");
		 }
	 }catch(SQLException e){
		 e.printStackTrace();
	 
	 }finally{
		 closeConnection();
	 }
		return isRemoved;
	}

	@Override
	public User getUser(String userName) {
		String SQL="select * from user_tbl where username=?";
		User user=null;
		getConnection();
		try{
			 PreparedStatement ps=con.prepareStatement(SQL);
			 ps.clearParameters();
			 ps.setString(1,userName);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()){
				 user=new User();
				 user.setFirstName(rs.getString("firstname"));
				 user.setLastName(rs.getString("lastname"));
				 user.setUserName(rs.getString("username"));
				 user.setPassword(rs.getString("password"));
				 user.setCellNo(rs.getString("cellno"));
				 user.setEmail(rs.getString("email"));
				 user.setAge(rs.getInt("age"));
				 /*
				 user.setFirstName(rs.getString(1));
				 user.setLastName(rs.getString(2));
				 user.setUserName(rs.getString(3));
				 user.setPassword(rs.getString(4));
				 user.setCellNo(rs.getString(5));
				 user.setEmail(rs.getString(6));
				 user.setAge(rs.getInt(7));
				 */
				 }
				 
			 
		 }catch(SQLException e){
			 e.printStackTrace();
		 
		 }finally{
			 closeConnection();
		 }
		return user; 
	}

	@Override
	public  List<User> getallUsersUsingStatement() {
	String SQL="select * from user_tbl";
	ArrayList<User>userList=new ArrayList<User>();
	User user=null;
	getConnection();
	try{
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(SQL);
	while(rs.next()){
		user=new User();
		user.setFirstName(rs.getString("firstname"));
		 user.setLastName(rs.getString("lastname"));
		 user.setUserName(rs.getString("username"));
		 user.setPassword(rs.getString("password"));
		 user.setCellNo(rs.getString("cellno"));
		 user.setEmail(rs.getString("email"));
		 user.setAge(rs.getInt("age"));
		 userList.add(user);
	       }
	}catch (SQLException e){
		
		e.printStackTrace();
	
	}finally{
		closeConnection();
	}
	
		return userList;
	
	}
	
	@Override
	public List<User> getallUsers() {
	String SQL="select * from user_tbl";
	ArrayList<User>userList=new ArrayList<User>();
	User user=null;
	getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(SQL);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			user=new User();
			user.setFirstName(rs.getString("firstname"));
			 user.setLastName(rs.getString("lastname"));
			 user.setUserName(rs.getString("username"));
			 user.setPassword(rs.getString("password"));
			 user.setCellNo(rs.getString("cellno"));
			 user.setEmail(rs.getString("email"));
			 user.setAge(rs.getInt("age"));
			 userList.add(user);
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}finally{
		closeConnection();
	}
	
		return userList;
	}

	@Override
	public boolean validateUser(User user) {
		String SQL="select * from user_tbl where username=? and password=?";
		boolean isValid=false;
		getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.clearParameters();
			ps.setString(1, user.getUserName());
			ps.setString(1, user.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				isValid=true;
	        }
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		return isValid;
	}
	@Override
	public void  getallUsersforDBTraverse() {
		String SQL="select * from user_tbl";
		getConnection();
		try{
		PreparedStatement ps=con.prepareCall(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=ps.executeQuery();
		rs.first();
		System.out.println(rs.getString("firstname")+":"+rs.getShort("lastname"));
		rs.absolute(3);
		System.out.println(rs.getString("firstname")+":"+rs.getString("lastname"));
		rs.last();
		System.out.println(rs.getString("firstname")+":"+rs.getString("lastname"));
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally{
		closeConnection();
	}
}
	@Override
	public void getDBInfo() {
		getConnection();
		DatabaseMetaData dmd;
		try {
		dmd = con.getMetaData();
		System.out.println("Database Name :: "+dmd.getDatabaseProductName());
		System.out.println("Driver ::"+dmd.getDriverName());
		System.out.println("Database Version ::"+dmd.getDatabaseMajorVersion());
		ResultSet rs=dmd.getTables(null, null, null, null);
		while(rs.next()){
			System.out.println(rs.getString("TABLE_NAME"));
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
		}

	@Override
	public void getUserUsingStoredProc(String userName) {
		String SQL="{call getUserByUserName(?,?,?)}";
		getConnection();
		try {
			CallableStatement cs=con.prepareCall(SQL);
			cs.setString(1, userName);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.execute();
			String firstName=cs.getString(2);
			String lastName=cs.getString(3);
			System.out.println("First Name :: "+firstName+": Last Name ::"+lastName);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void getUsersUsingCursor(String startsWith) {
		String SQL="{call getUserByCursor(?,?)}";
		getConnection();
		try {
			CallableStatement cs=con.prepareCall(SQL);
			cs.setString(1, startsWith);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs=(ResultSet)cs.getObject(2);
			while(rs.next()){
			System.out.println(rs.getString("username")+":"+rs.getString("firstname")+":"+rs.getString("lastname"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
	}
	}
	}
