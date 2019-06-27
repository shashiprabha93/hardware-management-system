/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Supplier;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import application.entity.Users;

/**
 *
 * @author Malinda
 */
public class UserController extends DbCommon{
        public void getAllUsers(DefaultTableModel dtm) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Users s WHERE status=1");//status=1 --> active Supplier
            list = query.list();
            if (!list.isEmpty()) {
                Iterator<Users> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    Users user = (Users) itr.next();
                    dtm.addRow(new Object[]{user.getUserId(),user.getUserName(), user.getUserPassword(), user.getUserCatergory()});
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
        
            public Users findUserrById(int id) {
        Users users = null;
        List<Users> userList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("SELECT s FROM Users s WHERE User_ID=:userId").setParameter("userId", id);
            userList = query.list();
            if (!userList.isEmpty()) {
                Iterator<Users> itr = userList.iterator();
                while (itr.hasNext()) {
                    users = itr.next();
                }
                return users;
            }
        } catch (Exception ex) {
            // log.error(ex);
            ex.printStackTrace();
        } finally {
            if (userList != null) {
                userList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return users;
    }
    
}
