/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

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
        
        //Region region = new Region(13, "Ekoeksis");
        System.out.println(rdao.deleteRegion(13));
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
