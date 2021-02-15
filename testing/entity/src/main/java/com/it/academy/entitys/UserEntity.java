package com.it.academy.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserEntity extends AEntity<Integer>{
    @Column(name="name")
    private String name;


    @Column(name="pet_id")
    private Integer petId;

}
