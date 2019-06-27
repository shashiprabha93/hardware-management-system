/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author User
 */
@Entity
@Table(name = "invoice")
public class Invoice {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVOICE_ID")
    private Integer invoiceId;
    
    @Column(name = "INVOICE_NO")
    private String invoiceNo;
    
    @Column(name = "INVOICE_CHECKIN")
    private Date invoiceCheckin;
    
    @Column(name = "INVOICE_CHECKOUT")
    private Date invoiceCheckout;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customerRef;
    
    @Column(name = "GROSS_TOT")
    private String grossTot;
    
    @Column(name = "NET_TOT")
    private String netTot;
    
    @Column(name = "TOTAL_DISCOUNT")
    private String totalDisc;
    
    @Column(name = "CASH")
    private String cash;
    
    @Column(name = "BALANCE")
    private String balance;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PAYMENT_ID")
    private Payment paymentRef;
    
        
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoiceDetailRef")
    private List<InvoiceDetails> invoiceDetailsList;
    
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

    public Payment getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(Payment paymentRef) {
        this.paymentRef = paymentRef;
    }

    public List<InvoiceDetails> getInvoiceDetailsList() {
        return invoiceDetailsList;
    }

    public void setInvoiceDetailsList(List<InvoiceDetails> invoiceDetailsList) {
        this.invoiceDetailsList = invoiceDetailsList;
    }

    public Date getInvoiceCheckout() {
        return invoiceCheckout;
    }

    public void setInvoiceCheckout(Date invoiceCheckout) {
        this.invoiceCheckout = invoiceCheckout;
    }

    public Date getInvoiceCheckin() {
        return invoiceCheckin;
    }

    public void setInvoiceCheckin(Date invoiceCheckin) {
        this.invoiceCheckin = invoiceCheckin;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Customer getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(Customer customerRef) {
        this.customerRef = customerRef;
    }

    public String getGrossTot() {
        return grossTot;
    }

    public void setGrossTot(String grossTot) {
        this.grossTot = grossTot;
    }

    public String getNetTot() {
        return netTot;
    }

    public void setNetTot(String netTot) {
        this.netTot = netTot;
    }

    public String getTotalDisc() {
        return totalDisc;
    }

    public void setTotalDisc(String totalDisc) {
        this.totalDisc = totalDisc;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
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
