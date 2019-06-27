/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import application.entity.Employee;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

/**
 *
 * @author Malinda
 */


@ Entity
@ Table (name="hardware_emplyee_Attendance")
public class Attendance implements Serializable {
        
    @EmbeddedId
    private AttendanceId empId;

    public AttendanceId getAttId() {
        return empId;
    }

    public void setAttId(AttendanceId regid) {
        this.empId = regid;
    }
   
    
    
    @Column(name="Employee_Name")
    private String employeeName;
    
    @Column (name="Attendance")
    private String employeeAttendance;
    
    @Column (name="In_Time")
    //@Temporal(TemporalType.TIME)
    //private Date inTime;
    private String inTime;

    @Column (name="Out_Time")
    private String outTime;
    
    @Column (name="No_Of_Hours")
    private String noOfHours;
    
    @Column(name = "Status", columnDefinition = "TINYINT(1)", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean status;
    
    @Column(name = "Main")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean main;
    
    @Column(name = "WORKED_TIME_IN_MINUTES", columnDefinition = "int default 0")
    private int timeInMinutes;

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    } 

    
    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }
    
    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status=status;
    }

   

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAttendance() {
        return employeeAttendance;
    }

    public void setEmployeeAttendance(String employeeAttendance) {
        this.employeeAttendance = employeeAttendance;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(String noOfHours) {
        this.noOfHours = noOfHours;
    }
    
    
}
