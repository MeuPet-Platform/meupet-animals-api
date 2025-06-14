package com.meupet.api.dto.usuario;

import com.meupet.api.dto.animal.RespostaAnimalDTO;
import lombok.Data;

import java.util.List;

@Data
public class RespostaUsuarioDTO extends RespostaUsuarioResumoDTO {

    private List<RespostaAnimalDTO> animais;
}