/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Product;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DELL
 */
public class ProductController extends DbCommon {
 
    
    public int isProductExists(Product product) {
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Product p WHERE PRODUCT_ID != :productId AND PRODUCT_NAME= :productName  AND STATUS=1"); //status=1 --> active Supplier
            query.setParameter("productId", product.getProductId() == null ? 0 : product.getProductId());
            query.setParameter("productName", product.getProductName());
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
/*
    public boolean checkSupplierMobile(Supplier supplier) {
        Session session = null;
        boolean numberAvailable = false;
        try {
            session = super.getHibernateUtil().openReadableDbConnection();
//            Query query = session.createSQLQuery("SELECT * FROM orange_supplier s1 where s1.SUPPLIER_CONTACTNO= :mobile");//status=1 --> active Supplier

            Query query = session.createQuery("FROM Supplier s WHERE SUPPLIER_ID != :supplierId AND supplerContactNo = :mobile"); //status=1 --> active Supplier
            query.setParameter("supplierId", supplier.getSupplerId() == null ? 0 : supplier.getSupplerId());
            query.setParameter("mobile", supplier.getSupplerContactNo());

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
*/
    public Product findProductById(int id) {
        Product product = null;
        List<Product> productList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try {
            Query query = session.createQuery("SELECT p FROM Product p WHERE PRODUCT_ID=:productId").setParameter("productId", id);
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

    public void getAllProducts(DefaultTableModel dtm) {
        
        List list = null;
        Session session = null;
        try {
            session = super.getHibernateUtil().openWritebleDbConnection();
            Query query = session.createQuery("FROM Product WHERE status= 1 ORDER BY productName ");//status=1 --> active Supplier
            list = query.list();
            if (!list.isEmpty()) {
                Iterator< Product> itr = list.iterator();
                dtm.setRowCount(0);
                while (itr.hasNext()) {
                    Product product = (Product) itr.next();
                    System.out.println(product.getProductName());
                    dtm.addRow(new Object[]{product.getProductId(), product.getProductName(), product.getProductType(), product.getProductPrice()});
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
