/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Nine
 */
public class Connections {
    /**
     * Ini adalah atribut connection dari java.sql
     */
    private Connection connection;
    /**
     * ini dokumentasi tentang getConnection
     *
     * @return nilai kembalian Connection
     */
    public Connection getConnection(){ //buat koneksi
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setServerName("localhost");
            ods.setDriverType("thin");
            ods.setPortNumber(1521);
            ods.setServiceName("XE");
//            ods.setDatabaseName("HR");
            ods.setUser("system");
            ods.setPassword("nani1995");
            this.connection = ods.getConnection();
            this.connection.createStatement().execute("alter session set current_schema=hr");
        } catch (Exception e) {
            e.printStackTrace(); //untuk menampilkan pesan error secara detail
            System.out.println(e.getMessage()); // untuk menampilkan garis besar pesan error
        }
        return connection;
    }
}
