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
 * @author Malinda
 */
@Entity
@Table(name = "hardware_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    
    private Integer EmployeeId;
    
    public void setEmployeeId(int id){
        this.EmployeeId=id;
    }

    public Integer getEmployeeId() {
        return EmployeeId;

    }

    @Column(name = "Employee_Name", nullable = false)
    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Column(name = "Employee_Contact_No")
    private String employeeContactNo;

    public String getEmpployeeCon() {
        return employeeContactNo;
    }
    
    public void setEmployeeCon(String employeeContactNo ){
        this.employeeContactNo=employeeContactNo;
    
    }
    @Column(name = "Employee_Address")
    private String employeeAddress;
    
    public String getEmployeeAddr()  {
        return employeeAddress;
    }
    
    public void setEmployeeAddr(String employeeAddress){
        this.employeeAddress=employeeAddress;
    
    }
    @Column(name = "NIC", nullable = false)
    private String Nic;
    
    public String getNic() {
        return Nic;
    
    }

    public void setEmployeeNic(String Nic) {
        this.Nic=Nic;
    
    }
    @Column(name = "Gender")
    private String gender;
    
    public String getEmployeeGender() {
        return gender;
    }
    
    public void setEmployeeGender(String gender) {
        this.gender=gender;
    }
    
    @Column (name="Date_of_Birth")
    private String dOB;
    
    public String getDOB(){
        return dOB;
    }
    
    public void setDOB(String dateOfBirth){
        this.dOB=dateOfBirth;
    }
    
    @Column (name="Martial_Status")
    private String martialStatus;
    
    public String getMartialStatus(){
        return martialStatus;
    }
    
    public void setMartialStatus(String martialStatus){
        this.martialStatus=martialStatus;
    
    }
    
    @Column (name = "Current_Status")
    private String currentStatus;
    
    public String getCurrentStatus(){
        return currentStatus;
    }
    
    public void setCurrentStatus(String currentStatus){
        this.currentStatus=currentStatus;
    }
    
    @Column(name = "Basic_Sal", nullable = false)
    private Float basicSal;
    
    

    public Float getBasicSal() {
        return basicSal;
    }

    public void setBasicSal(Float basicSal) {
        this.basicSal = basicSal;
    }
    
    @Column(name="Bonus")
        private Float bonus;

    public Float getBonus() {
        return bonus;
    }

    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }
        
    
    @Column(name = "Created_At", columnDefinition = "DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    public Date getCreatedDate() {
        return CreatedAt;
    }
    
    public void setCreatedDate(Date CreatedAt) {
        this.CreatedAt=CreatedAt;   
    }
   
    
    @Column(name = "Deleted_At", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public Date getDeletedDate() {
        return deletedAt;
    }
    
    @Column(name = "Status", columnDefinition = "TINYINT(1)", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean status;
    
    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status=status;
    } 
}
