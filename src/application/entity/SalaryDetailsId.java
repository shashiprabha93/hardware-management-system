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
public class SalaryDetailsId implements Serializable{
    @Column(name = "Year")
    private int salYear;
    
    @Column(name = "Employee_ID")
    private int empId;
    
    @Column(name = "Month")
    private int salMonth;

    public int getSalYear() {
        return salYear;
    }

    public void setSalYear(int salYear) {
        this.salYear = salYear;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Integer getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(Integer salMonth) {
        this.salMonth = salMonth;
    }
    
    public SalaryDetailsId(){}
    
    public SalaryDetailsId(int salYear, int empId, Integer salMonth){
        this.empId=empId;
        this.salMonth=salMonth;
        this.salYear=salYear;
    
    }
}
