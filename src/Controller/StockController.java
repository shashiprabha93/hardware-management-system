/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Stock;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import application.entity.Product;

/**
 *
 * @author DELL
 */
public class StockController extends DbCommon{
    /*
      public int isStockExists(Stock stock) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Stock st WHERE STOCK_ID != :stockId AND STATUS=1"); //status=1 --> active Supplier
            query.setParameter("stockId", stock.getStockId() == null ? 0 : stock.getStockId());
            //query.setParameter("supplierName", supplier.getSupplerName());
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
*/
    public Stock findStockById(int id) {
        Stock stock = null;
        List<Stock> stockList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("SELECT st FROM Stock st WHERE STOCK_ID=:stockId").setParameter("stockId", id);
            stockList = query.list();
            if (!stockList.isEmpty()) {
                Iterator<Stock> itr = stockList.iterator();
                while (itr.hasNext()) {
                    stock = itr.next();
                }
                return stock;
            }
        } catch (Exception ex) {
           // log.error(ex);
            ex.printStackTrace();
        } finally {
            if (stockList != null) {
                stockList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return stock;
    }

public void getAllStock(DefaultTableModel dtm) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Stock s WHERE status=1");//status=1 --> active Supplier
            list = query.list();
            if (!list.isEmpty()) {
                Iterator< Stock> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    Stock stock = (Stock) itr.next();
                    dtm.addRow(new Object[]{stock.getStockId(),stock.getProductRef().getProductId(),stock.getProductRef().getProductName(), stock.getQuantity(), stock.getStockMrp(),stock.getStockDiscount()});
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

public Product findProductrById(int id) {
        Product product = null;
        List<Product> productList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("SELECT s FROM Product s WHERE PRODUCT_ID=:proId").setParameter("proId", id);
            productList = query.list();
            if (!productList.isEmpty()) {
                Iterator<Product> itr = productList.iterator();
                while (itr.hasNext()) {
                    product = itr.next();
                }
                return product;
            }
        } catch (Exception ex) {
            // log.error(ex);
            ex.printStackTrace();
        } finally {
            if (productList != null) {
                productList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        return product;
    }

    
}
