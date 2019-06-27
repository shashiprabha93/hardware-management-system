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
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author User
 */
@Entity
@Table(name="Vehicle")
    
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEHICLE_ID",nullable = false,unique = true)
    private Integer vehicleId;
    
    @Column(name = "VEHICLE_NUMBER",nullable = false)
    private String vNumber;
    
    @Column(name = "BRAND",nullable = false)
    private String brand;
    
    @Column(name = "MODEL",nullable = false)
    private String model;
    
    @Column(name = "TYPE",nullable = false)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name = "STATUS", columnDefinition = "TINYINT(1)", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean status;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getvNumber() {
        return vNumber;
    }

    public void setvNumber(String vNumber) {
        this.vNumber = vNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
    
    
    
}
