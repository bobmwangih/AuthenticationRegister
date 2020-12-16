package business;

import dao.UserDao;
import models.User;

public class UserBusinessImpl implements UserBusiness{

	private UserDao dao;
	

	public void setDao(UserDao dao) {
		this.dao = dao;
	}


	public int createUser(User u) throws Exception {
			int i = dao.Save(u);
		return i;
	}
	
	
}
