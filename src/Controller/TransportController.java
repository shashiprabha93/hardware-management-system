/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Transport;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class TransportController extends DbCommon{
    
     public int isVehicleExists(Transport transport) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            
            Query query = session.createQuery("FROM Transport  WHERE  VEHICLE_ID != vehicleId AND   VEHICLE_NUMBER = :vNumber  AND STATUS = 1"); //status=1 --> active Supplier
            query.setParameter("vehicleId", transport.getVehicleId() == null ? 0 : transport.getVehicleId());
            query.setParameter("vNumber", transport.getvNumber());
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
    
    public boolean checkVehicleNumber(Transport transport) {
        Session session = null;
        boolean numberAvailable = false;
        try {
            session = super.getHibernateUtil().openReadableDbConnection();
//            Query query = session.createSQLQuery("SELECT * FROM orange_supplier s1 where s1.SUPPLIER_CONTACTNO= :mobile");//status=1 --> active Supplier

            Query query = session.createQuery("FROM Transport WHERE VEHICLE_ID != :vehicleId AND c.VEHICLE_NUMBER != :vNumber"); //status=1 --> active Supplier
            query.setParameter("vehicleId", transport.getVehicleId() == null ? 0 : transport.getVehicleId());
            query.setParameter("vNumber", transport.getvNumber());

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
    
     public Transport findVehicleId(int id) {
        Transport transport = null;
        List<Transport> vehicleList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("FROM Transport WHERE VEHICLE_ID=:vehiclId").setParameter("vehiclId", id);
            vehicleList = query.list();
            if (!vehicleList.isEmpty()) {
                Iterator<Transport> itr = vehicleList.iterator();
                while (itr.hasNext()) {
                    transport = itr.next();
                }
                return transport;
            }
        } catch (Exception ex) {
            // log.error(ex);
            ex.printStackTrace();
        } finally {
            if (vehicleList != null) {
                vehicleList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return transport;
    }

    
    
    
    public void getAllVehicle(DefaultTableModel dtm) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Transport WHERE status=1");//status=1 --> active Customer
            list = query.list();
            if (!list.isEmpty()) {
                Iterator<Transport> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    Transport transport = (Transport) itr.next();
                    dtm.addRow(new Object[]{transport.getVehicleId(), transport.getvNumber(), transport.getBrand(), transport.getModel(),transport.getType()});
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
