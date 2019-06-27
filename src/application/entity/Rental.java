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
 * @author Shashiprabha
 */
@Entity
@Table(name = "hardware_rental")

public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTAL_ID")
    private Integer rentalId;

    @Column(name = "RENTAL_NO")
    private String rentalNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customerRef;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PAYMENT_ID")
    private Payment paymentRef;

    @Column(name = "RENTAL_CHECKIN")
    private Date rentalCheckin;

    @Column(name = "RENTAL_CHECKOUT")
    private Date rentalCheckout;

    @Column(name = "RENTAL_SUBMITTED")
    private boolean rentalSubmitted;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rentalDetailRef")
    private List<RentalDetails> rentalDetailsList;

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public String getRentalNo() {
        return rentalNo;
    }

    public void setRentalNo(String rentalNo) {
        this.rentalNo = rentalNo;
    }

    public Customer getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(Customer customerRef) {
        this.customerRef = customerRef;
    }

    public Date getRentalCheckin() {
        return rentalCheckin;
    }

    public void setRentalCheckin(Date rentalCheckin) {
        this.rentalCheckin = rentalCheckin;
    }

    public Date getRentalCheckout() {
        return rentalCheckout;
    }

    public void setRentalCheckout(Date rentalCheckout) {
        this.rentalCheckout = rentalCheckout;
    }

    public boolean isRentalSubmitted() {
        return rentalSubmitted;
    }

    public void setRentalSubmitted(boolean rentalSubmitted) {
        this.rentalSubmitted = rentalSubmitted;
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

    public List<RentalDetails> getRentalDetailsList() {
        return rentalDetailsList;
    }

    public void setRentalDetailsList(List<RentalDetails> rentalDetailsList) {
        this.rentalDetailsList = rentalDetailsList;
    }

    public Payment getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(Payment paymentRef) {
        this.paymentRef = paymentRef;
    }
    

}
