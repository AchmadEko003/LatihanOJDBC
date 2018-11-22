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
import model.Employee;

/**
 *
 * @author Nitani
 */
public class EmployeeDAO {
    private Connection connection;
    
    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Employee> getAllEmployee(){
        List<Employee> datas = new ArrayList<>();
        String query = "SELECT * FROM Employees";
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Employee employee = new Employee(); //instansiasi
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setHireDate(resultSet.getDate("hire_date"));
                employee.setJobId(resultSet.getString("job_id"));
                employee.setSalary(resultSet.getInt("salary"));
                employee.setCommisionPct(resultSet.getInt("commission_pct"));
                employee.setManagerId(resultSet.getInt("manager_id"));
                employee.setDepartmentId(resultSet.getInt("department_id"));
                datas.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}
