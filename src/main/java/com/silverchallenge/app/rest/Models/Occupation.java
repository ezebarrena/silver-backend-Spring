package com.silverchallenge.app.rest.Models;

import jakarta.persistence.*;

@Entity
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String occupation;

    public long getId(){
        return id;
    }
    public String getOccupation(){
        return occupation;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setOccupation(String occupation){
        this.occupation = occupation;
    }
}
