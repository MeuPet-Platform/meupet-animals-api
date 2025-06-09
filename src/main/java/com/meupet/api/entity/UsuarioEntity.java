package com.meupet.api.entity;

import com.meupet.api.dto.animal.RequisicaoAnimalDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity extends PanacheEntity {

    public String nome;
    public String email;
    public String senha;

    public List<RequisicaoAnimalDTO> animais;

}
