/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JOptionPane;
import javax.swing.text.View;
import model.Region;
import views.RegionView;

/**
 *
 * @author Nitani
 */
public class RegionController {

    private Region model;
    private RegionView view;

    public RegionController(Region m, RegionView v) {
        model = m;
        view = v;
        initView();
    }

    public void initView() {
        view.getRegionNameTextField().setText(model.getRegionName());
    }

    public void initController() {
        view.getRegionIdSaveButton().addActionListener(e -> saveFirstname());
        //view.getLastnameSaveButton().addActionListener(e -> saveLastname());
        
    }

    private void saveFirstname() {
        model.setRegionName(view.getRegionNameTextField().getText());
        JOptionPane.showMessageDialog(null, "Region Name saved : " + model.getRegionName(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
