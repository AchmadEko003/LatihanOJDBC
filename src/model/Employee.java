/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nitani
 */
public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    //private Date hireDate;
    private String hireDate;
    private String jobId;
    private int salary;
    private double commisionPct;
    private int managerId;
    private int departmentId;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate, String jobId, int salary, double commisionPct, int managerId, int departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        //this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commisionPct = commisionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobId, int salary, double commisionPct, int managerId, int departmentId, int employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commisionPct = commisionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
        this.employeeId = employeeId;
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        int oldEmployeeId = this.employeeId;
        this.employeeId = employeeId;
        propertyChangeSupport.firePropertyChange(PROP_EMPLOYEEID, oldEmployeeId, employeeId);
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        java.lang.String oldFirstName = this.firstName;
        this.firstName = firstName;
        propertyChangeSupport.firePropertyChange(PROP_FIRSTNAME, oldFirstName, firstName);
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        java.lang.String oldLastName = this.lastName;
        this.lastName = lastName;
        propertyChangeSupport.firePropertyChange(PROP_LASTNAME, oldLastName, lastName);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        java.lang.String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange(PROP_EMAIL, oldEmail, email);
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        java.lang.String oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        propertyChangeSupport.firePropertyChange(PROP_PHONENUMBER, oldPhoneNumber, phoneNumber);
    }

    /**
     * @return the hireDate
     */
    public String getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(String hireDate) {
        String oldHireDate = this.hireDate;
        this.hireDate = hireDate;
        propertyChangeSupport.firePropertyChange(PROP_HIREDATE, oldHireDate, hireDate);
    }

    /**
     * @return the jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(String jobId) {
        java.lang.String oldJobId = this.jobId;
        this.jobId = jobId;
        propertyChangeSupport.firePropertyChange(PROP_JOBID, oldJobId, jobId);
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        int oldSalary = this.salary;
        this.salary = salary;
        propertyChangeSupport.firePropertyChange(PROP_SALARY, oldSalary, salary);
    }

    /**
     * @return the commisionPct
     */
    public double getCommisionPct() {
        return commisionPct;
    }

    /**
     * @param commisionPct the commisionPct to set
     */
    public void setCommisionPct(double commisionPct) {
        double oldCommisionPct = this.commisionPct;
        this.commisionPct = commisionPct;
        propertyChangeSupport.firePropertyChange(PROP_COMMISIONPCT, oldCommisionPct, commisionPct);
    }

    /**
     * @return the managerId
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(int managerId) {
        int oldManagerId = this.managerId;
        this.managerId = managerId;
        propertyChangeSupport.firePropertyChange(PROP_MANAGERID, oldManagerId, managerId);
    }

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(int departmentId) {
        int oldDepartmentId = this.departmentId;
        this.departmentId = departmentId;
        propertyChangeSupport.firePropertyChange(PROP_DEPARTMENTID, oldDepartmentId, departmentId);
    }
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    public static final String PROP_EMPLOYEEID = "employeeId";
    public static final String PROP_FIRSTNAME = "firstName";
    public static final String PROP_LASTNAME = "lastName";
    public static final String PROP_EMAIL = "email";
    public static final String PROP_PHONENUMBER = "phoneNumber";
    public static final String PROP_HIREDATE = "hireDate";
    public static final String PROP_JOBID = "jobId";
    public static final String PROP_SALARY = "salary";
    public static final String PROP_COMMISIONPCT = "commisionPct";
    public static final String PROP_MANAGERID = "managerId";
    public static final String PROP_DEPARTMENTID = "departmentId";

    
    

}
