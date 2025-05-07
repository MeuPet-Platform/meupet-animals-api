package main.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Pet extends PanacheEntity {
    public String nome;
    public String tipo;
}
