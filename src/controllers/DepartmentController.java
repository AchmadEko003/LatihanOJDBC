/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import daos.DepartmentDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Employee;
import model.Location;

/**
 *
 * @author Genius
 */
public class DepartmentController {
    private Connection connection;
    private DepartmentDAO ddao;
    
    public DepartmentController(Connection connection) {
        this.connection = connection;
        this.ddao = new DepartmentDAO(connection);
    }

    public DepartmentController() {
        
    }
    
    public List<Department> selectDepartment() {
        List<Department> result = new ArrayList<>();
        result = ddao.getAllDepartments();
        return result;
    }
    
    public boolean insertDepartment(String departmentId, String departmentName, String managerId, String locationId) {
        boolean result = false;
        int idDepartment = Integer.parseInt(departmentId);
        int idManager    = Integer.parseInt(managerId);
        int idLocation   = Integer.parseInt(locationId);
        Department department = new Department(idDepartment, departmentName,idManager,idLocation);
        result = ddao.insertDepartment(department);
        return result;
    }
    
    public boolean updateDepartment(String departmentName, String managerId, String locationId, String departmentId) {
        boolean result = false;
        int idManager    = Integer.parseInt(managerId);
        int idLocation   = Integer.parseInt(locationId);
        int idDepartment = Integer.parseInt(departmentId);
        Department department = new Department(departmentName,idManager,idLocation,idDepartment);
        result = ddao.updateDepartment(department);
        return result;
    }
    
    public List<Employee> selectEmployeeId() {
        List<Employee> result = new ArrayList<>();
        result = ddao.selectManagerId();
        return result;
    }
    
    public List<Location> selectLocationId() {
        List<Location> result = new ArrayList<>();
        result = ddao.selectLocationId();
        return result;
    }
}
