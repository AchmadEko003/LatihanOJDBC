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
import model.Region;

/**
 *
 * @author Nitani
 */
public class CountryDAO {

    private Connection connection;

    public CountryDAO(Connection connection) {
        this.connection = connection;
    }

    public CountryDAO() {
    }

        public List<Country> getDatas(String query) {
        List<Country> datas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setCountryId(resultSet.getString("COUNTRY_ID"));
                country.setCountryName(resultSet.getString("COUNTRY_NAME"));
                country.setRegionId(resultSet.getInt("REGION_ID"));
                datas.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
    /**
     * 
     * @return mengambil semua values dari tabel Countries
     */
    
    public List<Country> getAllCountries() {
        return getDatas("SELECT * FROM COUNTRIES ORDER BY 1");
    }
    
    /**
     *
     * @param countryId
     * @return mencari Country berdasarkan country_id
     */
    public List<Country> getById(String countryId) {
        return getDatas("SELECT * FROM COUNTRIES WHERE COUNTRY_ID = '" + countryId + "'");
    }

    /**
     * 
     * @param data
     * @return search table Countries 
     */
    public List<Country> search(Object data) {
        String search = "SELECT * FROM COUNTRIES where country_id LIKE '%" + data + "%'"
                + "OR country_name like '%" + data + "%'"
                + " OR region_id like '%" + data + "%'";
        return getDatas(search);
    }
     /**
     * 
     * @param id
     * @return boolean which is true for success delete and false for fail delete
     */
    public boolean deleteCountry(String  id){
        boolean result = false;
        String query = "DELETE FROM COUNTRIES where country_id = '" + id + "'";
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
     * insert country
     * @param country
     * @return 
     */
    public boolean insertCountry(Country country){
        boolean result = false;
        String query ="INSERT INTO countries VALUES(?,?,?)";        
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, country.getCountryId());
            preparedStatement.setString(2, country.getCountryName());
            preparedStatement.setInt(3, country.getRegionId());
            preparedStatement.executeUpdate();
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateCountry(Country country) {
        boolean result = false;
        String query = "UPDATE COUNTRIES SET  COUNTRY_NAME = ?, REGION_ID = ?"
                + " WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, country.getCountryName());
            preparedStatement.setInt(2, country.getRegionId());
            preparedStatement.setString(3, country.getCountryId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
        public List<Region> getAllRegions() {
        List<Region> datas = new ArrayList<>();
        String query = "SELECT * FROM REGIONS";//mengambil dari tabel hr.regions
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){ //perulangan dilakukan selama data region ditemukan
                Region region = new Region(); //instansiasi Region
                region.setRegionId(resultSet.getInt("region_id")); //untuk mengambil region_id
                region.setRegionId(resultSet.getInt(1)); //untuk mengambil region_id
                region.setRegionName(resultSet.getString("region_name")); //untuk mengambil region_name
                datas.add(region); //penambahan data kedalam list tiap kali data region datemukan
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return datas;
    }
}
