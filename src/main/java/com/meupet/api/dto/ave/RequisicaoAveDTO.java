package com.meupet.api.dto.ave;

import com.meupet.api.dto.animal.RequisicaoAnimalDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoAveDTO extends RequisicaoAnimalDTO {

    @NotNull(message = "O campo 'asaCortada' é obrigatório.")
    private boolean asaCortada;

    @NotNull(message = "O campo 'emGaiola' é obrigatório.")
    private boolean emGaiola;

    @NotNull(message = "O campo 'exotico' é obrigatório.")
    private boolean exotico;
}