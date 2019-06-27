/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "hardware_otherexpenses")

public class OtherExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXPENSES_ID")
    private Integer expenseId;

    @Column(name = "EXPENSES_DATE", nullable = false)
    private String expenseDate;

    @Column(name = "EXPENSES_ELECTRICITTY", nullable = false)
    private String expenseElectricity;

    @Column(name = "EXPENSES_WATER",nullable = false)
    private String expenseWater;

    @Column(name = "EXPENSES_INSURANCE")
    private String expenseInsurance;

    @Column(name = "EXPENSES_RENTAL")
    private String expenseRental;

    @Column(name = "EXPENSES_OTHER")
    private String expenseOther;
    
    @Column(name = "EXPENSES_TOTAL")
    private String expenseTotal;

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

    
    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseElectricity() {
        return expenseElectricity;
    }

    public void setExpenseElectricity(String expenseElectricity) {
        this.expenseElectricity = expenseElectricity;
    }

    public String getExpenseWater() {
        return expenseWater;
    }

    public void setExpenseWater(String expenseWater) {
        this.expenseWater = expenseWater;
    }

    public String getExpenseInsurance() {
        return expenseInsurance;
    }

    public void setExpenseInsurance(String expenseInsurance) {
        this.expenseInsurance = expenseInsurance;
    }

    public String getExpenseRental() {
        return expenseRental;
    }

    public void setExpenseRental(String expenseRental) {
        this.expenseRental = expenseRental;
    }

    public String getExpenseOther() {
        return expenseOther;
    }

    public void setExpenseOther(String expenseOther) {
        this.expenseOther = expenseOther;
    }
    public String getExpenseTotal() {
        return expenseTotal;
    }

    public void setExpenseTotal(String expenseTotal) {
        this.expenseTotal = expenseTotal;
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
