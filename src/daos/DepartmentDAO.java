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
     *
     * @param departmentId
     * @return Mencari Department berdasarkan department_id
     */
    public List<Department> getById(int departmentId) {
        List<Department> data = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = " + departmentId;
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

    /**
     *
     * @param data
     * @return search table departments
     */
    public List<Department> search(Object data) {
        List<Department> datas = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS where department_id LIKE '%" + data + "%'"
                + "OR department_name like '%" + data + "%'"
                + " OR manager_id like '%" + data + "%'" + "OR location_id like '%" + data + "%'";
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement
                    .executeQuery();
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
     * 
     * @param id
     * @return boolean which is true for success delete and false for fail delete
     */
    public boolean deleteDepartment(int id){
        boolean result = false;
        String query ="DELETE FROM departments where department_id =" + id;        
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
}