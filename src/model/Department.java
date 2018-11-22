/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeSupport;

/**
 *
 * @author Nitani
 */
public class Department {
    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(int departmentId) {
        int oldDepartmentId = this.departmentId;
        this.departmentId = departmentId;
        propertyChangeSupport.firePropertyChange(PROP_DEPARTMENTID, oldDepartmentId, departmentId);
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        java.lang.String oldDepartmentName = this.departmentName;
        this.departmentName = departmentName;
        propertyChangeSupport.firePropertyChange(PROP_DEPARTMENTNAME, oldDepartmentName, departmentName);
    }

    /**
     * @return the managerId
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(int managerId) {
        int oldManagerId = this.managerId;
        this.managerId = managerId;
        propertyChangeSupport.firePropertyChange(PROP_MANAGERID, oldManagerId, managerId);
    }

    /**
     * @return the locationId
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(int locationId) {
        int oldLocationId = this.locationId;
        this.locationId = locationId;
        propertyChangeSupport.firePropertyChange(PROP_LOCATIONID, oldLocationId, locationId);
    }
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    public static final String PROP_DEPARTMENTID = "departmentId";
    public static final String PROP_DEPARTMENTNAME = "departmentName";
    public static final String PROP_MANAGERID = "managerId";
    public static final String PROP_LOCATIONID = "locationId";

    
}
