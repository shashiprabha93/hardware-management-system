/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Malinda
 */
@Entity
@Table (name = "hardware_salary_Details")
public class SalaryDetails implements Serializable{
    
    @EmbeddedId
    private SalaryDetailsId salId;
    
    @Column(name="Salary")
    private Float salary;

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
    
    

    public SalaryDetailsId getSalId() {
        return salId;
    }

    public void setSalId(SalaryDetailsId salId) {
        this.salId = salId;
    }
    
    
    
    
    
    
}
