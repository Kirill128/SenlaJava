package com.it.academy.entitys;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name="pets")
public class PetEntity extends AEntity<Integer>{
    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER  )
    @JoinColumn(name="user_id")
    private UserEntity user;

}
