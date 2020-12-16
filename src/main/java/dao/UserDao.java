package dao;

import models.User;

public interface UserDao {

	public int Save(User u) throws Exception;
	public User findBy(String name)throws Exception;
}
