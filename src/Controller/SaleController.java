/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class SaleController extends DbCommon{
    
     public String generateInvoiceNo() {
        
            
        int r_count = 1;

//        JDBC j = new JDBC();
//        try {
//            ResultSet rset = j.getData("SELECT COUNT(inv_no) FROM invoice");
//            if (rset.next()) {
//                r_count = rset.getInt(1) + 1;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        int invoice_int = r_count + 1;
//        String invoice_num = Integer.toString(invoice_int);
//        return invoice_num;
         return null;
     }    
    
}
