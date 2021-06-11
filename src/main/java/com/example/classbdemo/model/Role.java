package com.example.classbdemo.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.classbdemo.enumerations.ERoleName;


@Entity
@Table(name = "roles")


public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private ERoleName name;

    public Role(ERoleName name) {
        this.name = name;
    }

    public Role() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERoleName getName() {
        return name;
    }

    public void setName(ERoleName name) {
        this.name = name;
    }

}
