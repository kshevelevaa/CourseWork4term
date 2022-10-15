package com.example.demo.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String username;
    private String password;
    @Transient
    private String passwordConfirm;
    private String email;
    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Dress> list = new HashSet<Dress>();

    public User() {
    }

    public User(String username, String password, String passwordConfirm, String email) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public Set<Dress> getList() {
        return list;
    }

    public void setList(Set<Dress> list) {
        this.list = list;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDressCount(int dressNumber) {
        for (Dress item : list) {
            if (item.getDressNumber() == dressNumber) {
                return item.getDressCount();
            }
        }
        return 0;
    }

    public Dress getDress(int dressNumber) {
        for (Dress item : list) {
            if (item.getDressNumber() == dressNumber)
                return item;
        }
        return null;
    }

    public String getOrderPrice() {
        int total = 0;
        for (Dress item : this.list) {
            String temp = item.getPriceForManyDresses().replace(" руб.", "");
            total += Integer.parseInt(temp);
        }
        return total + " руб.";
    }
}
