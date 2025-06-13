package com.meupet.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vacina")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacinaEntity extends PanacheEntity {

    public String tipoVacina;
    public LocalDate dataVacina;
    public LocalDate revacina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal")
    @JsonBackReference
    public AnimalEntity animal;
}
