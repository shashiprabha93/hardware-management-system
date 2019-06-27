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
@Table(name = "hardware_repair")

public class Repair {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPAIR_ID")
    private Integer repairId;
    
    @Column(name = "REPAIR_NAME", nullable = false)
    private String repairName;
    
    @Column(name = "REPAIR_PHONE", nullable = false, length=10)
    private String repairPhone;
    
    @Column(name = "REPAIR_SUBDATE", nullable = false)
    private String repairSubmitdate;
    
    @Column(name = "REPAIR_DUEDATE", nullable = false)
    private String repairDuedate;

    @Column(name = "REPAIR_NOTES", nullable = false)
    private String repairNotes;
    
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

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

    public String getRepairSubmitdate() {
        return repairSubmitdate;
    }

    public void setRepairSubmitdate(String repairSubmitdate) {
        this.repairSubmitdate = repairSubmitdate;
    }

    public String getRepairDuedate() {
        return repairDuedate;
    }

    public void setRepairDuedate(String repairDuedate) {
        this.repairDuedate = repairDuedate;
    }
    public String getRepairNotes() {
        return repairNotes;
    }

    public void setRepairNotes(String repairNotes) {
        this.repairNotes = repairNotes;
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
