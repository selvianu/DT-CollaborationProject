package com.dt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dt.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean insertValues(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;

	}

	public User getUserByUserId(int userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}

	public User getUserByUsername(String username) {
		User user = (User) sessionFactory.getCurrentSession()
				.createQuery("FROM User WHERE username = '" + username + "'").uniqueResult();
		System.out.println(user);
		return user;

	}

}
