/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardwaremanagement;

import application.forms.Login.Login;

/**
 *
 * @author Shashiprabha-PC
 */
public class HardwareManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
      
       HibernateUtil hibernateUtil =  new HibernateUtil();
        System.out.println("System is running");
       
        
        Login login = new Login();
        login.setVisible(true); 
        
        
    }
    
}
