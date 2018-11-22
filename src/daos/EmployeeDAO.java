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
import models.Employee;

/**
 *
 * @author Nine
 */
public class EmployeeDAO {
    private Connection connection;
    
    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Employee> getAllEmployees() {
        List<Employee> datas = new ArrayList<>();
        String query = "SELECT * FROM HR.EMPLOYEES";//mengambil dari tabel hr.locations
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){ //perulangan dilakukan selama data Employee ditemukan
                Employee employee = new Employee(); //instansiasi Employee
                employee.setEmployeeId(resultSet.getInt("employee_id")); //untuk mengambil Employee_id
                employee.setFirstName(resultSet.getString("first_name")); //untuk mengambil first_name
                employee.setLastName(resultSet.getString("last_name")); //untuk mengambil last_name
                employee.setEmail(resultSet.getString("email")); //untuk mengambil email
                employee.setPhoneNumber(resultSet.getString("phone_number")); //untuk mengambil phone_number
                employee.setHireDate(resultSet.getDate("hire_date")); //untuk mengambil hire_date
                employee.setJobId(resultSet.getString("job_id")); //untuk mengambil job_id
                employee.setSalary(resultSet.getInt("salary")); //untuk mengambil salary
                employee.setCommissionPct(resultSet.getInt("commission_pct")); //untuk mengambil commission_pct
                employee.setManagerId(resultSet.getInt("manager_id")); //untuk mengambil manager_id
                employee.setDepartmentId(resultSet.getInt("department_id")); //untuk mengambil department_id
                datas.add(employee); //penambahan data kedalam list tiap kali data employee ditemukan
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }
    
    public List<Employee> getEmployeesId(int id) {
        List<Employee> datas = new ArrayList<>();
        String query = "SELECT * FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = " + id;//mengambil dari tabel hr.locations
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){ //perulangan dilakukan selama data Employee ditemukan
                Employee employee = new Employee(); //instansiasi Employee
                employee.setEmployeeId(resultSet.getInt("employee_id")); //untuk mengambil Employee_id
                employee.setFirstName(resultSet.getString("first_name")); //untuk mengambil first_name
                employee.setLastName(resultSet.getString("last_name")); //untuk mengambil last_name
                employee.setEmail(resultSet.getString("email")); //untuk mengambil email
                employee.setPhoneNumber(resultSet.getString("phone_number")); //untuk mengambil phone_number
                employee.setHireDate(resultSet.getDate("hire_date")); //untuk mengambil hire_date
                employee.setJobId(resultSet.getString("job_id")); //untuk mengambil job_id
                employee.setSalary(resultSet.getInt("salary")); //untuk mengambil salary
                employee.setCommissionPct(resultSet.getInt("commission_pct")); //untuk mengambil commission_pct
                employee.setManagerId(resultSet.getInt("manager_id")); //untuk mengambil manager_id
                employee.setDepartmentId(resultSet.getInt("department_id")); //untuk mengambil department_id
                datas.add(employee); //penambahan data kedalam list tiap kali data employee ditemukan
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }
    
    
}
