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
    
    /**
     * this is function delete for table employee create by Aji
     * @param id
     * @return true if the query is success executed
     */
    public boolean deleteEmployees(int id) {
        boolean result = false;
        String query = "DELETE FROM Employees where employee_id =" + id;
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
     * @param employee by ADHE
     * @return 
     */
    public boolean updateEmployee(Employee employee){
        boolean result = false;
        String query ="UPDATE EMPLOYEES SET first_name=?, last_name=?,"
                + " email=?, phone_number=?, hire_date=?, job_id=?,"
                + "salary=?, commission_pct=?, manager_id=?, department_id=? where employee_id = ?";        
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);            
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, (employee.getHireDate()));
            preparedStatement.setString(6, employee.getJobId());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setInt(8, employee.getCommisionPct());
            preparedStatement.setInt(9, employee.getManagerId());
            preparedStatement.setInt(10, employee.getDepartmentId());
            preparedStatement.setInt(11, employee.getEmployeeId());
            
            preparedStatement.executeUpdate();   
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
