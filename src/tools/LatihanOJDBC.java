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
    }
}
