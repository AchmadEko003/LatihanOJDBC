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
    public List<Country> getAllCountry(){
        List<Country> datas = new ArrayList<>();
        String query = "SELECT * FROM Countries";
        try {
            PreparedStatement preparedStatement = 
                    connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Country country = new Country(); //instansiasi
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
