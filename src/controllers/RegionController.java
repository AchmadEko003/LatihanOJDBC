/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Region;

/**
 *
 * @author EMDES
 */
public class RegionController extends javax.swing.JFrame {

    private Connection connection;
    private RegionDAO rdao;

    public RegionController() {

    }

    public RegionController(Connection connection) {
        this.connection = connection;
        this.rdao = new RegionDAO(connection);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
        this.rdao = new RegionDAO(connection);
    }

    /**
     * Insert Data Ragions
     *
     * @param regionId
     * @param regionName
     * @return
     */
    public boolean insert(String regionId, String regionName) {
        boolean result = false;
        int idRegion = Integer.parseInt(regionId);
        Region region = new Region(idRegion, regionName);
        result = rdao.insertRegion(region);
        return result;
    }

    /**
     * Edit data Regions
     *
     * @param regionId
     * @param regionName
     * @return
     */
    public boolean update(String regionName, String regionId) {
        //boolean result = false;
        int idRegion = Integer.parseInt(regionId);
        Region region = new Region(idRegion, regionName);
        return rdao.updateRegion(region);
    }
    
    public List<Region> search(){
        return rdao.getAllRegions();
    }

    /**
     * SetById Regions
     *
     * @param object
     * @return
     */
    public List<Region> getByID(String regionId) {
        int data = Integer.parseInt(regionId);
        return rdao.getByID(regionId);
    }

    /**
     * View All Data Regions
     *
     * @param object
     * @return
     */
    public List<Region> getAllRegion(Object object) {
        List<Region> result = new ArrayList<>();
        result = rdao.getAllRegions();
        return result;
    }

    public boolean delete(String regionId){
        boolean result = false;
        result = rdao.deleteRegion(regionId);
        return result;
    }

}
