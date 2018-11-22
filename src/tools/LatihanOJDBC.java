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
        System.out.println("Koneksi : " + 
                con.getConnection());
        
        RegionDAO rdao = new RegionDAO(con.getConnection());
        System.out.println(rdao.getAllRegions().size());
        
        LocationDAO ldao = new LocationDAO(con.getConnection());
        System.out.println(ldao.getAllLocations().size());
        
        JobDAO jdao = new JobDAO(con.getConnection());
        System.out.println(jdao.getAllJob().size());
        
        DepartmentDAO ddao = new DepartmentDAO(con.getConnection());
        System.out.println(ddao.getAllDepartment().size());
        
        EmployeeDAO edao = new EmployeeDAO(con.getConnection());
        System.out.println(edao.getAllEmployee().size());
        
        CountryDAO cdao = new CountryDAO(con.getConnection());
        System.out.println(cdao.getAllCountry().size());
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
    }
}
