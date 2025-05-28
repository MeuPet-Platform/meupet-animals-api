package com.meupet.api.dto.gato;

import com.meupet.api.dto.animal.RequisicaoAnimalDTO;
import com.meupet.api.enums.TamanhoPeloEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoGatoDTO extends RequisicaoAnimalDTO {

    private boolean unhasCortadas;
    private boolean gostaDeAgua;
    private TamanhoPeloEnum tamanhoPelo;
}
