package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import models.User;

public class UserDaoImpl implements UserDao {
	//DataSource instantiation to create Driver class and set url
	private DataSource ds;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public int Save(User u) throws Exception {
		//open connection to save
		Connection cn = ds.getConnection();
		PreparedStatement ps = cn.prepareStatement("insert into user(name,email,password) values(?,?,?)");
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
		int i =ps.executeUpdate();
		System.out.println(i);
		cn.close();
		
		return i;
	}

	public boolean findLogInMatch(String email, String password) throws Exception {
		Connection cn = ds.getConnection();
		PreparedStatement ps = cn.prepareStatement("select * from user where email =? and password =?");
		ps.setString(1,email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		cn.close();
		return rs.next();
	}


	
	
}
