/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Region;

/**
 *
 * @author Nine
 */
public class RegionDAO {

    private Connection connection;

    /**
     *
     * @param connection
     */
    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param query
     * @return
     */
    public List<Region> getDatas(String query) {
        List<Region> datas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Region region = new Region();
                region.setRegionId(resultSet.getInt(1));
                region.setRegionName(resultSet.getString(2));
                datas.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    /**
     *
     * @return
     */
    public List<Region> getAllRegion() {
        return getDatas("SELECT * FROM Regions order by 1");
    }

    /**
     *
     * @param id
     * @return
     */
    public List<Region> getRegionId(int id) {
        return getDatas("SELECT * FROM REGIONS WHERE REGIONS_ID= " + id);
    }
    public int maxRegionId() {
        int id = 0;
        try {
            String query = "SELECT max(region_id) as maxregionId FROM regions";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                id = resultSet.getInt("maxregionId") + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteRegions(int id) {
        boolean result = false;
        String query = "DELETE FROM Regions where region_id =" + id;
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
     * @param data
     * @return
     */
    public List<Region> searchByRegions(Object data) {
        String a = "SELECT * FROM Regions where region_name LIKE '%" + data + "%'"
                + " OR region_id LIKE '%" + data + "%'";
        return getDatas(a);
    }

    /**
     *
     * @param region
     * @return
     */
    public boolean insertRegion(Region region) {
        String query = "INSERT INTO REGIONS (region_name, region_id)"
                + "     VALUES (?,?)";
        return insertDatas(query, region);
    }

    /**
     *
     * @param region
     * @return
     */
    public boolean updateRegion(Region region) {
        String query = "UPDATE REGIONS SET region_name=? where region_id = ?";
        return insertDatas(query, region);
    }
    
    /**
     *
     * @param query
     * @param region
     * @return
     */
    public boolean insertDatas(String query, Region region) {
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, region.getRegionName());
            preparedStatement.setInt(2, region.getRegionId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
