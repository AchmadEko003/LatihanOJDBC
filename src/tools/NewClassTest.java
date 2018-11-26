/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import daos.EmployeeDAO;
import daos.RegionDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Department;
import model.Employee;
import model.Region;

/**
 *
 * @author Nitani
 */
public class NewClassTest {

    public static void main(String[] args) {
        Connections con = new Connections();
        System.out.println("Koneksi : "
                + con.getConnection());

//        RegionDAO rdao = new RegionDAO(con.getConnection());
//        System.out.println(rdao.getAllRegions().size());
//        
//        Region department = new Region(300, "JR Networking");
//        System.out.println(rdao.updateRegion(department));
        EmployeeDAO edao = new EmployeeDAO(con.getConnection());
//          System.out.println(edao.getAllEmployee().size());

        EmployeeController ec = new EmployeeController(con.getConnection());
        System.out.println(ec.gets().size());
        
//        int record = ec.hitung();
//        
//        for (int bar=0;bar<record;bar++){
//        System.out.println(ec.gets().get(bar).getLastName());
//        }

//        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            Date date1 = dateformat3.parse("17/07/1989");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //Employee emp = new Employee(99, "JR Programmer", "JR Programmer", "JR Programmer", "08312381", , "SA_REP", 2000, (int) .3, 146, 90);
        //System.out.println(edao.updateEmployee(emp));
//Employee emp = new Employee(199);
        //System.out.println(edao.updateEmployee(emp));
//        for (Employee emp : edao.searchByEmployees("Lex")) {
//            System.out.println(emp.getFirstName());
//        }
        for(Employee emp : ec.find("Lex")){
            System.out.println(emp.getFirstName() + emp.getEmployeeId());
        }
    }
}
