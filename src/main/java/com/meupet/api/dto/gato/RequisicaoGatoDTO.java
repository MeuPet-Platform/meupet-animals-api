package com.meupet.api.dto.gato;

import com.meupet.api.dto.animal.RequisicaoAnimalDTO;
import com.meupet.api.enums.TamanhoPeloEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoGatoDTO extends RequisicaoAnimalDTO {

    @NotNull(message = "O campo 'unhasCortadas' é obrigatório.")
    private boolean unhasCortadas;

    @NotNull(message = "O campo 'gostaDeAgua' é obrigatório.")
    private boolean gostaDeAgua;

    @NotNull(message = "O tamanho do pelo deve ser informado.")
    private TamanhoPeloEnum tamanhoPelo;
}