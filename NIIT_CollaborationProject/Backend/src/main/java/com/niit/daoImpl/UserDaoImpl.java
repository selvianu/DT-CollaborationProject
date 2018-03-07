package com.niit.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDao;
import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.Job;
import com.niit.model.User;

@Repository("userdao")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();

	}

	public User getUserById(int userId) {
		Session session = sessionFactory.openSession();
		User user1 = session.get(User.class, userId);
		session.close();
		return user1;
	}

	public boolean addUser(User user) {
		System.out.println("+++++++++");
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	public boolean updateUser(User user) {
		System.out.println("#######");
		sessionFactory.getCurrentSession().update(user);
		System.out.println("user Updated");
		return true;
	}

	public boolean deleteUser(User user) {
		System.out.println("**&&**");
		// sessionFactory.getCurrentSession().delete();
		// "from Forum where forumname='" + forumusername + "'",
		// Forum.class).getResultList()
		// int firstResult = sessionFactory.getCurrentSession().createQuery("delete from
		// User where userId='" + userId + "'", User.class).getFirstResult();
		sessionFactory.getCurrentSession().delete(user);
		System.out.println("user Removed");
		return true;
	}

	public boolean userExists(String username) {
		User user = null;
		System.out.println("user already exists check!.....");
		// User user = sessionFactory.getCurrentSession().find(User.class, username);
		try {
			Query<User> createQuery = sessionFactory.getCurrentSession().createQuery("from User", User.class);
			// createQuery.setParameter(1, username);
			// user = createQuery.getSingleResult();
			List<User> resultList = createQuery.getResultList();
			for (User user2 : resultList) {
				user = user2;
				System.out.println(user2);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(user);
		return user != null;
	}

}
