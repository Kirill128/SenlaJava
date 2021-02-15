package eu.it.academy.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "user")
public class User extends AEntity<Integer> {

    @Column(name = "name")
    private String firstName;
    @Column(name = "salary")
    private int salary;
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Pet> pets;
}
