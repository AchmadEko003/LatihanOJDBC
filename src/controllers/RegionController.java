/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Region;

/**
 *
 * @author Nitani
 */
public class RegionController {

    /*
    tot buat apa?
     */
    private Connection connection;
    private RegionDAO rdao;
    private Region region;
    List<Region> datas = new ArrayList<>();

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
     * gets() --> to get all data
     *
     * @return
     */
    public List<Region> gets() {
        return rdao.getAllRegion();
    }
    
        public int maxRegionId() {
        return rdao.maxRegionId();
    }

    /**
     * find(Object data) --> function search by object
     *
     * @param data
     * @return
     */
    public List<Region> find(Object data) {
        return rdao.searchByRegions(data);
    }

    /**
     * getid(int id) --> function search by id
     *
     * @param id
     * @return
     */
    public List<Region> getid(String id) {
        int idRegion = Integer.parseInt(id);
        return rdao.getRegionId(idRegion);
    }

    /**
     * delete(int id) --> function delete by id
     *
     * @param id
     * @return
     */
    public boolean delete(String id) {
        int idRegion = Integer.parseInt(id);
        return rdao.deleteRegions(idRegion);
    }

    /**
     *
     */
    public void getid() {
        System.out.println(region.getRegionId());
    }

    /**
     *
     * @param nameRegion
     * @param idRegion
     * @return
     */
    public boolean update(String nameRegion, int idRegion) {
        Region region = new Region(nameRegion, idRegion);
        return rdao.updateRegion(region);
    }

    /**
     * insert --> function for add new data region
     *
     * @param regionname
     * @param regionid
     * @return
     */
    public boolean insert(String regionname, String regionid) {
        boolean result = false;
        int idRegion = Integer.valueOf(regionid);
        Region region = new Region(regionname, idRegion);
        result = rdao.insertRegion(region);
        return result;
    }
}
