/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Invoice;
import application.entity.InvoiceDetails;
import application.entity.Rental;
import application.entity.RentalDetails;
import hardwaremanagement.NumberGenerator;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Shashiprabha-PC
 */
public class InvoiceController extends DbCommon{

    public boolean saveInvoiceDetais(Invoice invoice) {
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        List<InvoiceDetails> list = null;
        try {

            session.save(invoice);

            String genaretedInvoiceNo = new NumberGenerator().getGenaretedNumber("REN", invoice.getInvoiceId());
            invoice.setInvoiceNo(genaretedInvoiceNo);
            session.saveOrUpdate(invoice);

            list = invoice.getInvoiceDetailsList();
            Iterator<InvoiceDetails> itr = list.iterator();
            while (itr.hasNext()) {
                InvoiceDetails detail = itr.next();
                detail.setInvoiceDetailRef(invoice);
                session.saveOrUpdate(detail);
            }

            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        } finally {
            if (list != null) {
                list.clear();
            }
            session.close();
        }
        return true;
    }

    
    
}
