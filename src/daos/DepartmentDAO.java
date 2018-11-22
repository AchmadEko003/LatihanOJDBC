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
     * 
     * @param departmentId
     * @return Mencari Department berdasarkan department_id
     */

    public List<Department> getById(int departmentId) {
        List<Department> dataId = new ArrayList<>();
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
                dataId.add(depart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataId;
    }

}
