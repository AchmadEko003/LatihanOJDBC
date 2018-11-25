/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import models.Region;

/**
 *
 * @author Andi SR
 */
public class CountryController {

    private Connection connection;
    private CountryDAO cdao;

    public CountryController() {
    }

    public CountryController(Connection connection) {
        this.connection = connection;
        this.cdao = new CountryDAO(connection);
    }

    public List<Country> selectCountry() {
        List<Country> result = new ArrayList<>();
        result = cdao.getAllCountries();
        return result;
    }

    public List<Country> getById(String countryId) {
        List<Country> result = new ArrayList<>();
        return result;
    }

    public List<Region> selectRegion() {
        List<Region> result = new ArrayList<>();
        result = cdao.getAllRegions();
        return result;
    }

    public boolean insert(String countryId, String countryName, String regionId) {
        boolean result = false;
        int idRegion = Integer.parseInt(regionId);
        Country country = new Country(countryId, countryName, idRegion);
        result = cdao.insertCountry(country);
        return result;
    }

    public boolean update(String countryId, String countryName, String regionId) {
        boolean result = false;
        int idRegion = Integer.parseInt(regionId);
//        Country country = new Country(countryId, countryName, idRegion);
        Country country = new Country(countryId, countryName, idRegion);
        result = cdao.updateCountry(country);
        return result;
    }

    public List<Country> search(Object object) {
        List<Country> result = new ArrayList<>();
        result = cdao.search(object);
        return result;
    }

    public boolean delete(String countryId) {
        boolean result = false;
        result = cdao.deleteCountry(countryId);
        return result;
    }

}
