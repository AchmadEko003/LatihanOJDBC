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
public class RegionController extends javax.swing.JFrame{
     private Connection connection;
    private RegionDAO rdao;

    /**
     *
     */
    public RegionController() {

    }

    /**
     *
     * @param connection
     */
    public RegionController(Connection connection) {
        this.connection = connection;
        this.rdao = new RegionDAO(connection);
    }

    /**
     *
     * @param connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
        this.rdao = new RegionDAO(connection);
    }

    /**
     *
     * @param regionId
     * @param regionName
     * @return
     */
    public boolean insert(String regionId, String regionName) {
        boolean result = false;
        int idRegion = Integer.parseInt(regionId);
        Region region = new Region(idRegion, regionName);
        return rdao.insertRegion(region);
    }

    /**
     *
     * @param regionId
     * @param regionName
     * @return
     */
    public boolean update(String regionId, String regionName) {
        boolean result = false;
        int idRegion = Integer.parseInt(regionId);
        Region region = new Region(idRegion, regionName);
        return rdao.updateRegion(region);
    }

    /**
     *
     * @param object
     * @return
     */
    public List<Region> searchByRegion(Object object) {
        List<Region> result = new ArrayList<>();
        return rdao.getByID(object);
    }

    /**
     *
     * @param object
     * @return
     */
    public List<Region> getAllRegion(Object object) {
        List<Region> result = new ArrayList<>();
        return rdao.getAllRegions();
    }

    /**
     *
     * @param regionId
     * @return
     */
    public boolean Delete(String regionId) {
        boolean result = false;
        return rdao.deleteRegion(regionId);
    }
}
