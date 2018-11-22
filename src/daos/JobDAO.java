/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Job;

/**
 *
 * @author Nitani
 */
public class JobDAO {

    private Connection connection;

    public JobDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Job> getAllJob() {
        List<Job> datas = new ArrayList<>();
        String query = "SELECT * FROM Jobs";
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Job job = new Job(); //instansiasi
                job.setJobId(resultSet.getString("job_id"));
                job.setJobTitle(resultSet.getString("job_title"));
                job.setMinSalary(resultSet.getInt("min_salary"));
                job.setMaxSalary(resultSet.getInt("max_salary"));
                datas.add(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    /**
     * this is function delete for table Jobs created by Aji.
     * @param id
     * @return true if the query is succes executed.
     */
    public boolean deleteJobs(String id) {
        boolean result = false;
        String query = "DELETE FROM JOBS where job_id = '" + id + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 
     * @param job by ADHE
     * @return 
     */
     public boolean updateJob(Job job){
        boolean result = false;
        String query ="UPDATE JOBS SET job_title=?, min_salary=?,"
                + " max_salary=? where job_id = ?";        
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);            
            preparedStatement.setString(1, job.getJobTitle());
            preparedStatement.setInt(2, job.getMinSalary());
            preparedStatement.setInt(3, job.getMaxSalary());
            preparedStatement.setString(4, job.getJobId());
            preparedStatement.executeUpdate();   
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
     /**
      * search job
      * by Tika MP
      * @param data
      * @return 
      */
     public List<Job> searchByJobs(Object data){
        List<Job> datas = new ArrayList<>();
        String query = "SELECT * FROM JOBS where job_id LIKE '%"+data+"%'"
                + " OR job_title LIKE '%"+data+"%'"
                + " OR max_salary LIKE '%"+data+"%'"
                + " OR min_salary LIKE '%"+data+"%'"; 
                
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement
                    .executeQuery();
            while (resultSet.next()) {
                Job job = new Job();
                job.setJobId(resultSet.getString("job_id"));
                job.setJobTitle(resultSet.getString("job_title"));
                job.setMaxSalary(resultSet.getInt("max_salary"));
                job.setMinSalary(resultSet.getInt("min_salary"));
                datas.add(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
     
}
