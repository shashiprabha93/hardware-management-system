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
 * @author Shashiprabha
 */
@Entity
@Table(name="hardware_rental_details")
public class RentalDetails  {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTAL_DETAIL_ID")
    private Integer rentalDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RENTAL_ID")
    private Rental rentalDetailRef;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product productRef;

     @Column(name = "QTY")
    private Integer qty;


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

    public Integer getRentalDetailId() {
        return rentalDetailId;
    }

    public void setRentalDetailId(Integer rentalDetailId) {
        this.rentalDetailId = rentalDetailId;
    }

    public Rental getRentalDetailRef() {
        return rentalDetailRef;
    }

    public void setRentalDetailRef(Rental rentalDetailRef) {
        this.rentalDetailRef = rentalDetailRef;
    }

    public Product getProductRef() {
        return productRef;
    }

    public void setProductRef(Product productRef) {
        this.productRef = productRef;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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
