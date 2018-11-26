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
import model.Employee;
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

    /**
     * membuat koneksi
     * dan menampilkan seluruh data dalam tabel region
     * @return 
     */

    public List<Region> getAllRegions() {
        List<Region> datas = new ArrayList<>();
        String query = "SELECT * FROM HR.REGIONS";//mengambil dari tabel hr.regions
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
    

    
    /**
     *
     * @param data
     * @return
     */
    public List<Region> search(Object data){
        List<Region> datas = new ArrayList<>();
        String query = "SELECT * FROM REGIONS WHERE REGION_ID LIKE '%"+data+"%'" + "OR REGION_NAME LIKE '%"+data+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
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
    //insert

    /**
     *
     * @param region
     * @return
     */
    public boolean insertRegion(Region region){ //fungsi untuk mengetahui apakah proses insert suskes atau tidak
        boolean result = false; //jika di try akan gagal, dia tidak melanjutkan perintah
        String query = "INSERT INTO REGIONS VALUES(?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, region.getRegionId()); //untuk mengisi ? di index pertama diisi dengan id region
            preparedStatement.setString(2, region.getRegionName()); //untuk mengisi ? di index kedua diisi dengan nama region
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    //delete 

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

    /**
     *
     * @param region
     * @return
     */
    public boolean updateRegion(Region region) {
        boolean result = false;
        String query = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
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
