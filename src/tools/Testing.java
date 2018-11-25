/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import daos.CountryDAO;
import models.Country;

/**
 *
 * @author Andi SR
 */
public class Testing {
        public static void main(String[] args) {
            Connections c = new Connections();
            CountryController controller =  new CountryController(c.getConnection());
            CountryDAO cdao = new CountryDAO(c.getConnection());
//            
//            controller.getById("BB")
//            System.out.println(controller.selectCountry().size());
            for (Country country : cdao.getById("AR")) {
                System.out.println(country.getCountryId()+ country.getCountryName());
                
            }
        }
    
}
