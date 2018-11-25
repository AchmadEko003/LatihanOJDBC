/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.CountryDAO;
import daos.DepartmentDAO;
import daos.EmployeeDAO;
import daos.JobDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import model.Country;
import model.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;


/**
 *
 * @author Nitani
 */
public class LatihanOJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //tes koneksi
        Connections connections = new Connections();
//        System.out.println("koneksi : "
//                +connections.getConnection());
        
        RegionDAO rdao = new RegionDAO(connections.getConnection());
        JobDAO jdao = new JobDAO(connections.getConnection());
        LocationDAO ldao = new LocationDAO(connections.getConnection());
        EmployeeDAO edao = new EmployeeDAO(connections.getConnection());
        DepartmentDAO ddao = new DepartmentDAO(connections.getConnection());
        
//// JOBS getById
          System.out.println(jdao.getAllJobs().size());
        //untuk mendapatkan data job berdasarkan ID
          for(Job allJob : jdao.getJobId("AD_VP")){
              System.out.println("ID job " + allJob.getJobId() +"\n"
                      + " Title Job " + allJob.getJobTitle() +"\n"
                      + " Min Salary " + allJob.getMinSalary() +"\n"
                      + " Max Salary " + allJob.getMaxSalary());
    }
        //// LOCATIONS getById
          System.out.println(ldao.getAllLocations().size());
        //untuk mendapatkan data job berdasarkan ID
          for(Location allLocation : ldao.getLocationId(1600)){
              System.out.println("ID location " + allLocation.getLocationId() +"\n"
                      + " Street Address " + allLocation.getStreetAddress() +"\n"
                      + " Postal Code " + allLocation.getPostalCode() +"\n"
                      + " City " + allLocation.getCity() +"\n"
                      + " State Province" + allLocation.getStateProvince() +"\n"
                      + " Country ID" + allLocation.getCountryId());
    }
        //// EMPLOYEES getById
          System.out.println(edao.getAllEmployees().size());
        //untuk mendapatkan data job berdasarkan ID
          for(Employee allEmployee : edao.getEmployeesId(100)){
              System.out.println("ID Employee " + allEmployee.getEmployeeId() +"\n"
                      + " First Name " + allEmployee.getFirstName() +"\n"
                      + " Last Name " + allEmployee.getLastName() +"\n"
                      + " Email " + allEmployee.getEmail() +"\n"
                      + " Phone Number" + allEmployee.getPhoneNumber() +"\n"
                      + " Hire Date" + allEmployee.getHireDate() +"\n"
                      + " Job ID" + allEmployee.getJobId() +"\n"
                      + " Salary" + allEmployee.getSalary() +"\n"
                      + " Commission " + allEmployee.getCommission() +"\n"
                      + " Manager ID " + allEmployee.getManagerId() +"\n"
                      + " Department ID" + allEmployee.getDepartmentId());
    }

        JobDAO jdao = new JobDAO(con.getConnection());
        System.out.println(jdao.getAllJobs().size());

        EmployeeDAO edao = new EmployeeDAO(con.getConnection());
        System.out.println(edao.getAllEmployees().size());
        
        DepartmentDAO ddao = new DepartmentDAO(con.getConnection());
        for (Department department : ddao.getById(90)) {
            System.out.println(department.getDepartmentName());
        }
        
        CountryDAO cdao = new CountryDAO(con.getConnection());
        for (Country country : cdao.getById("AR")) {
            System.out.println(country.getCountryName());

        }
        
        /**
         * insert region
         */
        Region region = new Region(8, "Palembang");
        System.out.println(rdao.insertRegion(region));
        
        /**
         * insert country
         */
        Country country = new Country("ID", "Indonesia", 5);
        System.out.println(cdao.insertCountry(country));
        
        /**
         * insert department
         */
        Department department = new Department(300, "JR Programmer", 200, 1800);
        System.out.println(ddao.insertDepartment(department));
        
        //Region region = new Region(13, "Ekoeksis");
        //System.out.println(rdao.deleteRegion(13));
