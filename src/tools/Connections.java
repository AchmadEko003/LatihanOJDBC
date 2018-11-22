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
 * @author Nitani
 */
public class Connections {
    /*
    ini adalah attribut connection dari java.sql
    */
    private Connection connection;
    
    /**
     * ini dokumentasi tentang connection database
     * @return nilai kembaliannya Connection
     */
    public Connection getConnection(){
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setServerName("localhost");
            ods.setDriverType("thin");
            ods.setPortNumber(1521);
            ods.setServiceName("XE");
            //ods.setDatabaseName("HR");
            ods.setUser("system");
            ods.setPassword("sys");
            this.connection = ods.getConnection();
            this.connection.createStatement().execute("alter session" + " set current_schema=hr");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        return connection;
    }
}
