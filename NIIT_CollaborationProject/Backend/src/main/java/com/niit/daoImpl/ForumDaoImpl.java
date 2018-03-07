package com.niit.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ForumDao;
import com.niit.model.Forum;

@Repository("forumdao")
@Transactional

public class ForumDaoImpl implements ForumDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addForum(Forum forum) {// TC Compl
		try {
			sessionFactory.getCurrentSession().save(forum);
			System.out.println("forum Added");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteForum(Forum forum) {// TC Compl
		sessionFactory.getCurrentSession().remove(forum);
		System.out.println("Forum Removed");
		return true;
	}

	public boolean updateForum(Forum forum) {// TC Compl
		System.out.println("#######");
		sessionFactory.getCurrentSession().update(forum);
		System.out.println("Forum Updated");
		return true;
	}

	public Forum getForum(int forumId) {// TC Compl
		Session session = sessionFactory.openSession();
		Forum forum = session.get(Forum.class, forumId);
		session.close();
		return forum;
	}

	@Transactional
	public boolean approveForum(Forum forum) {
		forum.setForumstatus("A");
		System.out.println("Forum Approved");
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	@Transactional
	public boolean rejectForum(Forum forum) {
		forum.setForumstatus("NA");
		System.out.println("Forum Rejected");
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	public List<Forum> listForum(String forumusername) {
		System.out.println("List of username in forum");
		return sessionFactory.getCurrentSession()
				.createQuery("from Forum where forumname='" + forumusername + "'", Forum.class).getResultList();
		// return (List<Forum>) sessionFactory.getCurrentSession().get(Forum.class,
		// forumusername);
	}

}
