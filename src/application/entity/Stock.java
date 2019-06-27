/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author DELL
 */

@Entity
@Table(name = "hardware_stock")

public class Stock implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private Integer stockId;
    
    /*
    @Id
    @OneToOne
    @JoinColumn(name = "STOCK_PRODUCTID", nullable = false)
    private Product product;
    */
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STOCK_PRODUCT_NAME")
    private Product productRef;

    /*
    @Column(name = "STOCK_PRODUCTNAME", nullable = false)
    private String stockProductName;
    */
    
    /*
    @Column(name = "STOCK_NAME", nullable = false)
    private String stockName;
    */
    @Column(name = "STOCK_QUANTITY", nullable = false)
    private String quantity;
    
    @Column(name = "STOCK_MRP", nullable = false)
    private String stockMrp;

    @Column(name = "STOCK_DISCOUNT", nullable = false)
    private String stockDiscount;
    
    
    @Column(name = "CREATED_AT", columnDefinition = "DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UPDATED_AT", columnDefinition = "DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "DELETED_AT", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @Column(name = "STATUS", columnDefinition = "TINYINT(1)", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetailRef")
    private List<StockDetails> stockDetailsList;

    public List<StockDetails> getStockDetailsList() {
        return stockDetailsList;
    }

    public void setStockDetailsList(List<StockDetails> stockDetailsList) {
        this.stockDetailsList = stockDetailsList;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Product getProductRef() {
        return productRef;
    }

    public void setProductRef(Product productRef) {
        this.productRef = productRef;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStockMrp() {
        return stockMrp;
    }

    public void setStockMrp(String stockMrp) {
        this.stockMrp = stockMrp;
    }

    public String getStockDiscount() {
        return stockDiscount;
    }

    public void setStockDiscount(String stockDiscount) {
        this.stockDiscount = stockDiscount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
}
