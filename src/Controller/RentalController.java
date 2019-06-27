/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Rental;
import application.entity.RentalDetails;
import hardwaremanagement.NumbeFormater;
import hardwaremanagement.NumberGenerator;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Shashiprabha-PC
 */
public class RentalController extends DbCommon {

    public boolean saveRentalDetais(Rental rental) {

        Session session = super.getHibernateUtil().openWritebleDbConnection();
        List<RentalDetails> list = null;
        try {

            session.save(rental);

            String genaretedRentalNo = new NumberGenerator().getGenaretedNumber("REN", rental.getRentalId());
            rental.setRentalNo(genaretedRentalNo);
            session.saveOrUpdate(rental);

            list = rental.getRentalDetailsList();
            Iterator<RentalDetails> itr = list.iterator();
            while (itr.hasNext()) {
                RentalDetails detail = itr.next();
                detail.setRentalDetailRef(rental);
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

    public void getAllRental(DefaultTableModel dtm) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Rental r WHERE status=1 ORDER BY rentalNo");//status=1 --> active Supplier
            list = query.list();
            if (!list.isEmpty()) {
                Iterator< Rental> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    Rental rental = (Rental) itr.next();
                    dtm.addRow(new Object[]{rental.getRentalId(), rental.getRentalNo(), rental.getCustomerRef().getCustName(), NumbeFormater.setDateFormat(rental.getRentalCheckin()), NumbeFormater.setDateFormat(rental.getRentalCheckout()), NumbeFormater.formatDoubleToDecimal(rental.getPaymentRef().getTotalAmount()), NumbeFormater.formatDoubleToDecimal(rental.getPaymentRef().getPaidAmount()), NumbeFormater.formatDoubleToDecimal(rental.getPaymentRef().getBalance()), rental.isRentalSubmitted() == true ? "Submitted" : "Not Submitted"});
                }
            }
        } catch (Exception ex) {
            //log.error(ex);
            ex.printStackTrace();
        } finally {
            if (list != null) {
                list.clear();
            }
            session.close();
        }
    }

    public void getRentalDetails(DefaultTableModel dtm, int rentalID) {

        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            SQLQuery query = session.createSQLQuery("SELECT  * FROM   hardware_rental_details rd WHERE  rd.RENTAL_ID= '" + rentalID + "'");
            query.addEntity(RentalDetails.class);

            list = query.list();
            if (!list.isEmpty()) {
                Iterator< RentalDetails> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    RentalDetails rental_Details = itr.next();
                   // System.out.println("product " + rental_Details.getProductRef().getProductName());
                    //System.out.println("QTY " + rental_Details.getQty());
                    dtm.addRow(new Object[]{rental_Details.getProductRef().getProductName(), rental_Details.getProductRef().getProductType(), rental_Details.getProductRef().getProductPrice(), rental_Details.getQty()});
                    
                }
            }
        } catch (Exception ex) {
            //log.error(ex);
            ex.printStackTrace();
        } finally {
            if (list != null) {
                list.clear();
            }
            session.close();
        }
    }

    public Rental findRentalById(int id) {
        Rental rental = null;;
        List<Rental> rentalList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("SELECT r FROM Rental r WHERE RENTAL_ID=:rentId").setParameter("rentId", id);
            rentalList = query.list();
            if (!rentalList.isEmpty()) {
                Iterator<Rental> itr = rentalList.iterator();
                while (itr.hasNext()) {
                    rental = itr.next();
                }
                return rental;
            }
        } catch (Exception ex) {
            // log.error(ex);
            ex.printStackTrace();
        } finally {
            if (rentalList != null) {
                rentalList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return rental;
    }

}
