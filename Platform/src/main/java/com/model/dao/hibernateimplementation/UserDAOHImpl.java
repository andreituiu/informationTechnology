package com.model.dao.hibernateimplementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.User;
import com.model.dao.UserDAO;
import com.model.utils.SessionUtil;

public class UserDAOHImpl extends BaseDAOHImpl<User, String> implements UserDAO {

//	private static final Session SESSION = BaseDAOHImpl.SESSION;
	
	@Autowired
	private Session session;
	
	public UserDAOHImpl() {
		super(User.class);
	}

	@Override
	public List<User> findAll() {
		return session.createCriteria(User.class).list();
	}

	@Override
	public List<User> findContaining(String searchTxt) {
		Criteria crit = session.createCriteria(User.class);
		Criterion cnpCrt = Restrictions.like("CNP",searchTxt,MatchMode.ANYWHERE);
		Criterion nameCrt = Restrictions.like("name",searchTxt,MatchMode.ANYWHERE);
		Criterion surnameCrt = Restrictions.like("surname",searchTxt,MatchMode.ANYWHERE);
		Criterion roleCrt = Restrictions.like("role",searchTxt,MatchMode.ANYWHERE);
		crit.add(Restrictions.or(cnpCrt, nameCrt, surnameCrt, roleCrt));
		List<User> results = crit.list();
		return results;
	}

	
}
