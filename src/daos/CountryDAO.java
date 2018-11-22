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
     * @param countryId
     * @return mencari Country berdasarkan country_id
     */
    public List<Country> getById(String countryId) {
        List<Country> datac = new ArrayList<>();
        String query = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = '" + countryId + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country();
                country.setCountryId(resultSet.getString("COUNTRY_ID"));
                country.setCountryName(resultSet.getString("COUNTRY_NAME"));
                country.setRegionId(resultSet.getInt("REGION_ID"));
                datac.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datac;
    }
}
