/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Location;
import model.Region;

/**
 *
 * @author Nine
 */
public class LocationDAO {

    private Connection connection;

    public LocationDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Location> getAllLocations() {
        List<Location> datas = new ArrayList<>();
        String query = "SELECT * FROM HR.LOCATIONS";//mengambil dari tabel hr.locations
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { //perulangan dilakukan selama data location ditemukan
                Location location = new Location(); //instansiasi Location
                location.setLocationId(resultSet.getInt("location_id")); //untuk mengambil location_id
                //job.setJobId(resultSet.getInt(1)); //untuk mengambil region_id
                location.setStreetAddress(resultSet.getString("street_address")); //untuk mengambil street_address
                location.setPostalCode(resultSet.getString("postal_code")); //untuk mengambil postal_code
                location.setCity(resultSet.getString("city")); //untuk mengambil city
                location.setStateProvince(resultSet.getString("state_province")); //untuk mengambil state_province
                location.setCountryId(resultSet.getString("country_id")); //untuk mengambil country_id
                datas.add(location); //penambahan data kedalam list tiap kali data location datemukan
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
/**
 *getById
 * @author Nine
 */
    public List<Location> getLocationId(int id) {
        List<Location> datas = new ArrayList<>();
        String query = "SELECT * FROM HR.LOCATIONS WHERE LOCATION_ID = " + id;//mengambil data id dari tabel hr.location
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { //perulangan dilakukan selama data Location ditemukan
                Location location = new Location(); //instansiasi Location
                location.setLocationId(resultSet.getInt("location_id")); //untuk mengambil Location_id
                //region.setRegionId(resultSet.getInt(1)); //untuk mengambil job_id
                location.setStreetAddress(resultSet.getString("street_address")); //untuk mengambil street_address
                location.setPostalCode(resultSet.getString("postal_code")); //untuk mengambil postal_code
                location.setCity(resultSet.getString("city")); //untuk mengambil city
                location.setStateProvince(resultSet.getString("state_province")); //untuk mengambil state_province
                location.setCountryId(resultSet.getString("country_id")); //untuk mengambil country_id
                datas.add(location); //penambahan data kedalam list tiap kali data location ditemukan
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    /**
     * this is function delete for table locations created by Aji
     *
     * @param id
     * @return true if the query success executed
     */
    public boolean deleteLocations(int id) {
        boolean result = false;
        String query = "DELETE FROM locations where location_id =" + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     *
     * @param location by ADHE
     * @return
     */
    public boolean updateLoc(Location location) {
        boolean result = false;
        String query = "UPDATE LOCATIONS SET street_address=?, postal_code=?,"
                + " city=?, state_province=?, country_id=? where location_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setString(5, location.getCountryId());
            preparedStatement.setInt(6, location.getLocationId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * search location
     * by Tika MP
     * @param data
     * @return 
     */
    public List<Location> searchByLocation(Object data){
        List<Location> datas = new ArrayList<>();
        String query = "SELECT * FROM LOCATIONS"
                + " where location_id LIKE '%"+data+"%'"
                + " OR street_address LIKE '%"+data+"%'"
                + " OR postal_code LIKE '%"+data+"%'"
                + " OR city LIKE '%"+data+"%'"
                + " OR state_province LIKE '%"+data+"%'"
                + " OR country_id LIKE '%"+data+"%'"; 
                
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location location = new Location();
                location.setLocationId(resultSet.getInt(1));
                location.setStreetAddress(resultSet.getString(2));
                location.setPostalCode(resultSet.getString(3));
                location.setCity(resultSet.getString(4));
                location.setStateProvince(resultSet.getString(5));
                location.setCountryId(resultSet.getString(6));
                datas.add(location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
    public boolean insertLocation(Location location) {
        boolean result = false;
        String query = "INSERT INTO LOCATIONS VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, location.getLocationId());
            preparedStatement.setString(2, location.getStreetAddress());
            preparedStatement.setString(3, location.getPostalCode());
            preparedStatement.setString(4, location.getCity());
            preparedStatement.setString(5, location.getStateProvince());
            preparedStatement.setString(6, location.getCountryId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
