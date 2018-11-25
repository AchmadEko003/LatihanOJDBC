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
import model.Employee;
import model.Location;

/**
 *
 * @author Nitani
 */
public class DepartmentDAO {

    private Connection connection;

    public DepartmentDAO() {
    }

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * @param department
     * @return mengambil semua values dari tabel Departments
     */
    public List<Department> getAllDepartments() {
        List<Department> datas = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(); //kalau banyak data menggunakan ini
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setManagerId(resultSet.getInt("manager_id"));
                department.setLocationId(resultSet.getInt("location_id"));
                datas.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
    
    /**
     * insert department
     * @param department
     * @return 
     */
    public boolean insertDepartment(Department department){
        boolean result = false;
        String query ="INSERT INTO department VALUES (?,?,?,?)";        
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setInt(3, department.getManagerId());
            preparedStatement.setInt(4, department.getLocationId());
    } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * update department
     *
     * @param department
     * @return
     */

    public boolean updateDepartment(Department department) {
        boolean result = false;
        String query = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ?"
                + " WHERE DEPARTMENT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getManagerId());
            preparedStatement.setInt(3, department.getLocationId());
            preparedStatement.setInt(4, department.getDepartmentId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Employee> selectManagerId() {
        List<Employee> data = new ArrayList<>();
        String query = "SELECT employee_id, first_name, last_name FROM employees ORDER BY first_name ASC";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                data.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public List<Location> selectLocationId() {
        List<Location> data = new ArrayList<>();
        String query = "SELECT location_id, city FROM locations ORDER BY city ASC";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location location = new Location();
                location.setLocationId(resultSet.getInt("location_id"));
                location.setCity(resultSet.getString("city"));
                data.add(location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
