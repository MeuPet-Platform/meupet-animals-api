package com.animals.api.dto.cachorro;

import com.animals.api.dto.animal.RespostaAnimalDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RespostaCachorroDTO extends RespostaAnimalDTO {
    private boolean manso;
    private boolean necessitaFocinheira;
}