/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author DELL
 */

@Entity
@Table(name="hardware_stock_details")

class StockDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_DETAIL_ID")
    private Integer stockDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product productDetailRef;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_NAME")
    private Product productRef;

    /*@Column(name = "QTY")
    private Integer qty;
*/

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

    public Integer getStockDetailId() {
        return stockDetailId;
    }

    public void setStockDetailId(Integer stockDetailId) {
        this.stockDetailId = stockDetailId;
    }

    public Product getStockDetailRef() {
        return productDetailRef;
    }

    public void setStockDetailRef(Product productDetailRef) {
        this.productDetailRef = productDetailRef;
    }

    public Product getProductRef() {
        return productRef;
    }

    public void setProductRef(Product productRef) {
        this.productRef = productRef;
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
