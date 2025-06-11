package com.meupet.api.entity;

import com.meupet.api.enums.PorteEnum;
import com.meupet.api.enums.SexoAnimalEnum;
import com.meupet.api.enums.StatusVacinacaoEnum;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    public UsuarioEntity tutor;

}
