/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author User
 */
@Entity
@Table(name = "hardware_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false, unique = true)
    private Integer customerId;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String custName;

    @Column(name = "ADDRESS", nullable = false)
    private String custAddress;

    @Column(name = "PHONE", nullable = false)
    private String custPhone;

    @Column(name = "STATUS", columnDefinition = "TINYINT(1)", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean status;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerRef")
    private List<Rental> rentalList;

//    @Column(name = "CREATED_AT", columnDefinition = "DATETIME", nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt;
//
//    @Column(name = "UPDATED_AT", columnDefinition = "DATETIME", nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedAt;
//
//    @Column(name = "DELETED_AT", columnDefinition = "DATETIME")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date deletedAt;
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return custName;
    }

}
