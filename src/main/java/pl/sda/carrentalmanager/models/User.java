package pl.sda.carrentalmanager.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User{

    @Id
    private String login;
    private String password;
    @ManyToOne(targetEntity = Role.class)
    private Role role;
}
