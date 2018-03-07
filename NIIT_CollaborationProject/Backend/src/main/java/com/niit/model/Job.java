package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "job_table")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int jobId;

	private String jobtitle;

	private String jobDescription;

	@Column(name="DATE_OF_JOB")
	private Date date;

	private String jobqualification;

	private String joblocation;

	private int experience;

	private String companyname;
	private float ctc;

	public float getCtc() {
		return ctc;
	}

	public void setCtc(float ctc) {
		this.ctc = ctc;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobtitle=" + jobtitle + ", jobDescription=" + jobDescription + ", date="
				+ date + ", jobqualification=" + jobqualification + ", joblocation=" + joblocation + ", experience="
				+ experience + ", companyname=" + companyname + ", ctc=" + ctc + "]";
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getJobqualification() {
		return jobqualification;
	}

	public void setJobqualification(String jobqualification) {
		this.jobqualification = jobqualification;
	}

	public String getJoblocation() {
		return joblocation;
	}

	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

}
