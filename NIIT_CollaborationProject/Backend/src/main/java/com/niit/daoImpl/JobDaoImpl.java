package com.niit.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.JobDao;
import com.niit.model.Blog;
import com.niit.model.Job;

@Repository("jobdao")
@Transactional

public class JobDaoImpl implements JobDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Job> getAllJob() {

		return sessionFactory.getCurrentSession().createQuery("from Job", Job.class).list();

	}

	public Job getJobById(int jobId) {
		Session session = sessionFactory.openSession();
		Job job = session.get(Job.class, jobId);
		session.close();
		return job;

	}

	public boolean addJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			System.out.println("jobAdded");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean updateJob(Job job) {
		System.out.println("------");
		sessionFactory.getCurrentSession().update(job);
		System.out.println("job Updated");
		return true;

	}

	public boolean deleteJob(Job job) {
		sessionFactory.getCurrentSession().remove(job);
		System.out.println("job Removed");
		return true;

	}

}
