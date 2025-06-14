package com.meupet.api.dto.gato;

import com.meupet.api.dto.animal.RespostaAnimalDTO;
import com.meupet.api.enums.TamanhoPeloEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RespostaGatoDTO extends RespostaAnimalDTO {
    private boolean unhasCortadas;
    private boolean gostaDeAgua;
    private TamanhoPeloEnum tamanhoPelo;
}
