package com.model.dao;

import com.model.Admin;
import com.model.User;

public interface AdminDAO {

	void save(Admin admin);

	void deleteUser(User selectedUser);

	Admin getAdmin(String cnp);

	void update(Admin admin);
}
