/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.OtherExpenses;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DELL
 */
public class OtherExpensesController extends DbCommon {
    
 public int isOtherExpensesExists(OtherExpenses otherExpenses) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM OtherExpenses o WHERE EXPENSES_ID != :expenseId AND EXPENSES_DATE= :expenseDate  AND STATUS=1"); //status=1 --> active Supplier
            query.setParameter("expenseId", otherExpenses.getExpenseId() == null ? 0 : otherExpenses.getExpenseId());
            query.setParameter("expenseDate", otherExpenses.getExpenseDate());
            //query.setParameter("supplierType", supplier.getSupplerType());
            list = query.list();
           
            if (list.isEmpty()) {
                return 1;
            }
            
        } catch (Exception ex) {
            //log.error(ex);
            ex.printStackTrace();
            return -1;
        } finally {
            if (list != null) {
                list.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return 0;
    }
    
    public OtherExpenses findOtherExpensesById(int id) {
        OtherExpenses otherExpenses = null;
        List<OtherExpenses> otherExpensesList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("SELECT o FROM OtherExpenses o WHERE EXPENSES_ID=:expenseId").setParameter("expenseId", id);
            otherExpensesList = query.list();
            if (!otherExpensesList.isEmpty()) {
                Iterator<OtherExpenses> itr = otherExpensesList.iterator();
                while (itr.hasNext()) {
                    otherExpenses = itr.next();
                }
                return otherExpenses;
            }
        } catch (Exception ex) {
            // log.error(ex);
            ex.printStackTrace();
        } finally {
            if (otherExpensesList != null) {
                otherExpensesList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return otherExpenses;
    }

    public void getAllOtherExpenses(DefaultTableModel dtm) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM OtherExpenses o WHERE status=1 ORDER BY expenseDate");//status=1 --> active Supplier
            list = query.list();
            if (!list.isEmpty()) {
                Iterator< OtherExpenses> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    OtherExpenses otherExpenses = (OtherExpenses) itr.next();
                    dtm.addRow(new Object[]{otherExpenses.getExpenseId(), otherExpenses.getExpenseDate(), otherExpenses.getExpenseElectricity(), otherExpenses.getExpenseWater(), otherExpenses.getExpenseInsurance(), otherExpenses.getExpenseRental(), otherExpenses.getExpenseOther(), otherExpenses.getExpenseTotal()});
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

   
}