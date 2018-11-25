/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.RegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Employee;

/**
 *
 * @author Nitani
 */
public class EmployeeController {
    
    /*
    tot buat apa?
    */
    private Connection connection;
    private EmployeeDAO edao;
    private Employee employee;
    int tot = 0;
    List<Employee> datas = new ArrayList<>();

    public EmployeeController() {
    }

    public EmployeeController(Connection connection) {
        this.connection = connection;
        this.edao = new EmployeeDAO(connection);
    }

    public int hitung() {
        return edao.getAllEmployee().size();
    }

    public List<Employee> gets() {
        return edao.getAllEmployee();
    }

    public List<Employee> find(Object data) {
        return edao.searchByEmployees(data);
    }
    public  List<Employee> getid(int id){
        return edao.getEmployeeId(id);
    }
    public boolean delete(int id) {
        return edao.deleteEmployees(id);
    }

    public void getname() {
        System.out.println(employee.getFirstName());
    }

    public boolean update(String empFN, String empLN, String email, String phoneNum, String hireNum, String jobId, int sal, double comm, int managerId, int departmentId, int ID) {
        Employee employee = new Employee(empFN, empLN, email, phoneNum, hireNum, jobId, sal, comm, managerId, departmentId, ID);
        return edao.updateEmployee(employee);
    }
    
    public boolean insertt(Employee employee){
        return edao.insertEmployee(employee);
    }
     public boolean insert(String employeeid, String firstname, String lastname, String email, String phonenumber, String hiredate, String jobid, String salary, String commissionpct, String managerid, String departmentid) {
        boolean result = false;
        int empid =Integer.valueOf(employeeid);
        int empSal =Integer.valueOf(salary);
        double empCom =Double.valueOf(commissionpct);
        int empmanager =Integer.valueOf(managerid);
        int empdepartment =Integer.valueOf(departmentid);
        Employee employee = new Employee(empid,firstname,
                lastname,email,
                phonenumber,hiredate,
                jobid,empSal,
                empCom,empmanager,
                empdepartment);
        result = edao.insertEmployee(employee);
        return result;
    }

    
}
    
    