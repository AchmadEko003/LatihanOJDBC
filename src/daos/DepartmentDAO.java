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
import model.Department;

/**
 *
 * @author Nitani
 */
public class DepartmentDAO {
    private Connection connection;
    
    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Department> getAllDepartment(){
        List<Department> datas = new ArrayList<>();
        String query = "SELECT * FROM Departments";
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Department department = new Department(); //instansiasi
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_id"));
                department.setManagerId(resultSet.getInt("manager_id"));
                department.setLocationId(resultSet.getInt("location_id"));
                datas.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}
