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
import model.Country;
import model.Department;
import model.Employee;
import model.Location;
import model.Region;

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

    public List<Country> getAll() {
        return cdao.getAllCountries();
    }
    public List<Country> selectCountry() {
        List<Country> result = new ArrayList<>();
        result = cdao.getAllCountries();
        return result;
    }
    public List<Region> selectRegionId() {
        List<Region> result = new ArrayList<>();
        result = cdao.selectRegionId();
        return result;
    }



    public List<Country> getById(String countryId) {
        return cdao.getById(countryId);
    }

    public List<Region> selectRegion() {
        return cdao.getAllRegions();

    }

    public boolean insert(String countryId, String countryName, String regionId) {
        int idRegion = Integer.parseInt(regionId);
        Country country = new Country(countryId, countryName, idRegion);
        return cdao.insertCountry(country);

    }

    public boolean update(String countryId, String countryName, String regionId) {
        int idRegion = Integer.parseInt(regionId);
        Country country = new Country(countryId, countryName, idRegion);
        return cdao.updateCountry(country);
    }

    public List<Country> search(Object object) {

        return cdao.search(object);
    }

    public boolean delete(String countryId) {

        return cdao.deleteCountry(countryId);
    }

}
