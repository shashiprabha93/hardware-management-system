/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Malinda
 */
@Embeddable
public class AttendanceId implements Serializable{
        
        @Column(name = "Employee_Id")
        private int empId;

        @Column(name = "AttDate")
        private String attDate;

        // Create getters and Setters 

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getAttDate() {
        return attDate;
    }

    public void setAttDate(String attDate) {
        this.attDate = attDate;
    }

    public AttendanceId(){}
    
    public AttendanceId(Integer employeeId, String attDate){
        this.empId=employeeId;
        this.attDate=attDate;
    
    }
}