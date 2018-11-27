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
import model.Country;
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

    public List<Location> GetDatas(String query) {
        List<Location> datas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { //perulangan dilakukan selama data location ditemukan
                Location location = new Location(); //instansiasi Location
                location.setLocationId(resultSet.getInt("location_id")); //untuk mengambil location_id
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

    public boolean dataInsert(String query, Location location) {
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setString(5, location.getCountryId());
            preparedStatement.setInt(6, location.getLocationId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Location> getAllLocations() {
        return GetDatas("SELECT * FROM HR.LOCATIONS");//mengambil dari tabel hr.locations
    }

    /**
     * getById
     *
     * @author Nine
     */
    public List<Location> getLocationId(int id) {
        return GetDatas("SELECT * FROM HR.LOCATIONS WHERE LOCATION_ID = " + id);//mengambil data id dari tabel hr.location
    }

    /**
     * search location by Tika MP
     *
     * @param data
     * @return
     */
    public List<Location> searchByLocation(Object data) {
        String query = "SELECT * FROM LOCATIONS"
                + " where location_id LIKE '%" + data + "%'"
                + " OR street_address LIKE '%" + data + "%'"
                + " OR postal_code LIKE '%" + data + "%'"
                + " OR city LIKE '%" + data + "%'"
                + " OR state_province LIKE '%" + data + "%'"
                + " OR country_id LIKE '%" + data + "%'";
        return GetDatas(query);
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
        String query = "UPDATE LOCATIONS SET street_address=?, postal_code=?,"
                + " city=?, state_province=?, country_id=? where location_id = ?";
        return dataInsert(query, location);
    }

    public boolean insertLocation(Location location) {
        String query = "INSERT INTO LOCATIONS (STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID, LOCATION_ID) VALUES (?,?,?,?,?,?)";
        return dataInsert(query, location);
    }
    public List<Country> selectCountryId() {
        List<Country> datas = new ArrayList<>();
        String query = "Select country_id from countries order by 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setCountryId(resultSet.getString("country_id"));
                datas.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
}
