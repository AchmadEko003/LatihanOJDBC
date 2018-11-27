/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author EMDES
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
     * @param regionId
     * @param regionName
     */
    public Region(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    /**
     *
     * @return
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     *
     * @param regionId
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     *
     * @return
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     *
     * @param regionName
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
