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
import model.Employee;
import model.Job;
import model.Location;
import model.Region;

/**
 *
 * @author Nitani
 */
public class LatihanOJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connections con = new Connections();
        System.out.println("Koneksi : "
                + con.getConnection());

        RegionDAO rdao = new RegionDAO(con.getConnection());
        System.out.println(rdao.getAllRegions().size());

        LocationDAO ldao = new LocationDAO(con.getConnection());
        System.out.println(ldao.getAllLocations().size());

        JobDAO jdao = new JobDAO(con.getConnection());
        System.out.println(jdao.getAllJob().size());

        EmployeeDAO edao = new EmployeeDAO(con.getConnection());
        System.out.println(edao.getAllEmployee().size());

        /**
         * Untuk ngecek search Department berdasarkan ID
         */
        DepartmentDAO ddao = new DepartmentDAO(con.getConnection());
        for (Department department : ddao.getById(90)) {
            System.out.println(department.getDepartmentName());

        }
        /**
         * Untuk ngecek search Country berdasarkan ID
         */
        CountryDAO cdao = new CountryDAO(con.getConnection());
        for (Country country : cdao.getById("AR")) {
            System.out.println(country.getCountryName());

        }
        
        /**
         * insert region
         */
//        Region region = new Region(8, "Palembang");
//        System.out.println(rdao.insertRegion(region));
        
        /**
         * insert country
         */
//        Country country = new Country("ID", "Indonesia", 5);
//        System.out.println(cdao.insertCountry(country));
        
        /**
         * insert department
         */
//        Department department = new Department(300, "JR Programmer", 200, 1800);
//        System.out.println(ddao.insertDepartment(department));
        
//        Employee employee = new Employee(199, "JR Programmer", "JR Programmer", "JR Programmer");
//        System.out.println(edao.updateEmployee(employee));
//        
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
//        for (Employee  employee : rdaoemployee.searchByEmployees("Steven")) {
//            System.out.println(employee.getEmployeeId() + "-"
//                    + employee.getFirstName() + "-"
//                    + employee.getLastName() + "-"
//                    + employee.getEmail()+ "-"
//                    + employee.getPhoneNumber() + "-"
//                    + employee.getHireDate() + "-"
//                    + employee.getJobId() + "-"
//                    + employee.getSalary() + "-"
//                    + employee.getCommisionPct() + "-"
//                    + employee.getManagerId()+ "-"
//                    + employee.getDepartmentId());
//        }

    }
}