//        for(Region allregion : rdao.getAllRegions()){
//            System.out.println(allregion.getRegionId()+" - "
//            + allregion.getRegionName());
//        }

//        for(Region allregion : rdao.getByID(4)){
//            System.out.println(allregion.getRegionId()+" - "
//            + allregion.getRegionName());
//        }
        
    
        for (Region allRegion : rdao.getAllRegions()) {
            System.out.println(allRegion.getRegionId() + " - " + allRegion.getRegionName());
        }        

        for (Department allDepartment : ddao.getAllDepartments()) {
            System.out.println(allDepartment.getDepartmentId() + " - " + allDepartment.getDepartmentName()
                    + " - " + allDepartment.getManagerId() + " - " + allDepartment.getLocationId());
        }
        
        for (Country allCountry : cdao.getAllCountries()) {
            System.out.println(allCountry.getCountryId() + " - " + allCountry.getCountryName() 
                    + " - " + allCountry.getRegionId());
        }
        
        for (Region allRegion : rdao.getAllRegions()) {
            System.out.println(allRegion.getRegionId() + " - " + allRegion.getRegionName());
        }

        for (Department allDepartment : ddao.getAllDepartments()) {
            System.out.println(allDepartment.getDepartmentId() + " - " + allDepartment.getDepartmentName()
                    + " - " + allDepartment.getManagerId() + " - " + allDepartment.getLocationId());
        }

        for (Country allCountry : cdao.getAllCountries()) {
            System.out.println(allCountry.getCountryId() + " - " + allCountry.getCountryName()
                    + " - " + allCountry.getRegionId());
        }
        /**
         * memanggil data dari table departments fungsi search
         */
        System.out.println("==========================");
        // Object data = "s";
        for (Department alldeDepartment : ddao.search("s")) {
            System.out.println(alldeDepartment.getDepartmentId() + " - "
                    + alldeDepartment.getDepartmentName() + " - " + alldeDepartment.getManagerId() + " - " + alldeDepartment.getLocationId());
        }

        /**
         * memanggil data dari table country fungsi search
         */
        System.out.println("==========================");
        // Object data = "s";
        for (Country allcountry : cdao.search("s")) {
            System.out.println(allcountry.getCountryName() + " - "
                    + allcountry.getCountryName() + " - " + allcountry.getRegionId());
        }
        
        JobDAO rdaojob = new JobDAO(con.getConnection());
	for (Job allJob : rdaojob.searchByJobs("AD_PRES")){
            System.out.println(allJob.getJobId() +"-" 
                               + allJob.getJobTitle() +"-"
                               + allJob.getMinSalary() +"-"
                               + allJob.getMaxSalary());
        }
	LocationDAO rdaolocation = new LocationDAO(con.getConnection());
        for (Location location : rdaolocation.searchByLocation("93091 Calle della Testa")) {
            System.out.println(location.getLocationId() + "-"
                    + location.getStreetAddress() + "-"
                    + location.getPostalCode() + "-"
                    + location.getCity() + "-"
                    + location.getStateProvince() + "-"
                    + location.getCountryId());
        }
        EmployeeDAO rdaoemployee = new EmployeeDAO(con.getConnection());
        for (Employee  employee : rdaoemployee.searchByEmployees("Steven")) {
            System.out.println(employee.getEmployeeId() + "-"
                    + employee.getFirstName() + "-"
                    + employee.getLastName() + "-"
                    + employee.getEmail()+ "-"
                    + employee.getPhoneNumber() + "-"
                    //+ employee.getHireDate() + "-"
                    + employee.getJobId() + "-"
                    + employee.getSalary() + "-"
                    + employee.getCommission() + "-"
                    + employee.getManagerId()+ "-"
                    + employee.getDepartmentId());
        }

    }
}
