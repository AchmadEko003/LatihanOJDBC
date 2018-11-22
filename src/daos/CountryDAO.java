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

    /**
     * 
     * @return mengambil semua values dari tabel Countries
     */
    public List<Country> getAllCountries(){
        List<Country> datas = new ArrayList<>();
        String query = "SELECT * FROM COUNTRIES";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                Country countries = new Country();
                countries.setCountryId(resultSet.getString("country_id"));
                countries.setCountryName(resultSet.getString("country_name"));
                countries.setRegionId(resultSet.getInt("region_id"));
                datas.add(countries);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return datas;
    }
    
    /**
     *
     * @param countryId
     * @return mencari Country berdasarkan country_id
     */
    public List<Country> getById(String countryId) {
        List<Country> datas = new ArrayList<>();
        String query = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = '" + countryId + "'";
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
     * @param data
     * @return search table Countries 
     */
     public List<Country> search(Object data) {
        List<Country> datas = new ArrayList<>();
        String query = "SELECT * FROM COUNTRIES where country_id LIKE '%"+data+"%'"
                + "OR country_name like '%"+data+"%'"
                + " OR region_id like '%"+data+"%'";
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement
                    .executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
               // country.setCountryId(resultSet.getInt("country_id"));
                country.setCountryId(resultSet.getString("country_id"));
                country.setCountryName(resultSet.getString("country_name"));
                country.setRegionId(resultSet.getInt("region_id"));
                datas.add(country);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
}
}
