package com.meupet.api.dto.usuario;

import com.meupet.api.dto.animal.RespostaAnimalDTO;
import lombok.Data;

import java.util.List;

@Data
public class RespostaUsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private List<RespostaAnimalDTO> animais;
}