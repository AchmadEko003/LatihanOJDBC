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
 * @author Nine EMDES
 */
public class RegionDAO {

    private Connection connection;

    /**
     *
     */
    public RegionDAO() {
    }

    /**
     *
     * @param connection
     */
    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Region> getDatas(String query) {
        List<Region> datas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { //perulangan dilakukan selama data region ditemukan
                Region region = new Region(); //instansiasi Region
                region.setRegionId(resultSet.getInt("region_id")); //untuk mengambil region_id
                region.setRegionId(resultSet.getInt(1)); //untuk mengambil region_id
                region.setRegionName(resultSet.getString("region_name")); //untuk mengambil region_name
                datas.add(region); //penambahan data kedalam list tiap kali data region datemukan
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
    /**
     * membuat koneksi dan menampilkan seluruh data dalam tabel region
     *
     * @return
     */
    public List<Region> getAllRegions() {
        return getDatas("SELECT * FROM HR.REGIONS order by 1");
    }

    /**
     *
     * @param data
     * @return
     */
    public List<Region> search(Object data) {
        String a = "SELECT * FROM REGIONS where region_id LIKE '%" + data + "%'"
                + " OR region_name LIKE '%" + data + "%'";
        return getDatas(a);
    }
    /**
     *
     * @param data
     * @return
     */
    //Object = mengambil tipe data
    public List<Region> getByID(String regionId) {
        List<Region> datas = new ArrayList<>();
        String query = "SELECT * FROM REGIONS WHERE REGION_ID = '" + regionId + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setRegionId(resultSet.getInt("REGION_ID"));
                region.setRegionName(resultSet.getString("REGION_NAME"));
                datas.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
    /**
     * Query Untuk Insert dan Reload Data Baru
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

    /**
     *
     * @param region
     * @return
     */
    public boolean insertRegion(Region region) { //fungsi untuk mengetahui apakah proses insert suskes atau tidak
        String query = "INSERT INTO REGIONS (Region_name, region_id)"
                + "VALUES(?,?)";
        return insertDatas(query, region);
    }
    /**
     *
     * @param region
     * @return
     */
    public boolean updateRegion(Region region) {
        String query = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
        return insertDatas(query, region);
    }
    /**
     *
     * @param regionId
     * @return
     */
    public boolean deleteRegion(String regionId) {
        boolean result = false;
        String query = "DELETE FROM REGIONS where region_id =" + regionId + "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
