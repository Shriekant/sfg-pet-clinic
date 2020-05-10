package com.dfinite.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="types")
public class PetType extends BaseEntity {
    @Column(name="name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
