package com.it.academy.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pets")
public class PetEntity extends AEntity<Integer>{
    @Column(name="name")
    private String name;

    @Column(name="user_id")
    private Integer petId;

}
