package com.animals.api.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.animals.api.enums.PorteEnum;
import com.animals.api.enums.SexoAnimalEnum;
import com.animals.api.enums.StatusVacinacaoEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "animal")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class AnimalEntity extends PanacheEntity {

    protected String nome;
    protected String raca;
    protected double peso;

    @Enumerated(EnumType.STRING)
    protected SexoAnimalEnum sexo;

    @Enumerated(EnumType.STRING)
    protected StatusVacinacaoEnum vacinado;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<VacinaEntity> historicoVacinacao;

    @Enumerated(EnumType.STRING)
    private PorteEnum porte;

    private Long idTutor;

}
