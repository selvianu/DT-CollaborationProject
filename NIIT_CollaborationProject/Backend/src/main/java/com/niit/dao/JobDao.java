package com.niit.dao;

import java.util.List;

import com.niit.model.Job;

public interface JobDao {
	List<Job> getAllJob();

	Job getJobById(int jobId);

	boolean addJob(Job job);

	boolean updateJob(Job job);

	boolean deleteJob(Job job);

}
