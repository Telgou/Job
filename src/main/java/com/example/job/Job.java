package com.example.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {
    private static final long serialVersionID = 6;

    @Id
    @GeneratedValue
    private int ID;

    private String Service;
    private Boolean Etat;

    public Job(String Service, Boolean Etat) {
    }


}