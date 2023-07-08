package com.noraroc.mef.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
