package com.dt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dt.model.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(user);
		System.out.println("user added");
		return true;
	}

	public User getUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user1 = currentSession.createQuery("from User where username='" + username + "'",User.class).uniqueResult();
		return user1;
	}

	public List<User> retrieveUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
