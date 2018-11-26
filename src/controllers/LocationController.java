/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Location;

/**
 *
 * @author Kaukanoer
 */
public class LocationController {

    private Connection c;
    private LocationDAO ldao;
    private Location location;
    List<Location> datas = new ArrayList<Location>();

    public LocationController() {
    }

    public LocationController(Connection c) {
        this.c = c;
        this.ldao = new LocationDAO(c);
    }
    /**
     * untuk menambahkan data ke entity
     * @param locationId
     * @param streetAddress
     * @param postalCode
     * @param city
     * @param stateProvince
     * @param countryId
     * @return 
     */

    public boolean insert(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        int location_id = Integer.parseInt(locationId);
        location = new Location(location_id, streetAddress, postalCode, city, stateProvince, countryId);
        return ldao.insertLocation(location);
    }

    /**
     * untuk menghapus
     * @param location_id
     * @return 
     */
    public boolean delete(String location_id) {
        int locationId = Integer.parseInt(location_id);
        return ldao.deleteLocations(locationId);
    }

    /**
     * untuk mendapatkan semua data dari entity
     * @return 
     */
    public List<Location> getAll() {
        return ldao.getAllLocations();
    }

    /**
     * search by Id location
     * @param location_id
     * @return 
     */
    public List<Location> getById(String location_id) {
        int locationId = Integer.parseInt(location_id);
        return ldao.getLocationId(locationId);
    }

    /**
     * controller untuk search by object
     * @param data
     * @return 
     */
    public List<Location> search(Object data) {
        return ldao.searchByLocation(data);
    }

    /**
     * controller untuk update location
     * @param location_id
     * @param streetAddress
     * @param postalCode
     * @param city
     * @param stateProvince
     * @param countryId
     * @return 
     */
    public boolean update(String location_id, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        int locationId = Integer.parseInt(location_id);
        location = new Location(locationId,streetAddress, postalCode, city, stateProvince, countryId);
        return ldao.updateLoc(location);
    }
}