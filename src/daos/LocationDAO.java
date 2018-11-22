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
import models.Location;


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
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){ //perulangan dilakukan selama data location ditemukan
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }
    
    
    public List<Location> getLocationId(int id){
        List<Location> datas = new ArrayList<>();
        String query = "SELECT * FROM HR.LOCATIONS WHERE LOCATION_ID = " + id;//mengambil data id dari tabel hr.location
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){ //perulangan dilakukan selama data Location ditemukan
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }
    
}
