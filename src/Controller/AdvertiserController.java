/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Employee;
import application.entity.Attendance;
import application.entity.SalaryDetails;
import application.forms.Employee.EmployeeSalaryDetails;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jpa.criteria.expression.function.AggregationFunction;
import application.entity.Advertiser;
import application.entity.AdvertisersNewsPaper;
import application.entity.AdvertisersTvChannel;
import application.entity.AdvertisersDisplays;
import application.entity.AdvertisersOnline;
import application.entity.AdvertisersPoster;

/**
 *
 * @author Malinda
 */
public class AdvertiserController extends DbCommon {

    public void getAllAdvertisers(DefaultTableModel dtm, String table) {
        List list = null;
        Session session = null;
        Query query = null;
        String tableName = null;
        
        if (table.equals("News Paper")) {
            tableName = "AdNewsPaper";
            try {

                JOptionPane.showMessageDialog(null, "Table name" + tableName);
                session = super.getHibernateUtil().openWritebleDbConnection();
                query = session.createQuery("From " + tableName + " Where status = 1 ORDER BY user_id");

                list = query.list();
                //JOptionPane.showMessageDialog(null, "list is "+addvertiserList);
                if (!list.isEmpty()) {
                    Iterator<AdvertisersNewsPaper> itr = list.iterator();
                    dtm.setRowCount(0);
                    while (itr.hasNext()) {
                        AdvertisersNewsPaper adNewsPaper = (AdvertisersNewsPaper) itr.next();
                        dtm.addRow(new Object[]{adNewsPaper.getNewsPaperName(), adNewsPaper.getSize(),adNewsPaper.getContactNumber(), adNewsPaper.getCost()});

                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {
                if (list != null) {
                    list.clear();
                }
                session.close();
            }
            
            
        } else if (table.equals("TV Channel")) {
            tableName = "AdTvChannel";

            try {

                JOptionPane.showMessageDialog(null, "Table name" + tableName);
                session = super.getHibernateUtil().openWritebleDbConnection();
                query = session.createQuery("From " + tableName + " Where status = 1 ORDER BY user_id");

                list = query.list();
                //JOptionPane.showMessageDialog(null, "list is "+addvertiserList);
                if (!list.isEmpty()) {
                    Iterator<AdvertisersTvChannel> itr = list.iterator();
                    dtm.setRowCount(0);
                    while (itr.hasNext()) {
                        AdvertisersTvChannel adTvChannel = (AdvertisersTvChannel) itr.next();
                        dtm.addRow(new Object[]{adTvChannel.getChannelName(), adTvChannel.getCostPerDay(), adTvChannel.getContactNumber(), adTvChannel.getFrequency()});

                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {
                if (list != null) {
                    list.clear();
                }
                session.close();
            }
        } else if (table.equals("Poster")) {
            tableName = "AdPoster";
            
            try {

                JOptionPane.showMessageDialog(null, "Table name" + tableName);
                session = super.getHibernateUtil().openWritebleDbConnection();
                query = session.createQuery("From " + tableName + " Where status = 1 ORDER BY user_id");

                list = query.list();
                //JOptionPane.showMessageDialog(null, "list is "+addvertiserList);
                if (!list.isEmpty()) {
                    Iterator<AdvertisersPoster> itr = list.iterator();
                    dtm.setRowCount(0);
                    while (itr.hasNext()) {
                        AdvertisersPoster adPoster = (AdvertisersPoster) itr.next();
                        dtm.addRow(new Object[]{adPoster.getName(), adPoster.getContactNumber(), adPoster.getSize(), adPoster.getCost()});

                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {
                if (list != null) {
                    list.clear();
                }
                session.close();
            }
        } else if (table.equals("Display")) {
            tableName = "AdDisplays";
            try {

                JOptionPane.showMessageDialog(null, "Table name" + tableName);
                session = super.getHibernateUtil().openWritebleDbConnection();
                query = session.createQuery("From " + tableName + " Where status = 1 ORDER BY user_id");

                list = query.list();
                //JOptionPane.showMessageDialog(null, "list is "+addvertiserList);
                if (!list.isEmpty()) {
                    Iterator<AdvertisersDisplays> itr = list.iterator();
                    dtm.setRowCount(0);
                    while (itr.hasNext()) {
                        AdvertisersDisplays adDisplays = (AdvertisersDisplays) itr.next();
                        dtm.addRow(new Object[]{adDisplays.getName(), adDisplays.getSize(), adDisplays.getTimes(), adDisplays.getDuration(), adDisplays.getCost(), adDisplays.getContactNumber()});

                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {
                if (list != null) {
                    list.clear();
                }
                session.close();
            }
        } else if (table.equals("Online")) {
            tableName = "AdOnline";
            try {

                JOptionPane.showMessageDialog(null, "Table name" + tableName);
                session = super.getHibernateUtil().openWritebleDbConnection();
                query = session.createQuery("From " + tableName + " Where status = 1 ORDER BY user_id");

                list = query.list();
                //JOptionPane.showMessageDialog(null, "list is "+addvertiserList);
                if (!list.isEmpty()) {
                    Iterator<AdvertisersOnline> itr = list.iterator();
                    dtm.setRowCount(0);
                    while (itr.hasNext()) {
                        AdvertisersOnline adOnline = (AdvertisersOnline) itr.next();
                        dtm.addRow(new Object[]{adOnline.getWebsite(),adOnline.getTimes(), adOnline.getCost(), adOnline.getContactNumber()});

                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {
                if (list != null) {
                    list.clear();
                }
                session.close();
            }
        }
       

    }

}
