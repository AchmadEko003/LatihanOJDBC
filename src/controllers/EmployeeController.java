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
        datas =edao.getEmployeeId(id);
        return datas;
    }
    public boolean delete(int id) {
        return edao.deleteEmployees(id);
    }

//    public boolean update(Employee empl){
//        boolean result = false;
//        int empId = empl.getEmployeeId();
//        String empFName = empl.getFirstName();
//        String empLName = empl.getLastName();
//        String empMail = empl.getEmail();
//        String empPhone = empl.getPhoneNumber();
//        Date empHireDate = empl.getHireDate();
//        String empJobId = empl.getJobId();
//        int empSal = empl.getSalary();
//        //int empCom = empl.getCommisionPct();
//        int empManager = empl.getManagerId();
//        int empDepartment = empl.getDepartmentId();
//        //Employee employee = new Employee(empId,empFName,empLName,empMail,empPhone,empHireDate,empJobId,empSal,empCom,empManager,empDepartment);
//        result = edao.updateEmployee(employee);
//        return result;
//    }
    public void getname() {
        System.out.println(employee.getFirstName());
    }

    public boolean update(String empFN, String empLN, String email, String phoneNum, String hireNum, String jobId, int sal, double comm, int managerId, int departmentId, int ID) {
        Employee employee = new Employee(empFN, empLN, email, phoneNum, hireNum, jobId, sal, comm, managerId, departmentId, managerId);
        return edao.updateEmployee(employee);
    }
    
    public boolean insertt(Employee employee){
        boolean result = false;
        result = edao.insertEmployee(employee);
        return result;
    }
     public boolean insert(String employeeid, String firstname, String lastname, String email, String phonenumber, String hiredate, String jobid, String salary, String commissionpct, String managerid, String departmentid) {
        boolean result = false;
        int empid =Integer.valueOf(employeeid);
        String empFName = firstname;
        String empLName = lastname;
        String empMail = email;
        String empPhone = phonenumber;
        String empHireDate = hiredate;
        String empJobId = jobid;
        int empSal =Integer.valueOf(salary);
        double empCom =Double.valueOf(commissionpct);
        int empmanager =Integer.valueOf(managerid);
        int empdepartment =Integer.valueOf(departmentid);
        Employee employee = new Employee(empid,empFName,
                empLName,empMail,
                empPhone,empHireDate,
                empJobId,empSal,
                empCom,empmanager,
                empdepartment);
        result = edao.insertEmployee(employee);
        return result;
    }

    
}
    
    