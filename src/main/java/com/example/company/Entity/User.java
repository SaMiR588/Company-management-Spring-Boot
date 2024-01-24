package com.example.company.Entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
@Table(name="user", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String UserName;
    private String email;
    private String adress;
    private int mobile;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Role> roles;

    public User(int userId, String userName, String email, String adress, int mobile,
                String password, Collection<Role> roles) {
        super();
        this.userId = userId;
        this.UserName = userName;
        this.email = email;
        this.adress = adress;
        this.mobile = mobile;
        this.password = password;
        this.roles = roles;
    }
    public Collection<Role> getRoles() {
        return roles;
    }
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    public User() {
    }


}