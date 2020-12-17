package business;

import models.User;

public interface UserBusiness {

	public int createUser(User u) throws Exception;
	public boolean authenticateLogInDetails(String email,String password) throws Exception;
}
