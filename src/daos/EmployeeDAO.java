/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Employee;
import model.Job;

/**
 *
 * @author Nine
 */
public class EmployeeDAO {

    /**
     * public EmployeeDAO(Connection connection) --> database private static
     * java.sql.Timestamp getCurrentTimeStamp()---------->????
     */
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * public List<Employee> data(a)----->function for get and set data to list
     * from employee model
     *
     * @param a
     * @return
     */
    public List<Employee> getDatas(String query) {
        List<Employee> datas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setPhoneNumber(resultSet.getString(5));
                employee.setHireDate(resultSet.getString(6));
                employee.setJobId(resultSet.getString(7));
                employee.setSalary(resultSet.getInt(8));
                employee.setCommisionPct(resultSet.getInt(9));
                employee.setManagerId(resultSet.getInt(10));
                employee.setDepartmentId(resultSet.getInt(11));
                datas.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    /**
     * public List<Employee> getAllEmployee()----->get all data ditabel
     *
     * @return
     */
    public List<Employee> getAllEmployee() {
        return getDatas("SELECT * FROM Employees order by 1");
    }

    public int getLastId(){
        int id = 0;
        String query = "select max(EMPLOYEE_ID) from employees";
        return id;
    }
    /**
     * public List<Employee> getEmployeeId(int id)------->get by id
     *
     * @param id
     * @return
     */
    public List<Employee> getEmployeeId(int id) {
        return getDatas("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID= " + id);
    }

    public List<Employee> getManagerId(int id) {
        String query = "SELECT employee_id, first_name, last_name FROM employees "
                + "ORDER BY first_name ASC where manager_id =" + id;
        return execEmployee(query);
    }

    public List<Employee> execEmployee(String query) {
        List<Employee> data = new ArrayList<>();
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

    /**
     * this is function delete for table employee create by Aji public boolean
     * deleteEmployees(int id)-----> delete berdasarkan id;
     *
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
     * function search by Tika MP public List<Employee> searchByEmployees(Object
     * data)--->function for search by object
     *
     * @param data
     * @return
     */
    public List<Employee> searchByEmployees(Object data) {
        String a = "SELECT * FROM Employees where employee_id LIKE '%" + data + "%'"
                + " OR first_name LIKE '%" + data + "%'"
                + " OR last_name LIKE '%" + data + "%'"
                + " OR email LIKE '%" + data + "%'"
                + " OR phone_number LIKE '%" + data + "%'"
                + " OR hire_date LIKE '%" + data + "%'"
                + " OR job_id LIKE '%" + data + "%'"
                + " OR salary LIKE '%" + data + "%'"
                + " OR commission_pct LIKE '%" + data + "%'"
                + " OR manager_id LIKE '%" + data + "%'"
                + " OR department_id LIKE '%" + data + "%'";
        return getDatas(a);
    }

    /**
     * insert employee--->insert data
     *
     * @param employee
     * @return
     */
    public boolean insertEmployee(Employee employee) {
        String query = "INSERT INTO EMPLOYEES (first_name, last_name,"
                + " email, phone_number, hire_date, job_id, salary, commission_pct,"
                + " manager_id, department_id, employee_id)"
                + "     VALUES (?,?,?,?,to_date(?, 'mm/dd/yy'),?,?,?,?,?,?)";
        return insertDatas(query, employee);
    }

    /**
     * public boolean updateEmployee(Employee employee)--->update
     *
     * @param employee by ADHE
     * @return
     */
    public boolean updateEmployee(Employee employee) {
        String query = "UPDATE EMPLOYEES SET first_name=?, last_name=?,"
                + " email=?, phone_number=?, hire_date=(TO_DATE(?, 'MM/DD/YYYY')), job_id=?,"
                + "salary=?, commission_pct=?, manager_id=?, department_id=? where employee_id = ?";
        return insertDatas(query, employee);
    }

    public boolean insertDatas(String query, Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getHireDate());
            preparedStatement.setString(6, employee.getJobId());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setDouble(8, employee.getCommisionPct());
            preparedStatement.setInt(9, employee.getManagerId());
            preparedStatement.setInt(10, employee.getDepartmentId());
            preparedStatement.setInt(11, employee.getEmployeeId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Job> selectJobId() {
        List<Job> datas = new ArrayList<>();
        String query = "SELECT job_id, job_title, min_salary, max_salary FROM jobs ORDER BY job_title ASC";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job job = new Job();
                job.setJobId(resultSet.getString("job_id"));
                job.setJobTitle(resultSet.getString("job_title"));
                job.setMinSalary(resultSet.getInt("min_salary"));
                job.setMaxSalary(resultSet.getInt("max_salary"));
                datas.add(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    public List<Department> selectDepartmentId() {
        List<Department> datas = new ArrayList<>();
        String query = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID FROM departments ORDER BY DEPARTMENT_NAME ASC";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("DEPARTMENT_ID"));
                department.setDepartmentName(resultSet.getString("DEPARTMENT_NAME"));
                department.setManagerId(resultSet.getInt("MANAGER_ID"));
                department.setLocationId(resultSet.getInt("LOCATION_ID"));
                datas.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}
