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
    public List<Job> getAllJob(){
        List<Job> datas = new ArrayList<>();
        String query = "SELECT * FROM Jobs";
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement(query);
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
}
