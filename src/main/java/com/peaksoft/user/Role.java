package com.peaksoft.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;



    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id,String name) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String getAuthority() {
        return null;
    }
}