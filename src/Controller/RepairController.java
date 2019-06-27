/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Repair;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DELL
 */
public class RepairController extends DbCommon{
    
    public int isRepairExists(Repair repair) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Repair r WHERE REPAIR_ID != :repairId AND REPAIR_NAME= :repairName  AND STATUS=1"); //status=1 --> active Supplier
            query.setParameter("repairId", repair.getRepairId() == null ? 0 : repair.getRepairId());
            query.setParameter("repairName", repair.getRepairName());
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

    public boolean checkRepairMobile(Repair repair) {
        Session session = null;
        boolean numberAvailable = false;
        try {
            session = super.getHibernateUtil().openReadableDbConnection();
//            Query query = session.createSQLQuery("SELECT * FROM orange_supplier s1 where s1.SUPPLIER_CONTACTNO= :mobile");//status=1 --> active Supplier

            Query query = session.createQuery("FROM Repair r WHERE REPAIR_ID != :repairId AND repairPhone = :mobile"); //status=1 --> active Supplier
            query.setParameter("repairId", repair.getRepairId() == null ? 0 : repair.getRepairId());
            query.setParameter("mobile", repair.getRepairPhone());

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

    public Repair findRepairById(int id) {
        Repair repair = null;
        List<Repair> repairList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("SELECT r FROM Repair r WHERE REPAIR_ID=:repairId").setParameter("repairId", id);
            repairList = query.list();
            if (!repairList.isEmpty()) {
                Iterator<Repair> itr = repairList.iterator();
                while (itr.hasNext()) {
                    repair = itr.next();
                }
                return repair;
            }
        } catch (Exception ex) {
            // log.error(ex);
            ex.printStackTrace();
        } finally {
            if (repairList != null) {
                repairList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return repair;
    }

    public void getAllRepair(DefaultTableModel dtm) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Repair r WHERE status=1  ORDER BY repairName");//status=1 --> active Supplier
            list = query.list();
            if (!list.isEmpty()) {
                Iterator< Repair> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    Repair repair = (Repair) itr.next();
                    System.out.println(repair.getRepairName());
                    
                    dtm.addRow(new Object[]{repair.getRepairId(), repair.getRepairName(), repair.getRepairPhone(), repair.getRepairSubmitdate(), repair.getRepairDuedate(), repair.getRepairNotes()});
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
