package com.niit.collaboration.Backend;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDao;
import com.niit.model.Job;

public class TestJob {

	private static AnnotationConfigApplicationContext context;
	private static JobDao jobdao;
	private Job job;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobdao = (JobDao) context.getBean("jobdao");
		System.out.println("------init----");
	}

	/*
	 * @Test public void addJobTest() { job = new Job(); job.setCompanyname("CSC");
	 * job.setDate(new Date()); job.setExperience(1);
	 * job.setJobDescription("Training the students for corporate field"); //
	 * job.setJobId(1); job.setJobtitle("Training");
	 * job.setJobqualification("B.E/B.Tech"); job.setJoblocation("bangalore");
	 * job.setCtc(3.0f); System.out.println("add job");
	 * assertEquals("job Successfully added to the database", true,
	 * jobdao.addJob(job)); }
	 */

	/*
	 * @Test public void getJobByIdTest() { job = new Job(); Job jobById =
	 * jobdao.getJobById(24); assertNotNull("issue in data of job" + jobById);
	 * System.out.println(jobById.getJoblocation() + jobById.getJobId());
	 * 
	 * }
	 */

	/*
	 * @Test public void deleteJobTest() { job = new Job(); job.setJobId(24);
	 * assertEquals("job Successfully added to the database", true,
	 * jobdao.deleteJob(job)); }
	 */
	/*
	 * @Test public void updateJobTest() { job = new Job(); job.setJobId(25);
	 * job.setCompanyname("niit"); job.setCtc(1.8f); job.setDate(new Date());
	 * job.setExperience(0);
	 * job.setJobDescription("training the students for placement");
	 * job.setJobqualification("B.E/B.Tech"); job.setJobtitle("trainer");
	 * job.setJoblocation("chennai,Pune,Bangalore");
	 * assertEquals("job Successfully added to the database", true,
	 * jobdao.updateJob(job)); }
	 */
	@Test
	public void allJobTest() {
		job = new Job();
		List<Job> allJob = jobdao.getAllJob();
		assertNotNull("no data" + allJob);
		for (Job job : allJob) {
			
			System.out.println(job);
		}
		System.out.println(allJob.size());
	}

}
