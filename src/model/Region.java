/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nitani
 */
public class Region {

    private int regionId;
    private String regionName;

    /**
     *
     */
    public Region() {
    }

    /**
     *
     * @param regionId
     * @param regionName
     */
    public Region(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    /**
     *
     * @param regionName
     * @param regionId
     */
    public Region(String regionName, int regionId) {
        this.regionName = regionName;
        this.regionId = regionId;
    }
    /**
     * @return the regionName
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * @param regionName the regionName to set
     */
    public void setRegionName(String regionName) {
        java.lang.String oldRegionName = this.regionName;
        this.regionName = regionName;
        propertyChangeSupport.firePropertyChange(PROP_REGIONNAME, oldRegionName, regionName);
    }
    /**
     * @return the regionId
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(int regionId) {
        int oldRegionId = this.regionId;
        this.regionId = regionId;
        propertyChangeSupport.firePropertyChange(PROP_REGIONID, oldRegionId, regionId);
    }
   /**
    * ?????
    */
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    /**
     *
     */
    public static final String PROP_REGIONID = "regionId";

    /**
     *
     */
    public static final String PROP_REGIONNAME = "regionName";

    
    

}
