package com.example.junitmock.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@EqualsAndHashCode
public class A {
   @Id
   @GeneratedValue
   @Column(name = "a_id_PK")
   private long aId;
    String name;
    String address;
    @JsonManagedReference // this for parent to avoid infinite recursion
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "b_id_FK") // B table foreign key in A table
    B b;
}
