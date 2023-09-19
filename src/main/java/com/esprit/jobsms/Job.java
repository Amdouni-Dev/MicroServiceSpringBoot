package com.esprit.jobsms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue
    private int  id;
private String Service;
private Boolean Etat;

    public Job() {
    }

    public Job(String service, Boolean etat) {
        Service = service;
        Etat = etat;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public Boolean getEtat() {
        return Etat;
    }

    public void setEtat(Boolean etat) {
        Etat = etat;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
