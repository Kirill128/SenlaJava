package com.it.academy.entitys;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name="users")
public class UserEntity extends AEntity<Integer>{
    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PetEntity> pets;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PetEntity> getPets() {
        return pets;
    }

    public void setPets(List<PetEntity> pets) {
        this.pets.clear();
        this.pets.addAll(pets);
    }

}
