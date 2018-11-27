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
     * insert department
     *
     * @param department
     * @return
     */
    public boolean insertDepartment(Department department) {
        String query = "INSERT INTO departments(department_name, manager_id, location_id, department_id)"
                + " VALUES (?,?,?,?)";
        return DBExecution(query, department);
    }

    /**
     * update department
     *
     * @param department
     * @return
     */
    public boolean updateDepartment(Department department) {
        String query = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ?"
                + " WHERE DEPARTMENT_ID = ?";
        return DBExecution(query, department);
    }
    
    private boolean DBExecution(String query, Department department){
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getManagerId());
            preparedStatement.setInt(3, department.getLocationId());
            preparedStatement.setInt(4, department.getDepartmentId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int maxDepartmentId() {
        int id = 0;
        try {
            String query = "SELECT max(department_id) as maxId FROM departments";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department depart = new Department();
                id = resultSet.getInt("maxId") + 10;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    /**
     * function to get values from db each row per coloumn
     * @param query
     * @return list department based on query
     */
    private List<Department> getDBValues(String query){
        List<Department> data = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {//perulangan sebanyak kursor jika masih ada, buat object baru
                Department depart = new Department();//panggil kelas 
                depart.setDepartmentId(resultSet.getInt("DEPARTMENT_ID"));
                depart.setDepartmentName(resultSet.getString("DEPARTMENT_NAME"));
                depart.setManagerId(resultSet.getInt("MANAGER_ID"));
                depart.setLocationId(resultSet.getInt("LOCATION_ID"));
                data.add(depart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public List<Department> selectAllDepartment() {
        return getDBValues("SELECT * FROM DEPARTMENTS");
    }
    
    /**
     *
     * @param departmentId
     * @return Mencari Department berdasarkan department_id
     */
    public List<Department> getById(int departmentId) {
        return getDBValues("SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = " + departmentId);
    }
    
    /**
     *
     * @param data
     * @return search table departments
     */
    public List<Department> search(Object data) {
        String query = "SELECT * FROM DEPARTMENTS where department_id LIKE '%" + data + "%'"
                + "OR department_name like '%" + data + "%'"
                + " OR manager_id like '%" + data + "%'" + "OR location_id like '%" + data + "%'";
        return getDBValues(query);
    }
    
    /**
     *
     * @param id
     * @return boolean which is true for success delete and false for fail
     * delete
     */
    public boolean deleteDepartment(Department department) {
        boolean result = false;
        String query = "DELETE FROM departments WHERE department_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}