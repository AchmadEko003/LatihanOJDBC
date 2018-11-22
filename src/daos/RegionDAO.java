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
import model.Region;

/**
 *
 * @author Nitani
 */
public class RegionDAO {

    private Connection connection;

    public RegionDAO() {

    }

    /**
     *
     * @param connection
     */
    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @return
     */
    public List<Region> getAllRegions() {
        List<Region> datas = new ArrayList<>();
        String query = "SELECT * FROM REGIONS";
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Region region = new Region(); //instansiasi
                region.setRegionId(resultSet.getInt("region_id"));
                region.setRegionName(resultSet.getString("region_name"));
                datas.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    /**
     *
     * @param data
     * @return
     */
    //Object = mengambil tipe data
    public List<Region> getByID(Object data) {
        List<Region> datas = new ArrayList<>();
        String query = "SELECT * FROM REGIONS WHERE region_id like '%" + data + "%' OR region_name like'%" + data + "%'";
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(); //instansiasi
                region.setRegionId(resultSet.getInt("region_id"));
                region.setRegionName(resultSet.getString("region_name"));
                datas.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    public boolean insertRegion(Region region) {
        boolean result = false;
        String query = "INSERT INTO REGIONS VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteRegion(int id) {
        boolean result = false;
        String query = "DELETE FROM REGIONS where region_id =" + id;
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setInt(0, id);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateRegion(Region region) {
        boolean result = false;
        String query = "UPDATE REGIONS SET REGION_NAME = ?"
                + " WHERE REGION_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, region.getRegionName());
            preparedStatement.setInt(2, region.getRegionId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
