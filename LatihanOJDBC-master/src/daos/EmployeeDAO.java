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
                //employee.setHireDate(resultSet.getDate("hire_date")); //untuk mengambil hire_date
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
                //employee.setHireDate(resultSet.getDate("hire_date")); //untuk mengambil hire_date
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
            //preparedStatement.setDate(5, (employee.getHireDate()));
            preparedStatement.setString(6, employee.getJobId());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setInt(8, employee.getCommission());
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

    /**
     * function search 
     * by Tika MP
     * @param data
     * @return 
     */
    public List<Employee> searchByEmployees(Object data){
        List<Employee> datas = new ArrayList<>();
        String query = "SELECT * FROM Employees where employee_id LIKE '%"+data+"%'"
                + " OR first_name LIKE '%"+data+"%'"
                + " OR last_name LIKE '%"+data+"%'"
                + " OR email LIKE '%"+data+"%'"
                + " OR phone_number LIKE '%"+data+"%'"
                + " OR hire_date LIKE '%"+data+"%'"
                + " OR job_id LIKE '%"+data+"%'"
                + " OR salary LIKE '%"+data+"%'"
                + " OR commission_pct LIKE '%"+data+"%'"
                + " OR manager_id LIKE '%"+data+"%'"
                + " OR department_id LIKE '%"+data+"%'"; 
                
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement
                    .executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setPhoneNumber(resultSet.getString(5));
                //employee.setHireDate(resultSet.getDate(6));
                employee.setJobId(resultSet.getString(7));
                employee.setSalary(resultSet.getInt(8));
                employee.setCommissionPct(resultSet.getInt(9));
                employee.setManagerId(resultSet.getInt(10));
                employee.setDepartmentId(resultSet.getInt(11));
                datas.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}
