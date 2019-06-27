/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "hardware_product")

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUPPLIER_ID")
    private Integer supplerId;

    */
/*    
    REQUIRED PART DONE BY ISHADI
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPPLIER_NAME")
    private Supplier supplierRef;
*/
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_SUPPLIER_ID")
    private Supplier supplierRef;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_TYPE", nullable = false)
    private String productType;

    @Column(name = "PRODUCT_PRICE", nullable = false)
    private String productPrice;

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
    //private Set<Supplier> supplerName;
    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplierRef")
    private List<supplerName> supplerNameList;
*/
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetailRef")
    private List<ProductDetails> productDetailList;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
   /*
    public Customer getSupplierRef() {
        return supplierRef;
    }

    public void setSupplierRef(Supplier supplier) {
        this.supplierRef = supplierRef;
    }
    */
    public Supplier getSupplierRef() {
        return supplierRef;
    }

    public void setSupplierRef(Supplier supplierRef) {
        this.supplierRef = supplierRef;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
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
/*
    @Override
    public String toString() {
        return productName;
    }
*/
    /*
    public List<supplerName> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<ProductDetails> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }
    
*/
    
    /*
    
    REQUIRED PART DONE BY ISHADI
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Product")
	public Set<Supplier> getProductRecords() {
		return this.supplerName;
	}

	public void setProductRecords(Set<Supplier> supplierRecords) {
		this.supplerName = supplierRecords;
	}
*/
    public List<ProductDetails> getPRoductDetailsList() {
        return productDetailList;
    }

    public void setProductDetailsList(List<ProductDetails> productDetailsList) {
        this.productDetailList = productDetailsList;
    }
}
