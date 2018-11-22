/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.EmployeeDAO;
import daos.JobDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;

/**
 *Main class
 * @author Nine
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
        
//        RegionDAO rdao = new RegionDAO(connections.getConnection());
        JobDAO jdao = new JobDAO(connections.getConnection());
        LocationDAO ldao = new LocationDAO(connections.getConnection());
        EmployeeDAO edao = new EmployeeDAO(connections.getConnection());
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
        
//        System.out.println(rdao.getAllRegions().size());
//        
//        for(Region allRegion : rdao.getAllRegions()){
//            System.out.println(allRegion.getRegionId() + " - "
//                    + allRegion.getRegionName());
        
        //System.out.println(rdao.getById().size());
        
        //untuk mendapatkan data region berdasarkan ID
//        for(Region allRegion : rdao.getById(1)){
//            System.out.println(allRegion.getRegionId() + " - "
//                    + allRegion.getRegionName());
//        }
//        
//        //untuk mencari data region berdasarkan ID atau Nama
//        for(Region allRegion : rdao.searchRegion("A")){
//            System.out.println("Region yang anda cari mungkin adalah ID = " + allRegion.getRegionId()
//                    + " dengan nama region adalah "+ allRegion.getRegionName());
//        }
        
////        Insert
//        Region region = new Region();
//        region.setRegionId(13);
//        region.setRegionName("Fantura");
//        System.out.println(rdao.insertRegion(region));
//        
//        for(Region allRegion : rdao.getAllRegions()){
//            System.out.println(allRegion.getRegionId() + " - " 
//                    + allRegion.getRegionName());
//        }
////          Delete
          
    }
}