package com.meupet.api.entity;

import com.meupet.api.enums.TamanhoPeloEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GatoEntity extends AnimalEntity {

    private boolean unhasCortadas;
    private boolean gostaDeAgua;

    @Enumerated(EnumType.STRING)
    private TamanhoPeloEnum tamanhoPelo;

}
