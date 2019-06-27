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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author Shashiprabha-PC
 */
@Entity
@Table(name = "hardware_supplier")
public class Supplier implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUPPLIER_ID")
    private Integer supplerId;

   /*
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_NAME", nullable = false)
	public Stock getStock() {
		return this.stock;
	}
    */
    //@ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "SUPPLIER_NAME", nullable = false)
    private String supplerName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplierRef")
    private List<Product> productList;

    @Column(name = "SUPPLIER_CONTACTNO")
    private String supplerContactNo;

    @Column(name = "SUPPLIER_ADDRESS")
    private String supplerAddress;

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

    public Integer getSupplerId() {
        return supplerId;
    }

    public void setSupplerId(Integer supplerId) {
        this.supplerId = supplerId;
    }

    public String getSupplerName() {
        return supplerName;
    }

    public void setSupplerName(String supplerName) {
        this.supplerName = supplerName;
    }

    public String getSupplerContactNo() {
        return supplerContactNo;
    }

    public void setSupplerContactNo(String supplerContactNo) {
        this.supplerContactNo = supplerContactNo;
    }

    public String getSupplerAddress() {
        return supplerAddress;
    }

    public void setSupplerAddress(String supplerAddress) {
        this.supplerAddress = supplerAddress;
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
    @Override
    public String toString() {
        return supplerName;
    }
  


    
}
