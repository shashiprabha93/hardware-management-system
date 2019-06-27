/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Customer;
import application.entity.Supplier;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class CustomerController extends DbCommon{
    
        public int isCustomerExists(Customer customer) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            
            Query query = session.createQuery("FROM Customer  WHERE  CUSTOMER_ID != customerId AND   CUSTOMER_NAME = :custName  AND STATUS = 1"); //status=1 --> active Supplier
            query.setParameter("customerId", customer.getCustomerId() == null ? 0 : customer.getCustomerId());
            query.setParameter("custName", customer.getCustName());
            //query.setParameter("supplierType", supplier.getSupplerType());
            list = query.list();
            if (list.isEmpty()) {
                return 1;
            }
        } catch (Exception ex) {
            //log.error(ex);
            ex.printStackTrace();
            System.out.println("I am fail");
            return -1;
        } finally {
            if (list != null) {
                list.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return 0;
    }
    
    public boolean checkCustomerContact(Customer customer) {
        Session session = null;
        boolean numberAvailable = false;
        try {
            session = super.getHibernateUtil().openReadableDbConnection();
//            Query query = session.createSQLQuery("SELECT * FROM orange_supplier s1 where s1.SUPPLIER_CONTACTNO= :mobile");//status=1 --> active Supplier

            Query query = session.createQuery("FROM Customer WHERE CUSTOMER_ID != :customerId AND c.PHONE != :custPhone"); //status=1 --> active Supplier
            query.setParameter("customerId", customer.getCustomerId() == null ? 0 : customer.getCustomerId());
            query.setParameter("custPhone", customer.getCustPhone());

            List list = query.list();
            if (!list.isEmpty()) {
                numberAvailable = true;
            }

        } catch (Exception ex) {
            //log.error(ex);
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return numberAvailable;
     
    }
    
     public Customer findCustomerById(int id) {
        Customer customer = null;
        List<Customer> customerList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("FROM Customer WHERE CUSTOMER_ID=:customerId").setParameter("customerId", id);
            customerList = query.list();
            if (!customerList.isEmpty()) {
                Iterator<Customer> itr = customerList.iterator();
                while (itr.hasNext()) {
                    customer = itr.next();
                }
                return customer;
            }
        } catch (Exception ex) {
            // log.error(ex);
            ex.printStackTrace();
        } finally {
            if (customerList != null) {
                customerList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return customer;
    }

    
    
    
    public void getAllCustomer(DefaultTableModel dtm) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Customer WHERE status=1 ORDER BY custName");//status=1 --> active Customer
            list = query.list();
            if (!list.isEmpty()) {
                Iterator<Customer> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    Customer customer = (Customer) itr.next();
                    dtm.addRow(new Object[]{customer.getCustomerId(), customer.getCustName(), customer.getCustAddress(), customer.getCustPhone()});
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

    // shashi
    
        public boolean getAllCustomerForCombo(DefaultComboBoxModel cbm) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openReadableDbConnection();
            Query query = session.createQuery("FROM Customer c WHERE STATUS=1");//status=1 --> active Customer
            list = query.list();
            cbm.removeAllElements();
            cbm.addElement("- Select a Customer -");
            if (!list.isEmpty()) {
                Iterator< Customer> itr = list.iterator();
                while (itr.hasNext()) {
                    Customer customer = (Customer) itr.next();
                    cbm.addElement(customer);
                }
            }
            return true;
        } catch (Exception ex) {
            //log.error(ex);
            ex.printStackTrace();
            return false;
        } finally {
            if (list != null) {
                list.clear();
            }
            session.close();
        }
    }
    

}
