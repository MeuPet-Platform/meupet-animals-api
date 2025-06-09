package com.meupet.api.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ave")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AveEntity extends AnimalEntity {

    private boolean asaCortada;
    private boolean emGaiola;
    private boolean exotico;
}
