/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author AD
 */
import daos.JobDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Job;

public class JobController {

    private Connection connection;
    private JobDAO jdao;

    public JobController() {
    }

    public JobController(Connection connection) {
        this.connection = connection;
        this.jdao = new JobDAO(connection);
    }

    public boolean insert(String jobId, String jobTitle, String minSalary, String maxSalary) {
        int salaryMin = Integer.parseInt(minSalary);
        int salaryMax = Integer.parseInt(maxSalary);
        Job job = new Job(jobId, jobTitle, salaryMin, salaryMax);
        return jdao.insertJob(job);
    }

    public boolean delete(String jobId) {
        return jdao.deleteJobs(jobId);
    }

    public boolean update(String jobId, String jobTitle, String minSalary, String maxSalary) {
        int salaryMin = Integer.parseInt(minSalary);
        int salaryMax = Integer.parseInt(maxSalary);
        Job job = new Job(jobId, jobTitle, salaryMin, salaryMax);
        return jdao.updateJob(job);
    }

    public List<Job> getAllJob() {
        return jdao.getAllJob();
    }

    public List<Job> searchByJobs(Object object) {
        return jdao.searchByJobs(object);
    }

    public List<Job> getById(String jobId) {
        return jdao.getById(jobId);
    }
}
