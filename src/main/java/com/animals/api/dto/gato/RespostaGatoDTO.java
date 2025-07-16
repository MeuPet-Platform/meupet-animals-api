package com.animals.api.dto.gato;

import com.animals.api.dto.animal.RespostaAnimalDTO;
import com.animals.api.enums.TamanhoPeloEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RespostaGatoDTO extends RespostaAnimalDTO {
    private boolean unhasCortadas;
    private boolean gostaDeAgua;
    private TamanhoPeloEnum tamanhoPelo;
}
