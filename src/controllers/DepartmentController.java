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
    /**
     * 
     * @return list all department values
     */
    public List<Department> selectDepartment() {
        List<Department> result = new ArrayList<>();
        result = ddao.getAllDepartments();
        return result;
    }
    /**
     * 
     * @param departmentId
     * @param departmentName
     * @param managerId
     * @param locationId
     * @return boolean which is true the insert function success and if false the insert function failed
     */
    public boolean insertDepartment(String departmentName, String managerId, String locationId, String departmentId) {
        boolean result = false;
        int idDepartment = Integer.parseInt(departmentId);
        int idManager    = Integer.parseInt(managerId);
        int idLocation   = Integer.parseInt(locationId);
        Department department = new Department(departmentName,idManager,idLocation,idDepartment);
        result = ddao.insertDepartment(department);
        return result;
    }
    /**
     * 
     * @param departmentName
     * @param managerId
     * @param locationId
     * @param departmentId
     * @return boolean which is true the update function success executed and if false the update function fail
     */
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
    /**
     * 
     * @param departmentId the id of department
     * @return list of department id values which the id equal with parameter
     */
    public List<Department> getById(String departmentId) {
        return ddao.getById(Integer.parseInt(departmentId));
    }
    /**
     * 
     * @param departmentId
     * @return boolean which is true the delete function success and if false delete function failed
     */
    public boolean deleteDepartment(String departmentId) {
        boolean result = false;
        Department department = new Department(Integer.parseInt(departmentId));
        result = ddao.deleteDepartment(department);
        return result;
    }
    /**
     * 
     * @param obj object which is the id or name of department
     * @return list of department which the values same as the parameter
     */
    public List<Department> searchDepartment(Object obj){
        return ddao.search(obj);
    }
}
